package com.cell.rpg.particle;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.cell.CMath;
import com.cell.gfx.game.CSprite;
import com.cell.j2se.CGraphicsImage;
import com.g2d.display.particle.ParticleAppearance;

public enum ParticleAppearanceType
{
	IMAGE(DisplayNodeImage.class), 
	SPRITE(DisplayNodeSprite.class), 
	;

//	-----------------------------------------------------------------------------------------------
	
	final private Class<? extends ParticleAppearance> type;
	
	ParticleAppearanceType(Class<? extends ParticleAppearance> type) {
		this.type = type;
	}
	
	public Class<? extends ParticleAppearance> getType() {
		return type;
	}
	
//	-----------------------------------------------------------------------------------------------
	
	public static class DisplayNodeImage implements ParticleAppearance
	{
		private static final long serialVersionUID = 1L;
		
		/** CPJ工程名 */
		public String	cpj_project_name;
		
		/** CPJ图片组名*/
		public String	cpj_sprite_name;
		
		/** CPJ图片组图片编号*/
		public int		cpj_image_id;

		transient 
		public BufferedImage image;
		
		public DisplayNodeImage cloneDisplay() {
			return this;
		}
		
		@Override
		public void render(Graphics2D g) {
			if (image != null) {
				g.drawImage(image, -image.getWidth() >> 1, -image.getHeight() >> 1, null);
			} else {
				g.setColor(Color.WHITE);
				g.drawArc(-2, -2, 4, 4, 0, 360);
			}
		}
	}
	
	public static class DisplayNodeSprite implements ParticleAppearance
	{
		private static final long serialVersionUID = 1L;
		
		/** CPJ工程名 */
		public String	cpj_project_name;
		
		/** CPJ图片组名*/
		public String	cpj_sprite_name;
		
		/** 精灵动画号 */
		public int		sprite_anim;
		
		
		transient public CSprite			sprite;
		
		
		transient private int				st_current_timer;
		transient private DisplayNodeSprite st_orginal;
		
		public DisplayNodeSprite cloneDisplay() {
			DisplayNodeSprite ret = new DisplayNodeSprite();
			ret.st_orginal			= this;
			ret.st_current_timer 	= st_current_timer;
			ret.sprite_anim 		= sprite_anim;
			ret.sprite 				= sprite;
			return ret;
		}
		
		@Override
		public void render(Graphics2D g) {
			if (st_orginal.sprite != null) {
				CSprite sprite		= st_orginal.sprite;
				int		sprite_anim	= st_orginal.sprite_anim;
				CGraphicsImage cg = new CGraphicsImage(g);
				int anim = CMath.cycNum(sprite_anim, 0, sprite.getAnimateCount());
				int fram = CMath.cycNum(st_current_timer, 0, sprite.getFrameCount(anim));
				sprite.render(cg, 0, 0, anim, fram);
				st_current_timer ++;
			} else {
				g.setColor(Color.WHITE);
				g.drawArc(-2, -2, 4, 4, 0, 360);
			}
		}
	}
}
