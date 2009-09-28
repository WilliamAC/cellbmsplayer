package com.cell.sql;

import java.lang.reflect.Field;
import java.sql.Types;

import com.cell.sql.util.SQLUtil;

public class SQLTypeComparerMySQL implements SQLTypeComparer 
{

	public boolean typeEquals(SQLType type, int mysql_jdbc_type) 
	{
		switch(type)
		{
		case STRUCT:
			switch(mysql_jdbc_type){
			case Types.BINARY: 			return true;
			case Types.VARBINARY: 		return true;
			case Types.LONGVARBINARY: 	return true;
			}
			break;
		case TEXT_STRUCT:
			switch(mysql_jdbc_type){
			case Types.VARCHAR: 		return true;
			case Types.LONGVARCHAR: 	return true;
			}
			break;
		case BOOLEAN:
			switch (mysql_jdbc_type) {
			case Types.TINYINT: 		return true;
			case Types.BIT:				return true;
			}
			break;
		}
		return type.jdbc_type == mysql_jdbc_type;
	}

	public Object toJavaObject(SQLType type, Class<?> type_clazz, Object sqlObject) throws Exception 
	{
		switch(type)
		{
		case STRUCT:
			return SQLUtil.binToBlob((byte[])sqlObject);
		case TEXT_STRUCT:
			return SQLUtil.stringToClob((String)sqlObject, type_clazz);
		case BYTE:
			return ((Number)sqlObject).byteValue();
		case SHORT:
			return ((Number)sqlObject).shortValue();
		default:
			return sqlObject;
		}
	}
	
	public Object toSQLObject(SQLType type, Class<?> type_clazz, Object javaObject) throws Exception 
	{
		switch(type)
		{
		case STRUCT:
			return SQLUtil.blobToBin((SQLStructBLOB)javaObject);
		case TEXT_STRUCT:
			return SQLUtil.clobToString((SQLStructCLOB)javaObject);
		default:
			return javaObject;
		}
	}
	
	public String getDirverTypeString(int jdbc_type) 
	{
		switch (jdbc_type) {
		case Types.BOOLEAN:		return "boolean";
		case Types.TINYINT: 	return "tinyint";
		case Types.SMALLINT:	return "smallint";
		case Types.INTEGER: 	return "integer";
		case Types.BIGINT: 		return "bigint";
		case Types.REAL: 		return "float";
		case Types.DOUBLE: 		return "double";
		case Types.VARCHAR: 	return "varchar";
		case Types.BLOB: 		return "blob";
		case Types.CLOB: 		return "text";
		case Types.TIME: 		return "time";
		case Types.TIMESTAMP:	return "timestamp";
		}
		return null;
	}
}

