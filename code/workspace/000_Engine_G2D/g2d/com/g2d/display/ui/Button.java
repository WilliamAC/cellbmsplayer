package com.g2d.display.ui;

import java.awt.Color;
import java.awt.Graphics2D;

import com.g2d.Version;
import com.g2d.annotation.Property;
import com.g2d.util.Drawing;

/**
 * 用于显示基本文字的按钮
 * @author WAZA
 */
public class Button extends BaseButton 
{
	private static final long serialVersionUID	= Version.VersionG2D;
	
	@Property("文字颜色")
	public Color 				unfocusTextColor;
	@Property("文字颜色(获得鼠标后)")
	public Color 				focusTextColor;
	
	@Property("text")
	public String 				text;
	@Property("text_anchor")
	public int 					text_anchor;
	public int 					text_offset_x;
	public int 					text_offset_y;
	
	public Button(String text, int width, int height) {
		super(width, height);
		this.text = text;
	}
	
	public Button(String text) {
		super() ;
		this.text = text;
	}
	
	public Button() {
		super();
	}
	
	@Override
	protected void init_field() 
	{
		super.init_field();
		unfocusTextColor	= new Color(0xffffFF00, true);
		focusTextColor		= new Color(0xffffffff, true);
		text = "";
		text_anchor = Drawing.TEXT_ANCHOR_HCENTER | Drawing.TEXT_ANCHOR_VCENTER ;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	@Override
	public void render(Graphics2D g) {
		super.render(g);
		render_text(g);
	}
	
	protected void render_text(Graphics2D g)
	{
		if (getRoot()!=null && catched_mouse) {
			g.setColor(focusTextColor);
		}else{
			g.setColor(unfocusTextColor);
		}
		
		if (isOnDragged()) {
			Drawing.drawStringBorder(g, text, text_offset_x, text_offset_y+1, getWidth(), getHeight(), text_anchor);
		}else{
			Drawing.drawStringBorder(g, text, text_offset_x, text_offset_y+0, getWidth(), getHeight(), text_anchor);
		}
	}
}
