package com.g2d.studio.gameedit.template;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.cell.rpg.xls.XLSFile;
import com.cell.rpg.xls.XLSFullRow;
import com.cell.util.MarkedHashtable;
import com.g2d.Tools;
import com.g2d.studio.Studio;
import com.g2d.studio.gameedit.TemplateObjectViewer;
import com.g2d.studio.gameedit.template.TItem.ItemObjectViewer;
import com.g2d.studio.icon.IconFile;
import com.g2d.studio.icon.IconSelectDialog;
import com.g2d.studio.res.Res;

public class TSkill extends TemplateNode
{
	transient IconFile icon_file;
	
	public TSkill(XLSFile xls_file, XLSFullRow xls_row) {
		super(xls_file, xls_row);
	}

	@Override
	protected void onRead(MarkedHashtable data) {
		super.onRead(data);
		String icon_file_name = data.getObject("icon_file_name", null);
		if (icon_file_name!=null) {
			icon_file = Studio.getInstance().getIconManager().getIcon(icon_file_name);
		}
	}
	
	@Override
	protected void onWrite(MarkedHashtable data) {
		super.onWrite(data);
		if (icon_file!=null) {
			data.put("icon_file_name", icon_file.icon_file_name);
		}
	}
	
	public IconFile getIconFile() {
		return icon_file;	
	}
	
	@Override
	public ImageIcon createIcon() {
		if (icon_file!=null) {
			return Tools.createIcon(Tools.combianImage(20, 20, icon_file.image));
		} else {
			return Tools.createIcon(Tools.combianImage(20, 20, Res.icon_error));
		}
	}

	public TemplateObjectViewer<?> getEditComponent(){
		if (edit_component==null) {
			edit_component = new SkillObjectViewer();
		}
		return edit_component;
	}
	
//	-----------------------------------------------------------------------------------------------------------------
	
	class SkillObjectViewer extends TemplateObjectViewer<TSkill>
	{
		private static final long serialVersionUID = 1L;
		
		JButton set_binding = new JButton("设置图标");
		
		public SkillObjectViewer() 
		{
			super(TSkill.this);

			if (icon_file!=null) {
				set_binding.setIcon(icon_file.getIcon(false));
			}
			set_binding.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					IconFile icon = new IconSelectDialog().showDialog();
					if (icon != null) {
						icon_file = icon;
						TSkill.this.getIcon(true);
						set_binding.setIcon(icon_file.getIcon(false));
						Studio.getInstance().getObjectManager().repaint();
					}
				}
			});
			page_properties.add(set_binding, BorderLayout.SOUTH);
		}
		
		
		
	}
	
	
	
}
