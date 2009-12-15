package com.g2d.studio.quest;

import java.awt.Component;
import java.awt.Window;
import java.lang.reflect.Field;

import javax.swing.table.DefaultTableCellRenderer;

import com.cell.rpg.formula.AbstractValue;
import com.cell.rpg.formula.ObjectProperty;
import com.cell.rpg.quest.QuestItem;
import com.cell.rpg.quest.QuestItem.AwardItem;
import com.cell.rpg.quest.QuestItem.AwardTeleport;
import com.cell.rpg.quest.QuestItem.QuestItemAbility;
import com.cell.rpg.quest.QuestItem.TagItem;
import com.cell.rpg.quest.QuestItem.TagPlayerField;
import com.cell.rpg.quest.QuestItem.TagPlayerPetField;
import com.cell.rpg.quest.QuestItem.TagPlayerTeamField;
import com.cell.rpg.quest.QuestItem.TagQuest;
import com.cell.rpg.quest.QuestItem.TagQuestItem;
import com.cell.rpg.quest.QuestItem.TagNPCField;
import com.cell.rpg.quest.QuestItem.TagUnitField;
import com.cell.rpg.quest.ability.QuestAccepter;
import com.cell.rpg.quest.ability.QuestPublisher;
import com.cell.rpg.xls.XLSColumns;
import com.g2d.annotation.Property;
import com.g2d.editor.property.ObjectPropertyPanel;
import com.g2d.editor.property.PropertyCellEdit;
import com.g2d.studio.Studio;
import com.g2d.studio.gameedit.ObjectSelectCellEditInteger;
import com.g2d.studio.gameedit.XLSColumnSelectCellEdit;
import com.g2d.studio.gameedit.template.XLSItem;
import com.g2d.studio.quest.items.QuestItemNode;
import com.g2d.studio.quest.items.QuestItemSelectCellEdit;
import com.g2d.studio.rpg.FormulaEdit;
import com.g2d.studio.rpg.AbilityPanel.AbilityCellEditAdapter;
import com.g2d.studio.rpg.RPGObjectPanel.RPGObjectAdapter;
import com.g2d.studio.scene.editor.SceneListCellEdit;
import com.g2d.studio.scene.editor.SceneUnitListCellEdit;
import com.g2d.studio.scene.entity.SceneNode;
import com.g2d.studio.scene.units.SceneImmutable;
import com.g2d.util.AbstractDialog;

public class QuestCellEditAdapter {

	public static class QuestAccepterAdapter extends AbilityCellEditAdapter<QuestAccepter>
	{
		@Override
		public Class<QuestAccepter> getType() {
			return QuestAccepter.class;
		}
		
		@Override
		public PropertyCellEdit<?> getCellEdit(ObjectPropertyPanel owner, Object editObject, Object fieldValue, Field field) {
			if (field.getName().equals("quest_id")) {
				QuestSelectCellEdit edit = new QuestSelectCellEdit(AbstractDialog.getTopWindow(owner));
				edit.showDialog();
				return edit;
			}
			return null;
		}
	
		@Override
		public Component getCellRender(ObjectPropertyPanel owner, Object editObject,
				Object fieldValue, Field field, DefaultTableCellRenderer src) {
			if (field.getName().equals("quest_id") && fieldValue!=null) {
				Integer quest_id = (Integer)fieldValue;
				QuestNode node = Studio.getInstance().getQuestManager().getQuest(quest_id);
				if (node != null) {
					src.setText(node.toString());
					src.setIcon(node.getIcon(false));
					return src;
				}
			}
			return null;
		}
	}

	public static class QuestPublisherAdapter extends AbilityCellEditAdapter<QuestPublisher>
	{
		@Override
		public Class<QuestPublisher> getType() {
			return QuestPublisher.class;
		}
		
		@Override
		public PropertyCellEdit<?> getCellEdit(ObjectPropertyPanel owner, Object editObject, Object fieldValue, Field field) {
			if (field.getName().equals("quest_id")) {
				QuestSelectCellEdit edit = new QuestSelectCellEdit(AbstractDialog.getTopWindow(owner));
				edit.showDialog();
				return edit;
			}
			return null;
		}
		
		@Override
		public Component getCellRender(ObjectPropertyPanel owner, Object editObject,
				Object fieldValue, Field field, DefaultTableCellRenderer src) {
			if (field.getName().equals("quest_id") && fieldValue!=null) {
				Integer quest_id = (Integer)fieldValue;
				QuestNode node = Studio.getInstance().getQuestManager().getQuest(quest_id);
				if (node != null) {
					src.setText(node.toString());
					src.setIcon(node.getIcon(false));
					return src;
				}
			}
			return null;
		}
	}
	


//	-------------------------------------------------------------------------------------------------------------------------
	
	
	
//	-------------------------------------------------------------------------------------------------------------------------
	
	/**
	 * 依赖已完成的任务
	 * @author WAZA
	 *
	 */
	public static class QuestItemTagQuest extends AbilityCellEditAdapter<TagQuest>
	{

		@Override
		public Class<TagQuest> getType() {
			return TagQuest.class;
		}
		
		@Override
		public PropertyCellEdit<?> getCellEdit(ObjectPropertyPanel owner,
			Object editObject, Object fieldValue, Field field) {
			if (field.getName().equals("quest_id")) {
				QuestSelectCellEdit edit = new QuestSelectCellEdit(owner);
				edit.showDialog();
				return edit;
			}
			return null;
		}
		
		@Override
		public Component getCellRender(ObjectPropertyPanel owner,
			Object editObject, Object fieldValue, Field field,
			DefaultTableCellRenderer src) {
			if (field.getName().equals("quest_id")) {
				try{
					QuestNode node = Studio.getInstance().getQuestManager().getQuest((Integer)fieldValue);
					src.setText(node.getName());
					src.setIcon(node.getIcon(false));
				}catch(Exception err){}
			}
			return null;
		}
	}
	
	
	/**
	 * 任务条件，道具
	 * @author WAZA
	 */
	public static class QuestItemTagItem extends AbilityCellEditAdapter<TagItem>
	{
		@Override
		public Class<TagItem> getType() {
			return TagItem.class;
		}
		
		@Override
		public PropertyCellEdit<?> getCellEdit(ObjectPropertyPanel owner,
			Object editObject, Object fieldValue, Field field) {
			if (field.getName().equals("titem_index")) {
				ObjectSelectCellEditInteger<XLSItem> item_edit = new ObjectSelectCellEditInteger<XLSItem>(XLSItem.class);
				return item_edit;
			}
			return null;
		}
		
		@Override
		public Component getCellRender(ObjectPropertyPanel owner, Object editObject,
			Object fieldValue, Field field, DefaultTableCellRenderer src) {
			if (field.getName().equals("titem_index")) {
				try{
					XLSItem item = Studio.getInstance().getObjectManager().getObject(XLSItem.class, (Integer)fieldValue);
					src.setText(item.getName());
					src.setIcon(item.getIcon(false));
				}catch(Exception err){}
			}
			return null;
		}
	}
	
	/**
	 * 任务条件，依赖的任务条件
	 * @author WAZA
	 */
	public static class QuestItemTagQuestItem extends AbilityCellEditAdapter<TagQuestItem>
	{	
		@Override
		public Class<TagQuestItem> getType() {
			return TagQuestItem.class;
		}
		
		@Override
		public PropertyCellEdit<?> getCellEdit(ObjectPropertyPanel owner,
			Object editObject, Object fieldValue, Field field) {
			if (field.getName().equals("quest_item_index")) {
				QuestItemSelectCellEdit quest_item_edit = new QuestItemSelectCellEdit(AbstractDialog.getTopWindow(owner));
				quest_item_edit.showDialog();
				return quest_item_edit;
			}
			return null;
		}
		
		@Override
		public Component getCellRender(ObjectPropertyPanel owner, Object editObject,
			Object fieldValue, Field field, DefaultTableCellRenderer src) {
			if (field.getName().equals("quest_item_index")) {
				try{
					QuestItemNode node = Studio.getInstance().getQuestManager().getQuestItems().get((Integer)fieldValue);
					src.setText(node.getName());
					src.setIcon(node.getIcon(false));
				}catch(Exception err){}
			}
			return null;
		}
	}
	
	/**
	 * 任务条件，依赖的角色字段
	 * @author WAZA
	 */
	public static class QuestItemTagUnitField extends AbilityCellEditAdapter<TagUnitField>
	{
		XLSColumns player_columns	= Studio.getInstance().getObjectManager().getPlayerXLSColumns();
		XLSColumns unit_columns		= Studio.getInstance().getObjectManager().getUnitXLSColumns();
		@Override
		public Class<TagUnitField> getType() {
			return TagUnitField.class;
		}
		
		@Override
		public PropertyCellEdit<?> getCellEdit(ObjectPropertyPanel owner,
			Object editObject, Object fieldValue, Field field) {
			XLSColumns columns = unit_columns;
			if (editObject instanceof TagPlayerField || 
				editObject instanceof TagPlayerTeamField ) {
				columns = player_columns;
			}
			if (field.getName().equals("unit_property")) {
				XLSColumnSelectCellEdit edit = new XLSColumnSelectCellEdit(columns);
				return edit;
			}
			else if (field.getName().equals("value")) {
				FormulaEdit edit = new FormulaEdit(owner, columns, (AbstractValue)fieldValue);
				edit.showDialog();
				return edit;
			}
			return null;
		}

		@Override
		public Component getCellRender(ObjectPropertyPanel owner, Object editObject,
			Object fieldValue, Field field, DefaultTableCellRenderer src) {
			if (field.getName().equals("unit_property")) {
				if (fieldValue!=null) {
					XLSColumns columns = unit_columns;
					if (editObject instanceof TagPlayerField || 
						editObject instanceof TagPlayerTeamField ) {
						columns = player_columns;
					}
					ObjectProperty value = (ObjectProperty)fieldValue;
					String desc = columns.getDesc(value.filed_name);
					src.setText(desc + " (" + value.filed_name + ")");
				}
			}
			return null;
		}

		@Override
		public Object getCellValue(Object editObject,
				PropertyCellEdit<?> fieldEdit, Field field, Object fieldSrcValue) {
			if (field.getName().equals("unit_property")) {
				try{
					XLSColumnSelectCellEdit edit = (XLSColumnSelectCellEdit)fieldEdit;
					String field_name = edit.getValue();
					return new ObjectProperty(field_name);
				}catch(Exception err){}
			}
			return null;
		}
	}
	

//	-------------------------------------------------------------------------------------------------------------------------
	
	

	/**
	 * 任务奖励，道具
	 * @author WAZA
	 */
	public static class QuestItemAwardItem extends AbilityCellEditAdapter<AwardItem>
	{
		@Override
		public Class<AwardItem> getType() {
			return AwardItem.class;
		}
		
		@Override
		public PropertyCellEdit<?> getCellEdit(ObjectPropertyPanel owner,
			Object editObject, Object fieldValue, Field field) {
			if (field.getName().equals("titem_index")) {
				ObjectSelectCellEditInteger<XLSItem> item_edit = new ObjectSelectCellEditInteger<XLSItem>(XLSItem.class);
				return item_edit;
			}
			return null;
		}
		
		@Override
		public Component getCellRender(ObjectPropertyPanel owner, Object editObject,
			Object fieldValue, Field field, DefaultTableCellRenderer src) {
			if (field.getName().equals("titem_index")) {
				try{
					XLSItem item = Studio.getInstance().getObjectManager().getObject(XLSItem.class, (Integer)fieldValue);
					src.setText(item.getName());
					src.setIcon(item.getIcon(false));
				}catch(Exception err){}
			}
			return null;
		}
	}
	
	/**
	 * 任务奖励，传送
	 * @author WAZA
	 */
	public static class QuestItemAwardTeleport extends AbilityCellEditAdapter<AwardTeleport>
	{
		@Override
		public Class<AwardTeleport> getType() {
			return AwardTeleport.class;
		}
		
		@Override
		public PropertyCellEdit<?> getCellEdit(ObjectPropertyPanel owner,
			Object editObject, Object fieldValue, Field field) {
			if (field.getName().equals("scene_id")){
				return new SceneListCellEdit(fieldValue);
			}
			else if (field.getName().equals("scene_object_id")){
				AwardTeleport tp = (AwardTeleport)editObject;
				if (tp.scene_id!=null) {
					SceneNode scene = Studio.getInstance().getSceneManager().getSceneNode(tp.scene_id+"");
					return new SceneUnitListCellEdit(scene.getSceneEditor(), SceneImmutable.class);
				}
			}
			return null;
		}
		
		@Override
		public Component getCellRender(ObjectPropertyPanel owner, Object editObject,
			Object fieldValue, Field field, DefaultTableCellRenderer src) {
			if (field.getName().equals("scene_id")){
				try{
					SceneNode node = Studio.getInstance().getSceneManager().getSceneNode(fieldValue + "");
					if (fieldValue != null && node != null) {
						src.setText(node.getName() + "(" + node.getID() + ")");
					} else {
						src.setText("null");
					}
				}catch(Exception err){}
			}
			return null;
		}
		
	}
	
}
