package com.g2d.studio.icon;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListModel;

import com.g2d.Tools;
import com.g2d.studio.Config;
import com.g2d.studio.ManagerForm;
import com.g2d.studio.Studio;
import com.g2d.studio.Studio.ProgressForm;
import com.g2d.studio.res.Res;
import com.g2d.studio.swing.G2DList;
import com.g2d.util.AbstractFrame;

public class IconManager extends ManagerForm
{
	private static final long serialVersionUID = 1L;
	
	Vector<IconFile> icon_files = new Vector<IconFile>();
	
	public IconManager(Studio studio, ProgressForm progress) 
	{
		super(studio, progress, "图标管理器");
		{
			File icon_dir = Studio.getInstance().root_icon_path;
			for (File file : icon_dir.listFiles()) {
				if (file.getName().endsWith(Config.ICON_SUFFIX)) {
					try{
						BufferedImage img = Tools.readImage(file.getPath());
						if (img!=null) {
							IconFile icon = new IconFile(
									file.getName().substring(0, file.getName().length() - Config.ICON_SUFFIX.length()), 
									img);
							icon_files.add(icon);
						}
					}catch(Exception err){}
				}
			}
		}
		
		IconList icons = new IconList(getIcons());		
		icons.setVisibleRowCount(icon_files.size()/5+1);
		icons.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		this.add(new JScrollPane(icons));
	}
	
	public Vector<IconFile> getIcons() {
		return icon_files;
	}
	
	public IconFile getIcon(String icon_name) {
		for (IconFile icon : icon_files) {
			if (icon.icon_file_name.equals(icon_name)) {
				return icon;
			}
		}
		return null;
	}
}
