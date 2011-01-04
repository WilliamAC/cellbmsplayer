package com.g2d.java2d.impl;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.Transparency;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.AttributedString;
import java.util.HashMap;

import javax.imageio.ImageIO;

import com.cell.exception.NotImplementedException;
import com.cell.gfx.IGraphics;
import com.cell.gfx.IImage;
import com.cell.gfx.IPalette;
import com.g2d.AnimateCursor;
import com.g2d.BufferedImage;
import com.g2d.Canvas;
import com.g2d.Engine;
import com.g2d.Font;
import com.g2d.Graphics2D;
import com.g2d.Image;
import com.g2d.font.GraphicAttribute;
import com.g2d.text.Instruction;
import com.g2d.text.MultiTextLayout;
import com.g2d.text.TextLayout;

public class AwtEngine extends Engine
{
	public static AwtEngine getEngine() {
		return (AwtEngine)instance;
	}

	private GraphicsEnvironment 				ge;
	private GraphicsDevice 						gd;
	private GraphicsConfiguration				gc;
	private java.awt.image.BufferedImage 		gc_buff;
	private java.awt.Graphics2D					gc_buff_g;
	private HashMap<String, AwtAnimateCursor>	system_cursor;
	
	public AwtEngine() 
	{
		this(GraphicsEnvironment.getLocalGraphicsEnvironment());
	}
	
	public AwtEngine(GraphicsEnvironment ge) 
	{
		this.ge				= ge;
		this.gd				= ge.getDefaultScreenDevice();
		this.gc				= gd.getDefaultConfiguration();
		this.gc_buff		= gc.createCompatibleImage(10, 10);
		this.gc_buff_g		= gc_buff.createGraphics();
		this.system_cursor	= new HashMap<String, AwtAnimateCursor>();
		{
		system_cursor.put("RESIZE_CURSOR_NW", 	new AwtAnimateCursor((Cursor.NW_RESIZE_CURSOR)));
		system_cursor.put("RESIZE_CURSOR_N", 	new AwtAnimateCursor((Cursor.N_RESIZE_CURSOR)));
		system_cursor.put("RESIZE_CURSOR_NE", 	new AwtAnimateCursor((Cursor.NE_RESIZE_CURSOR)));

		system_cursor.put("RESIZE_CURSOR_W", 	new AwtAnimateCursor((Cursor.W_RESIZE_CURSOR)));
		system_cursor.put("RESIZE_CURSOR_E", 	new AwtAnimateCursor((Cursor.E_RESIZE_CURSOR)));
		
		system_cursor.put("RESIZE_CURSOR_SW", 	new AwtAnimateCursor((Cursor.SW_RESIZE_CURSOR)));
		system_cursor.put("RESIZE_CURSOR_S", 	new AwtAnimateCursor((Cursor.S_RESIZE_CURSOR)));
		system_cursor.put("RESIZE_CURSOR_SE", 	new AwtAnimateCursor((Cursor.SE_RESIZE_CURSOR)));
		
		system_cursor.put("HAND_CURSOR", 		new AwtAnimateCursor((Cursor.HAND_CURSOR)));
		system_cursor.put("TEXT_CURSOR", 		new AwtAnimateCursor((Cursor.TEXT_CURSOR)));
		}
		instance 			= this;
	}

	public GraphicsEnvironment		getGE() {return ge;}
	public GraphicsDevice			getGD() {return gd;}
	public GraphicsConfiguration	getGC() {return gc;}
	public java.awt.Graphics2D		getG()  {return gc_buff_g;}

//	-------------------------------------------------------------------------------------------------
//	implements 
//	-------------------------------------------------------------------------------------------------

	public Font createFont(String name, int style, int size) {
		return new AwtFont(new java.awt.Font(name, style, size));
	}

	public AnimateCursor createCursor(Image[] cursor, int spot_x, int spot_y, String name){
		Cursor[] cursors = new Cursor[cursor.length];
		for (int i = 0; i < cursor.length; i++) {
			cursors[i] = createCustomCursor(
					((AwtImage) cursor[i]).getSrc(), 
					new Point(spot_x, spot_y), 
					"g2d_" + name + "_" + i);
		}
		AwtAnimateCursor ret = new AwtAnimateCursor(cursors);
		system_cursor.put(name, ret);
		return ret;
	}

	public AnimateCursor getCursor(String name) {
		return system_cursor.get(name);
	}

	public BufferedImage createImage(int w, int h){
		return new AwtImage(w, h);
	}
	
	@Override
	public IPalette createPalette(InputStream is) throws IOException{
		return new AwtPalette(is);
	}
	
	@Override
	public IPalette createPalette(byte[] data, short colorCount, short transparentColorIndex) {
		return new AwtPalette(data, colorCount, transparentColorIndex);
	}
	
	public BufferedImage createImage(InputStream is) throws IOException{
		return new AwtImage(ImageIO.read(is));
	}

	public void encodeImage(OutputStream out, Image src, String type) throws Exception {
		ImageIO.write(((AwtImage)src).getSrc(), type, out);
	}

	public void setClipboardText(String str) {
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection text = new StringSelection(str);
        clipboard.setContents(text,null);
	}

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

	public TextLayout createTextLayout(AttributedString text) {
		return new AwtTextLayout(text);
	}

	public MultiTextLayout createMultiTextLayout() {
		return new AwtMultiTextLayout();
	}
	
//	--------------------------------------------------------------------------------------------------------------------------
	

	public static Cursor createCustomCursor(java.awt.Image cursor, Point hotSpot, String name)
	{
		AwtImage buff = new AwtImage(cursor);
		
		Dimension bestCursorSize = Toolkit.getDefaultToolkit().getBestCursorSize(
				buff.getWidth(), 
				buff.getHeight());

		if (buff.getWidth() > bestCursorSize.width ||
			buff.getHeight() > bestCursorSize.height ) 
		{
			buff = new AwtImage(
					buff.getSrc().getScaledInstance(
							bestCursorSize.width, 
							bestCursorSize.height,
							java.awt.image.BufferedImage.SCALE_SMOOTH));
			
			return Toolkit.getDefaultToolkit().createCustomCursor(
					buff.getSrc(),
					new Point(
					(int)(hotSpot.getX() * bestCursorSize.width / cursor.getWidth(null)),
					(int)(hotSpot.getY() * bestCursorSize.height/ cursor.getHeight(null))
					), 
					name);
		}
		else
		{
			java.awt.image.BufferedImage bufferedImage = getEngine().gc.createCompatibleImage(
					bestCursorSize.width, 
					bestCursorSize.height, 
					Transparency.TRANSLUCENT);
			Graphics g = bufferedImage.getGraphics();
			g.drawImage(cursor, 0, 0, null);
			g.dispose();
			return Toolkit.getDefaultToolkit().createCustomCursor(
					bufferedImage, hotSpot, name);
		}
	}

	

	/**
	 * 使用java2d包装渲染系统
	 * @param g2d
	 * @return
	 */
	static public Graphics2D wrap(java.awt.Graphics2D g2d) 
	{
		return new AwtGraphics2D(g2d);
	}

	/**
	 * 包装为普通界面使用的图片
	 * @param img
	 * @return
	 */
	static public com.g2d.BufferedImage wrap_awt(java.awt.Image img) 
	{
		return new AwtImage(img);
	}
	
	/**
	 * 将image解包为java.awt.image.BufferedImage
	 * @param image
	 * @return
	 */
	static public java.awt.image.BufferedImage unwrap(IImage image) 
	{
		if (image instanceof AwtImage) {
			return ((AwtImage)image).getSrc();
		}
		
		throw new NotImplementedException("can not unwrap image!");
	}
	

	/**
	 * 包装为渲染系统用的图片
	 * @param img
	 * @return
	 */
	static public com.g2d.BufferedImage wrap_g2d(java.awt.Image img) 
	{
		if (Engine.getEngine() instanceof AwtEngine) {
			return new AwtImage(img);
		}
		throw new NotImplementedException("can not wrap image, no g2d engine implements!");
	}
	
	static public com.g2d.Font wrap(java.awt.Font font) 
	{
		return new AwtFont(font);
	}
}
