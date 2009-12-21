package com.g2d.studio.quest.events;

import java.awt.Dimension;
import java.awt.dnd.DropTarget;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import com.cell.CIO;
import com.cell.rpg.ability.AbstractAbility;
import com.cell.rpg.io.RPGObjectMap;
import com.cell.rpg.quest.Quest;
import com.cell.rpg.quest.QuestCondition;
import com.cell.rpg.quest.QuestGenerator;
import com.g2d.studio.Studio;
import com.g2d.studio.quest.items.QuestItemManager;
import com.g2d.studio.quest.items.QuestItemNode;
import com.g2d.studio.quest.items.QuestItemTree;

import com.g2d.studio.swing.G2DTree;
import com.g2d.studio.swing.G2DTreeNode;
import com.g2d.studio.swing.G2DTreeNodeGroup;
import com.g2d.studio.swing.G2DTreeNodeGroup.GroupMenu;
import com.g2d.util.AbstractDialog;

public class QuestEventTree extends G2DTree implements MouseListener
{
	private Quest quest ;

//	----------------------------------------------------------------------------------------------------------------------------------
	
	public QuestEventTree()
	{
		super(new DefaultMutableTreeNode("事件"));
		super.setDragEnabled(true);
		super.setMinimumSize(new Dimension(200, 200));
		super.addMouseListener(this);
	}
	
	void setQuest(Quest quest)
	{
		this.quest = quest;
		
		getRoot().removeAllChildren();
		
		if (quest.quest_generator == null) {
			quest.quest_generator = new QuestGenerator();
		}
		for (AbstractAbility ab : quest.quest_generator.getAbilities()) {
			QuestEventNode node = new QuestEventNode(ab);
			getRoot().add(node);
		}
		
		reload();
	}

//	----------------------------------------------------------------------------------------------------------------------------------

	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void mousePressed(MouseEvent e){}
	@Override
	public void mouseClicked(MouseEvent e) 
	{
		if (e.getButton() == MouseEvent.BUTTON3) {
			int selRow = getRowForLocation(e.getX(), e.getY());
			TreePath selPath = getPathForLocation(e.getX(), e.getY());
			setSelectionPath(selPath);
			if (selRow != -1) {
				Object obj = selPath.getLastPathComponent();
				if (obj == getRoot()) {
					new ConditionGroupMenu().show(this, e.getX(), e.getY());
				}
			}
		}
		
	}
	


//	----------------------------------------------------------------------------------------------------------------------------------
	
	class ConditionGroupMenu extends JPopupMenu implements ActionListener
	{
		HashMap<Object, Class<?>> type_map = new HashMap<Object, Class<?>>();
		
		public ConditionGroupMenu() 
		{
			for (Class<?> type : quest.quest_generator.getSubAbilityTypes()) {
				JMenuItem item = new JMenuItem("添加 : " + AbstractAbility.getName(type));
				this.add(item);
				type_map.put(item, type);
				item.addActionListener(this);
			}
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if (type_map.containsKey(e.getSource())) {
				Class<?> type = type_map.get(e.getSource());
				try{
					AbstractAbility ab = (AbstractAbility)type.newInstance();
					quest.quest_generator.addAbility(ab);
					setQuest(quest);
				}catch(Exception err){
					err.printStackTrace();
				}
			}
		}
	}
	
//	----------------------------------------------------------------------------------------------------------------------------------
	
//	----------------------------------------------------------------------------------------------------------------------------------
	
//	----------------------------------------------------------------------------------------------------------------------------------
	
}
