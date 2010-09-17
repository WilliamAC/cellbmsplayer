package com.g2d.studio.scene.units;

import java.awt.Color;
import java.awt.Shape;
import java.util.Vector;

import com.cell.rpg.scene.SceneUnit;
import com.cell.rpg.scene.script.trigger.Event;
import com.g2d.display.ui.Menu;
import com.g2d.editor.DisplayObjectEditor;
import com.g2d.game.rpg.Unit;
import com.g2d.studio.swing.G2DListItem;

public interface SceneUnitTag<T extends SceneUnit> extends G2DListItem
{
//	---------------------------------------------------------------------------------------	
	public Unit				getGameUnit();
	public T				getUnit();
//	---------------------------------------------------------------------------------------
//	io

	public T 				onWrite();
	public void				onReadComplete(Vector<SceneUnitTag<?>> all);
	public void				onWriteReady(Vector<SceneUnitTag<?>> all);

//	---------------------------------------------------------------------------------------
//	snapshot
	public Color 			getSnapColor();
	public Shape 			getSnapShape();

//	public Class<? extends com.cell.rpg.scene.script.entity.SceneUnit>	
//							getEventType();
	
//	---------------------------------------------------------------------------------------
//	edit
	
	public Menu 					getEditMenu();	
	public DisplayObjectEditor<?>	getEditorForm();

	/**
	 * 当编辑器窗口被关闭时
	 */
	public void				onHideFrom();
}