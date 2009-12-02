package com.cell.rpg.template;

import com.cell.rpg.RPGObject;
import com.g2d.annotation.Property;

public abstract class TemplateNode extends RPGObject
{
	transient
	private int 	int_id;
	
	public String	name		= "no name";
	
	@Property("图标编号")
	public String	icon_index;
	
	public TemplateNode(int id, String name) {
		super(id+"");
		this.int_id	= id;
		this.name	= name;
	}
	
	@Override
	protected void init_transient() {
		super.init_transient();
		if (id!=null) {
			this.int_id = Integer.parseInt(id);
		}
	}
	
	final public int getIntID() {
		return int_id;
	}
	
	
}
