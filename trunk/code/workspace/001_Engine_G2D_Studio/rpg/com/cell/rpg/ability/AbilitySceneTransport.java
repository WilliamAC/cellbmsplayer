package com.cell.rpg.ability;

import com.cell.CUtil;
import com.g2d.annotation.Property;

/**
 * 提供单位场景传送点的能力
 * @author WAZA
 *
 */
@Property("[单位能力] 场景传送点")
public class AbilitySceneTransport extends AbstractAbility {

	private static final long serialVersionUID = 1L;
	
	@Property("传送到目标场景名字")
	public String destination_scene_name;
	
	@Property("传送到目标场景的特定单位名字")
	public String destination_scene_object_name;
	
	/**
	 * 传送到目标场景SceneSet
	 * @return
	 */
	public String getDstCPJName() {
		return CUtil.splitString(destination_scene_name, "/")[0];
	}
	
	/**
	 * 传送到目标场景SceneSet的SceneID
	 * @return
	 */
	public String getDstCPJSceneName() {
		return CUtil.splitString(destination_scene_name, "/")[1];
	}
	
	@Override
	public boolean isMultiField() {
		return false;
	}
	
	@Override
	public String toString() {
		return super.toString() + " : scene=" + destination_scene_name + " : unit=" + destination_scene_object_name;
	}
}
