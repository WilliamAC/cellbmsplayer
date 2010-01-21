package com.cell.rpg.xls;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicReference;

import jxl.Sheet;
import jxl.Workbook;

import com.cell.CIO;

public class XLSRow implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	final public XLSFile 	xls_file;
	
	final public String 	id;
	final public String 	desc;
	
	public XLSRow(XLSFile file, String id, String desc) {
		this.xls_file = file;
		this.id = id;
		this.desc = desc;
	}
	
	@Override
	public String toString() {
		return desc + "(" + id + ")";
	}
	
//	---------------------------------------------------------------------------------------------------------
	
	/**
	 * 返回以 xls 的 row[c0][c1] 的集合
	 * @param xls_file
	 * @return
	 */
	public static <T extends XLSRow> Collection<T> getXLSRows(File path, Class<T> cls)
	{
		return getXLSRows(path, new AtomicReference<XLSFile>(null), cls);
	}
	
	/**
	 * 返回以 xls 的 row[c0][c1] 的集合
	 * @param xls_file
	 * @return
	 */
	public static <T extends XLSRow> Collection<T> getXLSRows(File path, XLSFile xls_file, Class<T> cls)
	{
		return getXLSRows(path, new AtomicReference<XLSFile>(xls_file), cls);
	}
	
	/**
	 * 返回以 xls 的 row[c0][c1] 的集合
	 * @param xls_file
	 * @return
	 */
	public static <T extends XLSRow> Collection<T> getXLSRows(
			File path, 
			AtomicReference<XLSFile> xls_file_ref,
			Class<T> cls)
	{
		ArrayList<T>	ret			= new ArrayList<T>();
		XLSFile			xls_file;
		if (xls_file_ref!=null) {
			if (xls_file_ref.get()!=null) {
				xls_file =  xls_file_ref.get();
			} else {
				xls_file	= new XLSFile(path);
				xls_file_ref.set(xls_file);
			}
		} else {
			xls_file	= new XLSFile(path);
		}

		InputStream		is			= CIO.loadStream(path.getPath());
		try {
			Workbook	rwb				= Workbook.getWorkbook(is);
			for (Sheet rs : rwb.getSheets()) {
				int row_count = rs.getRows();
				int column_count = rs.getColumns();
				for (int r = 2; r < row_count; r++) 
				{
					try {
						String primary_key = rs.getCell(1, r).getContents().trim();
						if (primary_key.length() <= 0) {
							System.out.println("\ttable eof at row " + r + " sheet " + rs.getName());
							break;
						}
						String c0 = rs.getCell(0, r).getContents().trim();
						String c1 = rs.getCell(1, r).getContents().trim();
						
						if (cls.equals(XLSRow.class)) {
							ret.add(cls.cast(new XLSRow(xls_file, c1, c0)));
						} else if (cls.equals(XLSFullRow.class)) {
							XLSFullRow full_row = new XLSFullRow(xls_file, c1, c0);
							for (int c = 1; c < column_count; c++) {
								String cdesc	= rs.getCell(c, 0).getContents();
								String cname	= rs.getCell(c, 1).getContents();
								String cvalue	= rs.getCell(c, r).getContents();
								full_row.put(cname, cvalue, cdesc);
							}
							ret.add(cls.cast(full_row));
						}
					}
					catch (Exception e) {
						System.err.println("read error at row " + r + " sheet " + rs.getName());
					}
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return ret;
	}
}
