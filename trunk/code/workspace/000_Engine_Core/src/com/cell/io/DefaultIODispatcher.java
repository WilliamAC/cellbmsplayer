package com.cell.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import com.cell.CIO;

public class DefaultIODispatcher implements IODispatcher
{
	private int						url_loading_time_out	= 20000; //ms
	private int						url_loading_retry_count	= 5;
	private AtomicLong				loaded_bytes			= new AtomicLong(0);

	
	/**
	 * 覆盖获得JAR包内容
	 * @param path
	 * @return
	 */
	protected InputStream getJarResource(String path) 
	{
		return Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
	}
	
	/**
	 * 覆盖获得JAR包内容
	 * @param path
	 * @return
	 * @throws FileNotFoundException 
	 */
	protected InputStream getFileResource(String path) throws FileNotFoundException
	{
		File file = new File(path);
		if (file.exists()) {
			return new FileInputStream(file);
		}
		return null;
	}

	/**
	 * 覆盖获得 http:// 协议资源内容
	 * @param path
	 * @param timeout
	 * @return
	 */
	protected RemoteInputStream getHTTPResource(String path) throws IOException
	{
		try {
			return new RemoteHttpInputStream(new URL(path), url_loading_time_out);
		} catch (MalformedURLException err) {
			return null;
		}
	}
	
	/**
	 * 覆盖获得 res:// 协议资源内容
	 * @param path
	 * @param timeout
	 * @return
	 */
	protected RemoteInputStream getRESResource(String path) throws IOException
	{
		return null;
	}
	
	/**
	 * 覆盖获得 ftp:// 协议资源内容
	 * @param path
	 * @param timeout
	 * @return
	 */
	protected RemoteInputStream getFTPResource(String path) throws IOException
	{
		return null;
	}

//	-----------------------------------------------------------------------------------------------------
	
	@Override
	public InputStream getInputStream(String path) 
	{
		path = path.trim();
		try
		{
			if (path.startsWith("/")) 
			{
				return getJarResource(path);
			} 
			else if (path.startsWith("res://"))
			{
				return getRESResource(path);
			} 
			else if (path.startsWith("ftp://")) 
			{
				return getFTPResource(path);
			}
			else if (path.startsWith("http://"))
			{
				return getHTTPResource(path);
			} 
			else if (path.startsWith("file:///"))
			{
				return getFileResource(path.substring(8));
			} 
			else
			{
				return getFileResource(path);
			}
		}
		catch(Exception err) {
			err.printStackTrace();
		}
		return null;
	}
	
//	@Override
//	public byte[] loadData(String path)
//	{
//		path = path.trim();
//		byte[] data = null;
//		try
//		{
//			// load from jar
//			if (path.startsWith("/")) {
//				return CIO.readStream(getJarResource(path));
//			}
//			// user define resource
//			else if (path.startsWith("res://")) {
//				return loadRemoteData(path);
//			}
//			// load from http
//			else if (path.startsWith("ftp://")) {
//				return loadFTPData(path);
//			}
//			// load from http
//			else if (path.startsWith("http://")) {
//				try {
//					return loadURLData(new URL(path));
//				} catch (MalformedURLException err) {
//				}
//			}
//			// load from file
//			else if (path.startsWith("file:///"))
//			{
//				File file = new File(path.substring(8));
//				if (file.exists()) {
//					return CIO.readStream(new FileInputStream(file));
//				}
//			} 
//			// load from file
//			else {
//				File file = new File(path);
//				if (file.exists()) {
//					return CIO.readStream(new FileInputStream(file));
//				}
//			}
//		} catch(Throwable err) {
//			System.err.println(path);
//			err.printStackTrace();
//		}
//		return data;
//	
//	}

	/**
	 * 获得已从CIO读取的字节数
	 * @return
	 */
	public long getLoadedBytes() {
		return loaded_bytes.get();
	}

	/**读取数据的超时时间*/
	public void setLoadingTimeOut(int loadingTimeOut) {
		url_loading_time_out = loadingTimeOut;
	}
	
	/**读取数据的超时时间*/
	public int getLoadingTimeOut() {
		return url_loading_time_out;
	}

	/**读取数据的重复次数*/
	public void setLoadRetryCount(int loadRetryCount) {
		url_loading_retry_count = Math.max(1, loadRetryCount);
	}
	
	/**读取数据的重复次数*/
	public int getLoadRetryCount() {
		return url_loading_retry_count;
	}
	
	
//	------------------------------------------------------------------------------------------------------------------------
	

	abstract protected class RemoteInputStream extends InputStream
	{
		protected InputStream src;
		
		protected AtomicInteger	readed = new AtomicInteger(0);	
		
		@Override
		public int available() throws IOException {
			return src.available();
		}
		
		@Override
		public int read() throws IOException {
			synchronized (readed) {
				int b = src.read();
				if (b >= 0) {
					readed.incrementAndGet();
					loaded_bytes.incrementAndGet();
				}
				return b;
			}
		}

		@Override
		public int read(byte[] b, int off, int len) throws IOException {
			synchronized (readed) {
				int count = src.read(b, off, len);
				if (count >= 0) {
					readed.addAndGet(count);
					loaded_bytes.addAndGet(count);
				}
				return count;
			}
		}
		
		@Override
		public void close() throws IOException {
			src.close();
		}

		@Override
		public void mark(int readlimit) {}

		@Override
		public boolean markSupported() {
			return false;
		}
	}

	
	
//	------------------------------------------------------------------------------------------------------------------------

	protected class RemoteResInputStream extends RemoteInputStream
	{
		public RemoteResInputStream(InputStream res) throws IOException {
			this.src = res;
		}
	}

//	-----------------------------------------------------------------------------------------------------------------

	protected class RemoteHttpInputStream extends RemoteInputStream
	{
		protected URLConnection	connection;
		
		private AtomicInteger	length;
		
		public RemoteHttpInputStream(URL url, int timeout) throws IOException 
		{
			this.connection = url.openConnection();
			this.connection.setConnectTimeout(timeout);
			this.connection.setReadTimeout(timeout);
			this.connection.connect();
			this.src = connection.getInputStream();
		}

		@Override
		public int available() throws IOException {
			synchronized (readed) {
				return getLength() - readed.get();
			}
		}

		public int getLength() {
			synchronized (readed) {
				if (length == null) {
					length = new AtomicInteger(connection.getContentLength());
				}
				return length.get();
			}
		}
		
	}

//	-----------------------------------------------------------------------------------------------------------------

//	------------------------------------------------------------------------------------------------------------------------

}