/**
 * 
 */
package com.cell.sql;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cell.CUtil.ICompare;
import com.cell.sql.anno.SQLField;
import com.cell.sql.anno.SQLGroupField;

public class SQLColumn implements ICompare<SQLColumn, SQLColumn>
{
	final public static Logger 		log 		= LoggerFactory.getLogger(SQLColumn.class);
	
	/** 在数据库中，该列的描述 */
	private final SQLField 			anno;
	
	/** 该字段在数据库中的名字 */
	private final String			name;

	/**得到层次关系Field*/
	final private ArrayList<Field>	fields;
	
	/**得到最终数据Field*/
	private final Field				leaf_field;
	
//	/**在层次中，是否有标注过只读*/
//	private boolean 				is_read_only = false;
	
	/** 该字段在数据库中的位置 */
	private int						index;

	public SQLColumn(SQLField anno, Stack<Field> fields_stack)
	{
		this.anno		= anno;
		this.fields 	= new ArrayList<Field>(fields_stack);
		this.leaf_field	= this.fields.get(fields.size()-1);
//		if (anno.readOnly()) {
//			is_read_only = true;
//		}
		String name = fields.get(0).getName();
		for (int i = 1; i < fields.size(); i++) {
			Field f = fields.get(i);
			name += "__" + f.getName();
//			SQLField afs = f.getAnnotation(SQLField.class);
//			if (afs != null) {
//				if (afs.readOnly()) {
//					is_read_only = true;
//				}
//			}
//			SQLGroupField afg = f.getAnnotation(SQLGroupField.class);
//			if (afg != null) {
//				if (afg.readOnly()) {
//					is_read_only = true;
//				}
//			}
		}
		this.name		= name;
	}

	final public int getIndex() {
		return index;
	}

	final public SQLField getAnno() {
		return anno;
	}

	final public String getName() {
		return name;
	}

	final public Field getLeafField() {
		return leaf_field;
	}
	
	final void setIndex(int i){
		index = i;
	}

	public String getConstraint()
	{
		StringBuilder ret = new StringBuilder();
		
		if (getAnno().size()>0) {
			ret.append(" (" + getAnno().size() +")");
		}
		
		if (getAnno().not_null()) {
			ret.append(" NOT NULL");
		}
		
		if (getAnno().auto_increment()) {
			ret.append(" AUTO_INCREMENT");
		}
		
		String default_value = getAnno().default_value();
		if (default_value != null && !default_value.isEmpty()) {
			ret.append(" DEFAULT '" + getAnno().default_value() + "'");
		}
		
		return ret.toString();
	}
	
	final public String getAllComment() {
		String comment = getAnno().comment();
		for (int i = fields.size() - 2; i >= 0; i--) {
			Field field = fields.get(i);
			SQLGroupField gf = field.getAnnotation(SQLGroupField.class);
			if (gf != null) {
				comment = gf.comment_prefix() + ". " + comment;
			}
		}
		return comment;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " : " + getName();
	}

	public int compare(SQLColumn a, SQLColumn b) {
		return b.index - a.index;
	}

	SQLFieldGroup getLeafTable(SQLFieldGroup table) throws Exception
	{
		for (int i=1; i<fields.size(); i++) {
			Field field = fields.get(i-1);
			Object obj = table.getField(field);
			if (obj == null) {
				obj = field.getType().newInstance();
				table.setField(field, obj);
			}
			table = (SQLFieldGroup)obj;
		}
		return table;
	}
	
	public Object getObject(SQLFieldGroup table) throws Exception
	{
		table = getLeafTable(table);
		Object java_object = table.getField(getLeafField());
		try{
			return SQMTypeManager.getTypeComparer().toSQLObject(
					getAnno().type(), 
					getLeafField().getType(),
					java_object);
		} catch (Exception err) {
			log.error("getObject Column field \"" + getLeafField().getName() + "@"+table+"\"" +
					" : error=" + err.getMessage());
			throw err;
		}
	}
	
	public void setObject(SQLFieldGroup table, Object data) throws Exception
	{
		if (data != null) {
			table = getLeafTable(table);
			try{
				table.setField(getLeafField(), 
						SQMTypeManager.getTypeComparer().toJavaObject(
								getAnno().type(),
								getLeafField().getType(),
								data));
			} catch (Exception err) {
				log.error("setObject Column field \"" + getLeafField().getName() + "@"+table+"\"" +
						" : data="+data+
						" : error=" + err.getMessage());
				table.setField(getLeafField(), null);
				throw err;
			}
		}
	}

}