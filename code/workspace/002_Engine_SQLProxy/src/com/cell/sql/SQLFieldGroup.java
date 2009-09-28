package com.cell.sql;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

import com.cell.sql.anno.SQLField;

/**
 * 用来描述多个字段的组合，该字段包含的字段将存储为表的字段，
 * 组合字段可以包含组合字段，这是一个递归的过程。
 * 整个体系可以被描述成一个树形结构。
 * @author WAZA
 */
public interface SQLFieldGroup
{
	public void setField(Field field, Object value) throws Exception;
	
	public Object getField(Field field) throws Exception;
}
