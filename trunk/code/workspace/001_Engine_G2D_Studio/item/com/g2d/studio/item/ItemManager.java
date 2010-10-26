package com.g2d.studio.item;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import com.cell.rpg.item.ItemPropertyManager;
import com.cell.rpg.item.ItemPropertyTypes;
import com.g2d.studio.Config;
import com.g2d.studio.ManagerForm;
import com.g2d.studio.Studio;
import com.g2d.studio.Studio.ProgressForm;
import com.g2d.studio.io.File;
import com.g2d.studio.res.Res;
import com.g2d.studio.swing.G2DWindowToolBar;

public class ItemManager extends ManagerForm implements ActionListener
{
	private static final long serialVersionUID = 1L;

	G2DWindowToolBar 		toolbar		= new G2DWindowToolBar(this);
	
	ItemPropertiesTreeView	tree_view;
	
	public ItemManager(Studio studio, ProgressForm progress) 
	{
		super(studio, progress, "道具/技能能力管理器", Res.icons_bar[5]);
		
		this.add(toolbar, BorderLayout.NORTH);

		try {
			Class<?> properties_type = Class.forName(Config.DYNAMIC_ITEM_PROPERTY_MANAGER_CLASS);
			ItemPropertyManager manager = (ItemPropertyManager)properties_type.newInstance();
			ItemPropertyTypes.setItemPropertyTypes(manager);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	
		File item_properties_list_file = studio.project_save_path.getChildFile("item_properties/item_properties.list");
		this.tree_view = new ItemPropertiesTreeView(item_properties_list_file);
		this.add(tree_view, BorderLayout.CENTER);
	}

	public ItemPropertiesNode getNode(int id) {
		return tree_view.getNode(id);
	}
	
	public Vector<ItemPropertiesNode> getAllNodes() {
		return tree_view.getAllObject();
	}
	
	public void saveAll() throws Throwable
	{
		System.out.println(getClass().getSimpleName() + " : save all");
		this.tree_view.saveAll();
		
	}
	
//	-------------------------------------------------------------------------------------------------------------------------------
	


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == toolbar.save) {
			try {
				saveAll();
			} catch (Throwable e1) {
				e1.printStackTrace();
			}
		}
	}


//	-------------------------------------------------------------------------------------------------------------------------------
	
	
	
	
	
	
	
	
	
	
}