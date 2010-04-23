package com.cell.rpg.template;

import java.util.ArrayList;

import com.cell.rpg.ability.AbstractAbility;
import com.g2d.annotation.Property;

public class TItemList extends TemplateNode 
{
	public TItemList(int id, String name) {
		super(id, name);
	}

	@Override
	public Class<?>[] getSubAbilityTypes() {
		return new Class[] {
				UnitDropItems.class,
		};
	}
	
	/**
	 * 掉落物品列表
	 * @author WAZA
	 */
	@Property("[单位能力] 掉落物品列表")
	static public class UnitDropItems extends AbstractAbility
	{
		private static final long serialVersionUID = 1L;

		@Property("产生的单位")
		public DropItems	item_types = new DropItems();
		
		public UnitDropItems() {}
		
		@Override
		public boolean isMultiField() {
			return true;
		}

		public static class DropItems extends ArrayList<DropItemNode>
		{
			private static final long serialVersionUID = 1L;
		}
		
		@Property("[单位能力] 掉落物品")
		public static class DropItemNode extends AbstractAbility
		{
			private static final long serialVersionUID = 1L;
			
			@Property("物品")
			public int		titem_id;
			@Property("百分比")
			public float	drop_rate_percent;
			
			public DropItemNode(){}
			
			public DropItemNode(int titem_id, float percent) 
			{
				this.titem_id = titem_id;
				this.drop_rate_percent = percent;
			}

			@Override
			public boolean isMultiField() {
				return true;
			}
		}
	}
	
}
