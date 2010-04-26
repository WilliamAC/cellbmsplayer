package com.cell.rpg.template;

import com.cell.rpg.anno.PropertyAdapter;
import com.cell.rpg.anno.PropertyType;
import com.cell.rpg.display.UnitNode;
import com.cell.rpg.quest.QuestState;
import com.cell.rpg.template.ability.QuestItemDrop;
import com.cell.rpg.template.ability.UnitBattleTeam;
import com.cell.rpg.template.ability.UnitItemDrop;
import com.cell.rpg.template.ability.UnitItemSell;
import com.g2d.annotation.Property;



public class TUnit extends TemplateNode
{
	UnitNode display_node;

	@Property("只显示在接了某任务")
	public QuestState 	show_in_quest_state		= QuestState.NA;
	
	@Property("只显示在接了某任务ID")@PropertyAdapter(PropertyType.QUEST_ID)
	public int 			show_in_quest_id		= -1;
	
	public TUnit(
			int id, 
			String name) 
	{
		super(id, name);
	}
	
	public void setDisplayNode(String cpj_name, String set_name) {
		display_node = new UnitNode(cpj_name, set_name);
	}
	
	public UnitNode getDisplayNode() {
		return display_node;
	}
	
	@Override
	public Class<?>[] getSubAbilityTypes() {
		return new Class<?>[]{
				UnitBattleTeam.class,
				UnitItemDrop.class,
				QuestItemDrop.class,
				UnitItemSell.class,
		};
	}
}
