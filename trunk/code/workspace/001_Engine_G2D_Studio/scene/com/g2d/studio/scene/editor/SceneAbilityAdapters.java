package com.g2d.studio.scene.editor;

import java.awt.Component;
import java.lang.reflect.Field;

import javax.swing.table.DefaultTableCellRenderer;

import com.cell.rpg.scene.Scene;
import com.cell.rpg.scene.ability.ActorPathStart;
import com.cell.rpg.scene.ability.ActorTransport;
import com.cell.rpg.scene.ability.RegionSpawnNPC.NPCSpawn;
import com.g2d.editor.property.ObjectPropertyPanel;
import com.g2d.editor.property.PropertyCellEdit;
import com.g2d.editor.property.ObjectPropertyPanel.CellEditAdapter;
import com.g2d.studio.Studio;
import com.g2d.studio.gameedit.ObjectSelectCellEdit;
import com.g2d.studio.gameedit.template.XLSUnit;
import com.g2d.studio.rpg.AbilityPanel.AbilityCellEditAdapter;
import com.g2d.studio.scene.entity.SceneNode;
import com.g2d.studio.scene.units.SceneImmutable;
import com.g2d.studio.scene.units.ScenePoint;
import com.g2d.studio.sound.SoundSelectDialog;

public class SceneAbilityAdapters
{
	public static class SceneBGMAdapter implements CellEditAdapter<Scene>
	{
		@Override
		public boolean fieldChanged(Object editObject, Object fieldValue,
				Field field) {
			return false;
		}
		@Override
		public PropertyCellEdit<?> getCellEdit(ObjectPropertyPanel owner,
				Object editObject, Object fieldValue, Field field) {
			if (field.getName().equals("bgm_sound_name")) {
				SoundSelectDialog edit = new SoundSelectDialog(owner, (String)fieldValue);
				edit.showDialog();
				return edit;
			}
			return null;
		}
		
		@Override
		public Component getCellRender(ObjectPropertyPanel owner,
				Object editObject, Object fieldValue, Field field,
				DefaultTableCellRenderer src) {
			return null;
		}
		
		@Override
		public Object getCellValue(Object editObject,
				PropertyCellEdit<?> fieldEdit, Field field, Object fieldSrcValue) {
			return null;
		}
		
		@Override
		public Class<Scene> getType() {
			return Scene.class;
		}
		
	}
	
	/**
	 * 编辑传送点能力的工具
	 * @author WAZA
	 */
	public static class ActorTransportAdapter extends AbilityCellEditAdapter<ActorTransport>
	{
		final SceneEditor editor ;
		
		public ActorTransportAdapter(SceneEditor editor) {
			this.editor = editor;
		}
		
		@Override
		public Class<ActorTransport> getType() {
			return ActorTransport.class;
		}
		
		@Override
		public PropertyCellEdit<?> getCellEdit(
				ObjectPropertyPanel owner,
				Object editObject, 
				Object fieldValue, Field field) {
			if (field.getName().equals("next_scene_id")){
				return new SceneListCellEdit(fieldValue);
			}
			else if (field.getName().equals("next_scene_object_id")){
				ActorTransport tp = (ActorTransport)editObject;
				if (tp.next_scene_id!=null) {
					SceneNode scene = Studio.getInstance().getSceneManager().getSceneNode(tp.next_scene_id);
					return new SceneUnitListCellEdit(scene.getSceneEditor(), SceneImmutable.class);
				}
			}
			return null;
		}
		
		@Override
		public Component getCellRender(ObjectPropertyPanel owner, Object editObject,
				Object fieldValue, Field field, DefaultTableCellRenderer src) {
			if (field.getName().equals("next_scene_id")){
				SceneNode node = null;
				if (fieldValue!=null) {
					String id = (String)fieldValue;
					node = Studio.getInstance().getSceneManager().getSceneNode(id);
				}
				if (fieldValue != null && node != null) {
					src.setText(node.getName() + "(" + node.getID() + ")");
				} else {
//					src.setForeground(Color.RED);
					src.setText("null");
				}
				
			}
			return null;
		}
	}
	
	/**
	 * 编辑单位路点行为的工具
	 * @author WAZA
	 */
	public static class ActorPathStartAdapter extends AbilityCellEditAdapter<ActorPathStart>
	{
		final SceneEditor editor ;
		
		public ActorPathStartAdapter(SceneEditor editor) {
			this.editor = editor;
		}
		
		@Override
		public Class<ActorPathStart> getType() {
			return ActorPathStart.class;
		}
		
		@Override
		public PropertyCellEdit<?> getCellEdit(
				ObjectPropertyPanel owner,
				Object editObject,
				Object fieldValue, Field field) {
			if (field.getName().equals("point_name")){
				return new SceneUnitListCellEdit(editor, ScenePoint.class);
			}
			return null;
		}
		
	}

	/**
	 * 产生区域内产生的单位工具
	 * @author WAZA
	 */
	public static class RegionSpawnNPCNodeAdapter extends AbilityCellEditAdapter<NPCSpawn>
	{
		@Override
		public Class<NPCSpawn> getType() {
			return NPCSpawn.class;
		}
		
		@Override
		public PropertyCellEdit<?> getCellEdit(
				ObjectPropertyPanel owner,
				Object editObject, 
				Object fieldValue, Field field) {
			if (field.getName().equals("template_unit_id")){
				return new ObjectSelectCellEdit<XLSUnit>(XLSUnit.class);
			}
			return null;
		}
		
		@Override
		public Component getCellRender(
				ObjectPropertyPanel owner,
				Object editObject,
				Object fieldValue,
				Field field, DefaultTableCellRenderer src) {
			if (field.getName().equals("template_unit_id")){
				XLSUnit unit = null;
				if (fieldValue != null) {
					String tid = (String)fieldValue;
					unit = Studio.getInstance().getObjectManager().getObject(XLSUnit.class, tid);
				}
				if (fieldValue != null && unit != null) {
					src.setText(unit.getName()+"(" + unit.getID() + ")");
				} else {
//					src.setForeground(Color.RED);
					src.setText("null");
				}
			}
			return src;
		}
		
	}

	
	
//	if (object instanceof AbilitySceneNPCSpawn)
//	{
//		if (field.getName().equals("cpj_actor_name")){
//			return new ActorListComboBox();
//		}
//	}
//	
//	if (object instanceof AbilitySceneNPCTeamNode) {
//		if (field.getName().equals("cpj_actor_name")){
//			return new ActorListComboBox();
//		}
//	}
}
