package com.cell.rpg.quest;

import java.io.File;
import java.util.ArrayList;

import com.cell.io.CFile;
import com.cell.rpg.RPGObject;
import com.cell.rpg.quest.script.QuestScript;
import com.cell.util.MarkedHashtable;
import com.g2d.annotation.Property;

/**
 * 一个任务的全部描述
 * @author WAZA
 */
public class Quest extends RPGObject
{
//	----------------------------------------------------------------------------------------------------------------
//	base
	
	/** 任务id */
	final private Integer 		int_id;
	
	/** 任务名字 */
	public String				name;
	
	/**任务标志*/
	@Property("任务标志")
	public QuestFlags			quest_flags			= new QuestFlags();

	
	/**满足条件时自动接收*/
	@Property("满足条件时自动接收")
	public boolean				auto_accept			= false;
	
	/**满足条件时自动提交*/
	@Property("满足条件时自动提交")
	public boolean				auto_commit			= false;

//	----------------------------------------------------------------------------------------------------------------
//	quest

	/** 任务内容, 该字段由文件存储，注意反序列化后恢复*/
	transient
	private String				discussion			= QuestScript.createExample();

	/**任务产生事件*/
	public QuestGenerator		quest_generator		= new QuestGenerator();
	
	/** 任务接受条件 */
	public QuestCondition		accept_condition	= new QuestCondition();
	/**任务接受奖励*/
	public QuestAward			accept_award		= new QuestAward();
	/** 任务完成条件 */
	public QuestCondition		complete_condition	= new QuestCondition();
	/** 任务完成奖励 */
	public QuestAward			complete_award		= new QuestAward();
	
//	----------------------------------------------------------------------------------------------------------------
//	extend

	/** 任务图标 */ 
	@Property("任务图标")
	public String				icon_index;

//	----------------------------------------------------------------------------------------------------------------
	public Quest(Integer id, String name) {
		super(id.toString());
		this.int_id = id;
		this.name	= name;
	}

	public int getIntID() {
		return int_id;
	}
	@Override
	public Class<?>[] getSubAbilityTypes() {
		return new Class<?>[]{};
	}
	
	@Override
	public void onReadComplete(RPGObject object, String xmlFile) {
		File txt_file = new File(xmlFile+".txt");
		if (txt_file.exists()) {
			this.discussion = CFile.readText(txt_file, "UTF-8");
		} else {
			this.discussion = QuestScript.createExample();
		}

		if (accept_condition == null) {
			accept_condition = new QuestCondition();
		}
		if (accept_award == null) {
			accept_award = new QuestAward();
		}
		if (complete_condition == null) {
			complete_condition = new QuestCondition();
		}
		if (complete_award == null) {
			complete_award = new QuestAward();
		}
	}
	
	@Override
	public void onWriteBefore(RPGObject object, String xmlFile) {
		File txt_file = new File(xmlFile+".txt");
		CFile.writeText(txt_file, this.discussion, "UTF-8");
	}
	
//	----------------------------------------------------------------------------------------------------------------
	
	/** 任务内容, 该字段由文件存储，注意反序列化后恢复*/
	public void setDiscussion(String text) {
		this.discussion = text;
	}
	
	/** 任务内容, 该字段由文件存储，注意反序列化后恢复*/
	public String getDiscussion() {
		return discussion;
	}

//	----------------------------------------------------------------------------------------------------------------

}
