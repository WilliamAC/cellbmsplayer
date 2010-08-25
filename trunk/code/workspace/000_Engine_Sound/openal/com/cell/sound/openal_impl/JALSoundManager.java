package com.cell.sound.openal_impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import net.java.games.joal.AL;
import net.java.games.joal.ALC;
import net.java.games.joal.ALCcontext;
import net.java.games.joal.ALCdevice;
import net.java.games.joal.ALException;
import net.java.games.joal.ALFactory;
import net.java.games.joal.util.ALut;

import com.cell.CIO;
import com.cell.sound.IPlayer;
import com.cell.sound.ISound;
import com.cell.sound.SoundInfo;
import com.cell.sound.SoundManager;
import com.cell.sound.decoder.ogg_impl.OggDecoder;
import com.cell.sound.mute_impl.NullPlayer;
import com.cell.sound.mute_impl.NullSound;
import com.cell.util.Pair;


public class JALSoundManager extends SoundManager
{  
	static JALSoundManager instance;
	
	public static JALSoundManager getInstance() throws Throwable{
		if (instance == null) {
			instance = new JALSoundManager();
		}
		return instance;
	}
	
//	--------------------------------------------------------------------------------------------------
	
	final AL					al;
	
	ALC							alc;
	
	ArrayList<JALPlayer>		players 	= new ArrayList<JALPlayer>(255);

	OggDecoder 					ogg_decoder = new OggDecoder();

//	--------------------------------------------------------------------------------------------------
	
	private JALSoundManager() throws Exception
	{
	    // Initialize OpenAL and clear the error bit.
		al 	= ALFactory.getAL();
		alc	= ALFactory.getALC();
		ALut.alutInit();
		{
			initDevice();
			
			initListeners();
		    
			initPlayers();
		}			
	}
	
	// set device, find device with the maximum source
	private void initDevice()
	{
		String[] devices = alc.alcGetDeviceSpecifiers();
		checkError(al);
		
		DeviceInfo max_device_info = null;
		
		for (int i = 0; i < devices.length; i++)
		{
			try {
				DeviceInfo device_info = new DeviceInfo(devices[i]);
				device_info.open();
				System.out.println(device_info);
				try {
					if (max_device_info == null || 
						max_device_info.getMonoSources()<device_info.getMonoSources()) {
						max_device_info = device_info;
					}
				} finally {
					device_info.close();
				}
			} catch (ALException err) {
				System.err.println("open device error : " + devices[i]);
			}
		}
		
		System.out.println("Enable OpenAL Device : " + max_device_info.getName());
		max_device_info.open();
		ALCcontext context = max_device_info.createContext();
		if (context != null) {
			alc.alcMakeContextCurrent(context);
		}
		if (checkError(al)) {
			throw new ALException("Error making OpenAL context current");
		}
	}
	
	
	
	// set listeners
	private void initListeners()
	{
		// Position of the listener.
    	float[] listenerPos = { 0.0f, 0.0f, 0.0f };
    	// Velocity of the listener.
    	float[] listenerVel = { 0.0f, 0.0f, 0.0f };
    	// Orientation of the listener. (first 3 elems are "at", second 3 are "up")
    	float[] listenerOri = { 0.0f, 0.0f, -1.0f, 0.0f, 1.0f, 0.0f };

    	al.alListenerfv(AL.AL_POSITION, 	listenerPos, 0);
	    al.alListenerfv(AL.AL_VELOCITY, 	listenerVel, 0);
	    al.alListenerfv(AL.AL_ORIENTATION, 	listenerOri, 0);
	    checkError(al);
	}
	
	private void initPlayers()
	{
		// create players
		for (int i=0; i<255; i++) {
			try {
				players.add(new JALPlayer(al));
			} catch (Exception err) {
				break;
			}
	  	}
	  	System.out.println("Gen OpenAL players : " + players.size());
	}

	class DeviceInfo
	{
		final String 	name;
		
		ALCdevice		device;
		int[] 			alc_state = new int[5];
		
		public DeviceInfo(String name)
		{
			this.name = name;
		}
		
		public String getName() {
			return name;
		}
		
		public void open() throws ALException {
			this.device = alc.alcOpenDevice(name);
			if (checkError(al) || this.device == null) {
				throw new ALException("Error open OpenAL device");
			}
			alc.alcGetIntegerv(device, ALC.ALC_FREQUENCY,      	1, alc_state, 0); 
			alc.alcGetIntegerv(device, ALC.ALC_MONO_SOURCES,   	1, alc_state, 1); 
			alc.alcGetIntegerv(device, ALC.ALC_REFRESH,        	1, alc_state, 2); 
			alc.alcGetIntegerv(device, ALC.ALC_STEREO_SOURCES,	1, alc_state, 3); 
			alc.alcGetIntegerv(device, ALC.ALC_SYNC, 			1, alc_state, 4); 
			checkError(al);
		}
		
		public void close() throws ALException {
			if (device != null) {
				alc.alcCloseDevice(device);
				checkError(al);
			}
		}
		
		public ALCcontext createContext() 
		{
			if (device != null) {
				ALCcontext context = alc.alcCreateContext(this.device, IntBuffer.wrap(alc_state));
				if (checkError(al) || context == null) {
					return null;
				}
				return context;
			}
			return null;
		}
		
		/**
		 * ALC.ALC_FREQUENCY,<br>
		 * ALC.ALC_MONO_SOURCES,<br>
		 * ALC.ALC_REFRESH,<br>
		 * ALC.ALC_STEREO_SOURCES,<br>
		 * ALC.ALC_SYNC<br>
		 * @return
		 */
		public int[] getDeviceAttributes() {
			return alc_state;
		}
		public int getFrequency() {
			return alc_state[0];
		}
		public int getMonoSources() {
			return alc_state[1];
		}
		public int getRefresh() {
			return alc_state[2];
		}
		public int getStereoSources() {
			return alc_state[3];
		}
		public int getSync() {
			return alc_state[4];
		}
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder("OpenAL Device : " + name+"\n");
			sb.append("\t      Frequency : " + alc_state[0]+"\n"); 
			sb.append("\t   Mono sources : " + alc_state[1]+"\n"); 
			sb.append("\t        Refresh : " + alc_state[2]+"\n"); 
			sb.append("\t Stereo sources : " + alc_state[3]+"\n"); 
			sb.append("\t           Sync : " + alc_state[4]); 
			return sb.toString();
		}
		
	}
	
//	--------------------------------------------------------------------------------------------------

	synchronized 
	public SoundInfo createSoundInfo(String resource, InputStream is){
		try {
			String name = resource.toLowerCase();
			if (name.endsWith(".wav")) {
				return initWav(resource, is);
			} else if (name.endsWith(".ogg")) {
				return initOgg(resource, is);
			}
		} catch (Throwable err) {
			err.printStackTrace();
		}
		return null;
	}
	
	synchronized 
	public SoundInfo createSoundInfo(String resource) {
		return createSoundInfo(resource, CIO.loadStream(resource));
	}
	
	synchronized 
	public ISound createSound(SoundInfo info) {
		try {
			return new JALSound(this, info);
		} catch (Throwable err) {
			err.printStackTrace();
		}
		return new NullSound();
	}
	
	synchronized 
	public IPlayer createPlayer() 
	{
		for (JALPlayer player : players) {
			if (!player.actived.get()) {
				player.actived.set(true);
//				System.out.println(
//						"SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS\n" +
//						"S Create sound : " + player + "\n"+
//						"SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS");
				return player;
			}
		}
		System.err.println("no free source, cut an active source !");
		return new NullPlayer();
		
	}
	
	synchronized
	public void cleanAllPlayer() {
		for (JALPlayer player : players) {
			player.setSound(null);
			player.dispose();
		}
	}
	
	synchronized
	public void setVolume(float volume) {
		al.alListenerf(AL.AL_GAIN, volume);
	}

//	--------------------------------------------------------------------------------------------------
	

	SoundInfo initWav(String resource, InputStream input) throws Exception
	{
		if (input == null) {
			throw new IOException("InputStream is null !");
		}
		return new JALWavSoundInfo(resource, input);
	}

	SoundInfo initOgg(String resource, InputStream input) throws Exception
	{
		if (input == null) {
			throw new IOException("InputStream is null !");
		}
		SoundInfo info = ogg_decoder.decode(resource, input);
		return info;
	}
	
	static boolean checkError(AL al) {
		int code = al.alGetError();
		if (code != AL.AL_NO_ERROR) {
			try{
				throw new Exception("OpenAL Error code : " + code);
			}catch(Exception err) {
				err.printStackTrace();
			}
			return true;
		}
		return false;
	}
	

}
