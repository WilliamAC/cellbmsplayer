package com.g2d.studio.swing;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.PopupMenuListener;
import javax.swing.text.html.FormView;

import com.g2d.studio.Version;
import com.g2d.studio.scene.FormSceneViewer;
import com.g2d.cell.game.Scene;
import com.g2d.cell.game.SceneUnit;
import com.g2d.editor.DisplayObjectEditor;

public class SceneUnitPanel<T extends SceneUnit> extends JPanel
{
	private static final long serialVersionUID = Version.VersionGS;
	
	final FormSceneViewer	viewer;
	Scene 					scene;
	Class<T>				unit_type;
	
	JList 					list ;
	JScrollPane				scroll;

	JTextField				text_unit_name;
	
	MouseListener mouseListener = new MouseAdapter() {
		public void mouseEntered(MouseEvent e) {
		}
		public void mousePressed(MouseEvent e) {
			
		}
		public void mouseClicked(MouseEvent e) 
		{
			list.repaint();
			
			try {

				final int index = list.locationToIndex(e.getPoint());
				final SceneUnit unit = (SceneUnit) list.getModel().getElementAt(index);

				viewer.selected_unit = unit;
				
				if (unit != null) {
					text_unit_name.setText(unit.getName());
				}
				
				if (e.getButton() == MouseEvent.BUTTON1) {
					if (e.getClickCount() == 2) {
						// System.out.println("Double clicked on Item " +
						// index);
						viewer.locationCamera(unit.getX(), unit.getY());
					}
				} else if (e.getButton() == MouseEvent.BUTTON3) {
					// System.out.println("Right clicked on Item " + index);

					JPopupMenu menu = new JPopupMenu();

					JMenuItem rename = new JMenuItem("重命名");
					rename.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							String new_name = JOptionPane.showInputDialog("input name", unit.getName());
							if (new_name!=null) {
								if (!unit.setName(scene, new_name)){
									JOptionPane.showMessageDialog(list, "bad name or duplicate !");
								}
							}
						}
					});

					JMenuItem property = new JMenuItem("属性");
					property.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							DisplayObjectEditor<?> editor = unit
									.getEditorForm();
							editor.setCenter();
							editor.setAlwaysOnTop(true);
							editor.setVisible(true);

						}
					});

					menu.add(rename);
					menu.add(property);
					menu.show(list, e.getX(), e.getY());
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}
	};
	
	ListSelectionListener listListener = new ListSelectionListener(){
		public void valueChanged(ListSelectionEvent e) {
			try {
				viewer.selected_unit = (SceneUnit) list.getSelectedValue();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	};
	
	
	public SceneUnitPanel(FormSceneViewer viewer, Class<T> cls) 
	{	
		this.setLayout(new BorderLayout());
		
		this.viewer		= viewer;
		this.scene 		= viewer.getViewObject();
		this.unit_type	= cls;
		
		this.list 	= new JList();
		this.scroll = new JScrollPane(list);
		
		this.add(scroll, BorderLayout.CENTER);
		
		text_unit_name = new JTextField();
		text_unit_name.setEditable(true);
		this.add(text_unit_name, BorderLayout.SOUTH);
		
		list.addMouseListener(mouseListener);
		list.addListSelectionListener(listListener);
		
	}
	
	public void refresh() {
		scene.getWorld().processEvent();
		list.setListData(scene.getWorld().getChilds(unit_type));
	}
	
	@Override
	public void paint(Graphics g) {
		this.refresh();
		super.paint(g);
	}
	
    
	public void setSelecte(T unit) {
		list.setSelectedValue(unit, true);
		if (unit != null) {
			text_unit_name.setText(unit.getName());
		}
	}
	
	

}
