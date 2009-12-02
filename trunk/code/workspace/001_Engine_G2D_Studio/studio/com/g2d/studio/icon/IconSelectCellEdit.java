package com.g2d.studio.icon;

import java.awt.Component;
import java.awt.Window;

import javax.swing.JLabel;

import com.g2d.editor.property.ObjectPropertyPanel;
import com.g2d.editor.property.PropertyCellEdit;
import com.g2d.editor.property.ObjectPropertyPanel.CellEditAdapter;

public class IconSelectCellEdit extends IconSelectDialog implements PropertyCellEdit<String>
{
	JLabel	edit_label 	= new JLabel();
	
	public IconSelectCellEdit(Window owner) {
		super(owner);
	}
	
	@Override
	public Component getComponent(ObjectPropertyPanel panel) {
		IconFile icon = getSelectedObject();
		if (icon!=null) {
			edit_label.setText(icon.icon_file_name);	
			edit_label.setIcon(icon.icon);
		} else {
			edit_label.setText("");	
			edit_label.setIcon(null);
		}
		if (panel != null) {
			panel.fireEditingStopped();
		}
		return edit_label;
	}
	
	@Override
	public String getValue() {
		IconFile icon = getSelectedObject();
		if (icon!=null) {
			return icon.icon_file_name;
		}
		return null;
	}
	
	
}
