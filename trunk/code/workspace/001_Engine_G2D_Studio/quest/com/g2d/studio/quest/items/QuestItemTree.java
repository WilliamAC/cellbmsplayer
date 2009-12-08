package com.g2d.studio.quest.items;

import java.awt.dnd.DropTarget;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

import com.cell.CIO;
import com.cell.rpg.io.RPGObjectMap;
import com.cell.rpg.quest.Quest;
import com.cell.rpg.quest.QuestCondition;
import com.g2d.studio.Studio;
import com.g2d.studio.swing.G2DTree;
import com.g2d.studio.swing.G2DTreeNode;
import com.g2d.studio.swing.G2DTreeNodeGroup;
import com.g2d.studio.swing.G2DTreeNodeGroup.GroupMenu;
import com.g2d.util.AbstractDialog;

public class QuestItemTree extends G2DTree
{
	private Quest quest ;

	final ConditionGroup group_trigger_condition;
	final ConditionGroup group_complete_condition;
	final ConditionGroup group_complete_award;
	
//	----------------------------------------------------------------------------------------------------------------------------------
	
	public QuestItemTree()
	{
		super(new DefaultMutableTreeNode("任务条件"));
		super.setDragEnabled(true);
		group_trigger_condition		= new ConditionGroup("接受条件");
		group_complete_condition	= new ConditionGroup("完成条件");
		group_complete_award		= new ConditionGroup("完成奖励");
		getRoot().add(group_trigger_condition);
		getRoot().add(group_complete_condition);
		getRoot().add(group_complete_award);
	}
	
	void setQuest(Quest quest)
	{
		this.quest = quest;
		group_trigger_condition.removeAllChildren();
		group_complete_condition.removeAllChildren();
		group_complete_award.removeAllChildren();
		
		group_trigger_condition.loadList(quest.accept_condition);
		group_complete_condition.loadList(quest.complete_condition);
		group_complete_award.loadList(quest.complete_award);
		
		reload();
	}
	
	public void save() {
		if (this.quest != null) {
			group_trigger_condition.saveList(quest.accept_condition);
			group_complete_condition.saveList(quest.complete_condition);
			group_complete_award.saveList(quest.complete_award);
		}
	}
	
	@Override
	protected boolean checkDrag(DropTarget evtSource, Object src, Object dst, int position) {
		MutableTreeNode src_node = (MutableTreeNode)src;
		MutableTreeNode dst_node = (MutableTreeNode)dst;
		if (dst_node == getRoot()) {
			return false;
		}
		if (src_node.getParent() == getRoot()) {
			return false;
		}
		if (dst_node.getParent() == getRoot() && position != 0) {
			return false;
		}
		return super.checkDrag(evtSource, src, dst, position);
	}
	
//	----------------------------------------------------------------------------------------------------------------------------------
	
	class ConditionGroup extends G2DTreeNodeGroup<QuestItemNode>
	{
		public ConditionGroup(String title) {
			super(title);
		}
		
		@Override
		protected boolean pathAddLeafNode(String name, int index, int length) {
			QuestItemManager items = Studio.getInstance().getQuestManager().getQuestItems();
			try{
				if (index == length - 1) {
					QuestItemNode node = items.get(Integer.parseInt(name));
					this.add(node);
					return true;
				}
			}catch(Exception err){
				err.printStackTrace();
			}
			return false;
		}
		
		@Override
		protected G2DTreeNodeGroup<?> pathCreateGroupNode(String name) {
			return new ConditionGroup(name);
		}
		
		@Override
		public void onClicked(JTree tree, MouseEvent e) {
			if (e.getButton() == MouseEvent.BUTTON3) {
				new ConditionGroupMenu(this).show(tree, e.getX(), e.getY());
			}
		}
	
		private void saveList(QuestCondition condition)
		{
			DefaultMutableTreeNode parent = (DefaultMutableTreeNode)getParent();
			removeFromParent();
			try{
				condition.item_name_list.clear();
				for (QuestItemNode item : G2DTree.getNodesSubClass(this, QuestItemNode.class)) {
					condition.item_name_list.add(toPathString(item, "/") + item.getID());
				}
			} finally {
				parent.add(this);
			}
		}
		
		private void loadList(QuestCondition condition)
		{
			DefaultMutableTreeNode parent = (DefaultMutableTreeNode)getParent();
			removeFromParent();
			try{
				for (String line : condition.item_name_list) {
					try{
						loadPath(line);
					}catch(Exception e){
						e.printStackTrace();
					}
				}
			} finally {
				parent.add(this);
			}
		}
	}

//	----------------------------------------------------------------------------------------------------------------------------------
	
	class ConditionGroupMenu extends GroupMenu
	{
		protected JMenuItem add_quest_item		= new JMenuItem("添加条件");
		protected JMenuItem select_quest_item	= new JMenuItem("选择条件");
		
		public ConditionGroupMenu(ConditionGroup root) 
		{
			super(root, AbstractDialog.getTopWindow(QuestItemTree.this), QuestItemTree.this);
			if (root.getParent() == getRoot()) {
				super.remove(super.delete);
				super.remove(super.rename);
			}
			
			super.add(add_quest_item);
			add_quest_item.addActionListener(this);
			
//			super.add(select_quest_item);
//			select_quest_item.addActionListener(this);
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == add_quest_item) {
				String name = JOptionPane.showInputDialog(window, "输入条件名字！", "未命名条件");
				if (name!=null && name.length()>0) {
					QuestItemManager items = Studio.getInstance().getQuestManager().getQuestItems();
					QuestItemNode node = items.createQuestItem(name);
					root.add(node);
					g2d_tree.reload(root);
				}
			}
			else if (e.getSource() == select_quest_item) {
//				QuestItemSelectCellEdit select_item = new QuestItemSelectCellEdit(AbstractDialog.getTopWindow(window));
//				QuestItemNode other_node = select_item.showDialog();
//				if (other_node != null) {
//					QuestItemManager items = Studio.getInstance().getQuestManager().getQuestItems();
//					QuestItemNode node = items.createQuestItem(other_node);
//					root.add(node);
//					g2d_tree.reload(root);
//				}
			}
			else {
				super.actionPerformed(e);
			}
		}
	}
	
//	----------------------------------------------------------------------------------------------------------------------------------
	
}
