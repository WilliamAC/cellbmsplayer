package com.g2d.studio.gameedit.entity;

import java.io.File;
import java.util.Vector;

import com.cell.CIO;
import com.cell.CUtil;
import com.cell.rpg.NamedObject;
import com.cell.rpg.RPGObject;
import com.cell.rpg.io.RPGObjectMap;
import com.g2d.studio.swing.G2DTree;
import com.g2d.studio.swing.G2DTreeNodeGroup;



public abstract class ObjectGroup<T extends ObjectNode<D>, D extends RPGObject> extends G2DTreeNodeGroup<ObjectNode<D>>
{
	private static final long serialVersionUID = 1L;
	
	final static public String _XML	= ".xml";
	
	final public File		list_file;
	final public Class<D>	data_type;
	final public Class<T>	node_type;
	
	public ObjectGroup(String name, File list_file, Class<T> node_type, Class<D> data_type) {
		super(name);
		this.list_file = list_file;
		this.data_type = data_type;
		this.node_type = node_type;
	}

	abstract protected boolean createObjectNode(String key, D data);

	
//	----------------------------------------------------------------------------------------------------------
	
	@Override
	protected boolean pathAddLeafNode(String name, int index, int length) {
		if (name.toLowerCase().endsWith(_XML)) {
			try{
				String key = CUtil.replaceString(name, _XML, "");
				File file = new File(list_file.getParentFile(), name);
				D data = RPGObjectMap.readNode(file.getPath(), data_type);
				return createObjectNode(key, data);
			}catch(Exception err){
				err.printStackTrace();
			}
		}
		return false;
	}
	
	public void saveList()
	{
		if (!list_file.getParentFile().exists()) {
			list_file.getParentFile().mkdirs();
		}
		File name_list_file = new File(list_file.getParentFile(), "name_" + list_file.getName());
		StringBuffer all_objects = new StringBuffer();
		StringBuffer all_names = new StringBuffer();
		Vector<T> nodes = G2DTree.getNodesSubClass(this, node_type);
		for (T node : nodes) {
			try{
				File xml_file = new File(list_file.getParentFile(), node.getID()+_XML);
				if (RPGObjectMap.writeNode(node.getData(), xml_file)){
					all_objects.append(toPathString(node, "/") + node.getID() + _XML + "\n");
				}
				if (node.getData() instanceof NamedObject) {
					all_names.append("("+node.getData().id+")"+((NamedObject)node.getData()).getName()+"\n");
				}
			}catch(Exception err){}
		}
		com.cell.io.CFile.writeText(list_file, all_objects.toString(), "UTF-8");
		if (NamedObject.class.isAssignableFrom(data_type)) {
			com.cell.io.CFile.writeText(name_list_file, all_names.toString(), "UTF-8");
		}
	}
	
	public void loadList()
	{
		try{
			if (list_file.exists()) {
				String[] lines = CIO.readAllLine(list_file.getPath(), "UTF-8");
				for (String line : lines) {
					try{
						loadPath(line.trim());
					}catch(Exception e){
						e.printStackTrace();
					}
				}
			}
		} catch (Exception err) {
			err.printStackTrace();
		}
	}
}