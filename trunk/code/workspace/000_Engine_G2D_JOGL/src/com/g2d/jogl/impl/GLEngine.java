package com.g2d.jogl.impl;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.Transparency;
import java.awt.color.ColorSpace;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.image.ComponentColorModel;
import java.awt.image.DataBuffer;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.AttributedString;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.media.opengl.GL;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLContext;
import javax.media.opengl.glu.GLU;

import com.cell.gfx.IPalette;
import com.g2d.AnimateCursor;
import com.g2d.BufferedImage;
import com.g2d.Engine;
import com.g2d.Font;
import com.g2d.Image;

import com.g2d.text.MultiTextLayout;
import com.g2d.text.TextLayout;
import com.sun.opengl.util.GLUT;

public class GLEngine extends Engine
{
	public static GLEngine getEngine() {
		return (GLEngine)instance;
	}


//	---------------------------------------------------------------------------------------------
	
	
	private GLCapabilities						capabilities;
    private GLU 								glu;
    private GLUT 								glut;

	private HashMap<String, GLAnimateCursor>	system_cursor;
	
	
	public GLEngine() 
	{
		capabilities 	= new GLCapabilities();
		
		// should be supported on most hardware
	    capabilities	.setHardwareAccelerated(true);
	    
	    // try to enable 2x anti aliasing 
//		capabilities	.setNumSamples(2); 			
//		capabilities	.setSampleBuffers(true);	
	    
	    glu 			= new GLU();
        glut 			= new GLUT();
        
        this.system_cursor	= new HashMap<String, GLAnimateCursor>();
		{
		system_cursor.put("RESIZE_CURSOR_NW", 	new GLAnimateCursor((Cursor.NW_RESIZE_CURSOR)));
		system_cursor.put("RESIZE_CURSOR_N", 	new GLAnimateCursor((Cursor.N_RESIZE_CURSOR)));
		system_cursor.put("RESIZE_CURSOR_NE", 	new GLAnimateCursor((Cursor.NE_RESIZE_CURSOR)));

		system_cursor.put("RESIZE_CURSOR_W", 	new GLAnimateCursor((Cursor.W_RESIZE_CURSOR)));
		system_cursor.put("RESIZE_CURSOR_E", 	new GLAnimateCursor((Cursor.E_RESIZE_CURSOR)));
		
		system_cursor.put("RESIZE_CURSOR_SW", 	new GLAnimateCursor((Cursor.SW_RESIZE_CURSOR)));
		system_cursor.put("RESIZE_CURSOR_S", 	new GLAnimateCursor((Cursor.S_RESIZE_CURSOR)));
		system_cursor.put("RESIZE_CURSOR_SE", 	new GLAnimateCursor((Cursor.SE_RESIZE_CURSOR)));
		
		system_cursor.put("HAND_CURSOR", 		new GLAnimateCursor((Cursor.HAND_CURSOR)));
		system_cursor.put("TEXT_CURSOR", 		new GLAnimateCursor((Cursor.TEXT_CURSOR)));
		}
	    instance		 = this;
	}

	public GLCapabilities getGLCapabilities() {
		return capabilities;
	}
	
	public GL getGL() {
		return GLContext.getCurrent().getGL();
	}
	
	public GLU getGLU() {
		return glu;
	}
	
	public GLUT getGLUT() {
		return glut;
	}
	
	@Override
	public BufferedImage createImage(InputStream is) throws IOException {
		java.awt.image.BufferedImage src = ImageIO.read(is);
		GLImage buff = new GLImage(getGL(), src);
		return buff;
	}

	@Override
	public BufferedImage createImage(int w, int h) {
		GLImage buff = new GLImage(getGL(), w, h);
		return buff;
	}

	@Override
	public void encodeImage(OutputStream out, Image src, String type) throws Exception {
		ImageIO.write(((GLImage)src).getSrc(), type, out);
	}
	
	@Override
	public IPalette createPalette(InputStream is) throws IOException {
		return new GLPalette(is);
	}
	@Override
	public IPalette createPalette(byte[] data, short colorCount,
			short transparentColorIndex) {
		// TODO Auto-generated method stub
		return null;
	}

//	---------------------------------------------------------------------------------------------

	@Override
	public MultiTextLayout createMultiTextLayout() {
		return null;
	}

	@Override
	public TextLayout createTextLayout(AttributedString text) {
		return null;
	}

//	---------------------------------------------------------------------------------------------

	@Override
	public Font createFont(String name, int style, int size) {
		return null;
	}

	@Override
	public void setClipboardText(String str) {
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection text = new StringSelection(str);
        clipboard.setContents(text,null);
	}
	
	@Override
	public String getClipboardText() {
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		Transferable contents = clipboard.getContents(clipboard);
        DataFlavor flavor = DataFlavor.stringFlavor;
        if(contents.isDataFlavorSupported(flavor)){
            try{
                return (String)contents.getTransferData(flavor);
            }catch(Exception ee){ee.printStackTrace();}    
        }
        return "";
	}

	@Override
	public AnimateCursor createCursor(Image[] cursor, int spot_x, int spot_y, String name){
		Cursor[] cursors = new Cursor[cursor.length];
		for (int i = 0; i < cursor.length; i++) {
			cursors[i] = createCustomCursor(
					((GLImage) cursor[i]).getSrc(), 
					new Point(spot_x, spot_y), 
					"g2d_" + name + "_i");
		}
		GLAnimateCursor ret = new GLAnimateCursor(cursors);
		system_cursor.put(name, ret);
		return ret;
	}
	
	@Override
	public AnimateCursor getCursor(String name) {
		return system_cursor.get(name);
	}

//	---------------------------------------------------------------------------------------------
	
	public static java.awt.image.BufferedImage createRaster(int w, int h)
	{
		java.awt.image.WritableRaster raster = java.awt.image.Raster.createInterleavedRaster(
				DataBuffer.TYPE_BYTE, w, h, 4, null);
		
		java.awt.image.ComponentColorModel colorModel = new java.awt.image.ComponentColorModel(
				ColorSpace.getInstance(ColorSpace.CS_sRGB), 
				new int[] { 8, 8, 8, 8 }, 
				true, false, 
				java.awt.image.ComponentColorModel.TRANSLUCENT,
				DataBuffer.TYPE_BYTE);
		
		return new java.awt.image.BufferedImage(
				colorModel, raster, false, null);
	}
	


	public static Cursor createCustomCursor(java.awt.Image cursor, Point hotSpot, String name)
	{
		java.awt.image.BufferedImage buff = createRaster(cursor.getWidth(null), cursor.getHeight(null));
		
		Dimension size = Toolkit.getDefaultToolkit().getBestCursorSize(buff.getWidth(), buff.getHeight());

		if (buff.getWidth()  > size.width ||
			buff.getHeight() > size.height ) 
		{
			buff = (java.awt.image.BufferedImage)buff.getScaledInstance(
					size.width, 
					size.height,
					java.awt.image.BufferedImage.SCALE_SMOOTH);
			
			return Toolkit.getDefaultToolkit().createCustomCursor(
					buff,
					new Point(
					(int)(hotSpot.getX() * size.width / cursor.getWidth(null)),
					(int)(hotSpot.getY() * size.height/ cursor.getHeight(null))
					), 
					name);
		}
		else
		{
			Graphics g = buff.getGraphics();
			g.drawImage(cursor, 0, 0, null);
			g.dispose();
			return Toolkit.getDefaultToolkit().createCustomCursor(
					buff, hotSpot, name);
		}
	}
}