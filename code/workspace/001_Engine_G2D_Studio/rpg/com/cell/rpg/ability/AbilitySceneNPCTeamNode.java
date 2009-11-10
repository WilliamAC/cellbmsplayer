package com.cell.rpg.ability;

import com.cell.CUtil;
import com.g2d.annotation.Property;


@Property("[单位能力] NPC队伍中的一个单位")
public class AbilitySceneNPCTeamNode extends AbstractAbility 
{
	private static final long serialVersionUID = 1L;
	
	/** 对应单位 */
	@Property("对应单位")
	public	String		template_unit_id;
	
	/** 战斗时处在第几行 */
	@Property("战斗时处在第几行")
	public	int			battle_row;
	
	/** 战斗时处在第几列 */
	@Property("战斗时处在第几列")
	public	int			battle_column;
	
	@Override
	public boolean isMultiField() {
		return true;
	}
	
	@Override
	public String toString() {
		return super.toString() + " :(r" + battle_row + ",c" + battle_column + ")";
	}
}
