package com.cell.rpg.template.ability;

import java.util.HashMap;

import com.cell.rpg.ability.AbstractAbility;
import com.g2d.annotation.Property;


/**
 * 由若干道具产生另外若干道具的公式
 * @author WAZA
 */
@Property("道具配方")
public class ItemFormula extends AbstractAbility
{
	/**材料列表<道具ID, 数量>*/
	@Property("材料列表")
	public HashMap<Integer, Integer> src_items_id = new HashMap<Integer, Integer>();
	
	/**产生物列表<道具ID, 数量>*/
	@Property("产生物列表")
	public HashMap<Integer, Integer> dst_items_id = new HashMap<Integer, Integer>();
	
	public ItemFormula() {}
	
	@Override
	public boolean isMultiField() {
		return true;
	}

}
