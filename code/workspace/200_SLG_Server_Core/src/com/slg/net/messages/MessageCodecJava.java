package com.slg.net.messages;

import java.io.IOException;
import com.net.mutual.MutualMessage;
import com.net.mutual.MutualMessageCodec;
import com.net.NetDataInput;
import com.net.NetDataOutput;
import com.net.NetDataTypes;


/**
 * 此代码为自动生成。不需要在此修改。若有错误，请修改代码生成器。
 */
public class MessageCodecJava implements MutualMessageCodec
{
	public String getVersion() {
		return "Thu Jun 02 17:27:11 CST 2011";
	}

	public void readExternal(MutualMessage msg, NetDataInput in) throws IOException 
	{
		if (msg.getClass().equals(com.slg.entity.Currency.class)) {
			_r((com.slg.entity.Currency)msg, in); return;
		}
		if (msg.getClass().equals(com.slg.entity.GuageNumber.class)) {
			_r((com.slg.entity.GuageNumber)msg, in); return;
		}
		if (msg.getClass().equals(com.slg.entity.Hero.class)) {
			_r((com.slg.entity.Hero)msg, in); return;
		}
		if (msg.getClass().equals(com.slg.entity.Player.class)) {
			_r((com.slg.entity.Player)msg, in); return;
		}
		if (msg.getClass().equals(com.slg.entity.Position.class)) {
			_r((com.slg.entity.Position)msg, in); return;
		}
		if (msg.getClass().equals(com.slg.entity.Village.class)) {
			_r((com.slg.entity.Village)msg, in); return;
		}
		if (msg.getClass().equals(com.slg.net.messages.Messages.GetTimeRequest.class)) {
			_r((com.slg.net.messages.Messages.GetTimeRequest)msg, in); return;
		}
		if (msg.getClass().equals(com.slg.net.messages.Messages.GetTimeResponse.class)) {
			_r((com.slg.net.messages.Messages.GetTimeResponse)msg, in); return;
		}
		if (msg.getClass().equals(com.slg.net.messages.Messages.LoginRequest.class)) {
			_r((com.slg.net.messages.Messages.LoginRequest)msg, in); return;
		}
		if (msg.getClass().equals(com.slg.net.messages.Messages.LoginResponse.class)) {
			_r((com.slg.net.messages.Messages.LoginResponse)msg, in); return;
		}
		if (msg.getClass().equals(com.slg.net.messages.Messages.LogoutRequest.class)) {
			_r((com.slg.net.messages.Messages.LogoutRequest)msg, in); return;
		}

	}

	public void writeExternal(MutualMessage msg, NetDataOutput out) throws IOException 
	{
		if (msg.getClass().equals(com.slg.entity.Currency.class)) {
			_w((com.slg.entity.Currency)msg, out); return;
		}
		if (msg.getClass().equals(com.slg.entity.GuageNumber.class)) {
			_w((com.slg.entity.GuageNumber)msg, out); return;
		}
		if (msg.getClass().equals(com.slg.entity.Hero.class)) {
			_w((com.slg.entity.Hero)msg, out); return;
		}
		if (msg.getClass().equals(com.slg.entity.Player.class)) {
			_w((com.slg.entity.Player)msg, out); return;
		}
		if (msg.getClass().equals(com.slg.entity.Position.class)) {
			_w((com.slg.entity.Position)msg, out); return;
		}
		if (msg.getClass().equals(com.slg.entity.Village.class)) {
			_w((com.slg.entity.Village)msg, out); return;
		}
		if (msg.getClass().equals(com.slg.net.messages.Messages.GetTimeRequest.class)) {
			_w((com.slg.net.messages.Messages.GetTimeRequest)msg, out); return;
		}
		if (msg.getClass().equals(com.slg.net.messages.Messages.GetTimeResponse.class)) {
			_w((com.slg.net.messages.Messages.GetTimeResponse)msg, out); return;
		}
		if (msg.getClass().equals(com.slg.net.messages.Messages.LoginRequest.class)) {
			_w((com.slg.net.messages.Messages.LoginRequest)msg, out); return;
		}
		if (msg.getClass().equals(com.slg.net.messages.Messages.LoginResponse.class)) {
			_w((com.slg.net.messages.Messages.LoginResponse)msg, out); return;
		}
		if (msg.getClass().equals(com.slg.net.messages.Messages.LogoutRequest.class)) {
			_w((com.slg.net.messages.Messages.LogoutRequest)msg, out); return;
		}

	}

//	----------------------------------------------------------------------------------------------------
//	com.slg.entity.Currency
//	----------------------------------------------------------------------------------------------------
	public com.slg.entity.Currency new_com_slg_entity_Currency(){return new com.slg.entity.Currency();}
	private void _r(com.slg.entity.Currency msg, NetDataInput in) throws IOException {
		msg.gold = in.readInt();
	}
	private void _w(com.slg.entity.Currency msg, NetDataOutput out) throws IOException {
		out.writeInt(msg.gold);
	}

//	----------------------------------------------------------------------------------------------------
//	com.slg.entity.GuageNumber
//	----------------------------------------------------------------------------------------------------
	public com.slg.entity.GuageNumber new_com_slg_entity_GuageNumber(){return new com.slg.entity.GuageNumber();}
	private void _r(com.slg.entity.GuageNumber msg, NetDataInput in) throws IOException {
	}
	private void _w(com.slg.entity.GuageNumber msg, NetDataOutput out) throws IOException {
	}

//	----------------------------------------------------------------------------------------------------
//	com.slg.entity.Hero
//	----------------------------------------------------------------------------------------------------
	public com.slg.entity.Hero new_com_slg_entity_Hero(){return new com.slg.entity.Hero();}
	private void _r(com.slg.entity.Hero msg, NetDataInput in) throws IOException {
		msg.id = in.readInt();
		msg.name = in.readUTF();
		msg.exp = in.readExternal(com.slg.entity.GuageNumber.class);
		msg.level = in.readInt();
		msg.hp = in.readExternal(com.slg.entity.GuageNumber.class);
		msg.attack = in.readInt();
		msg.politics = in.readInt();
		msg.commander = in.readInt();
		msg.sex = in.readInt();
		msg.loyalty = in.readExternal(com.slg.entity.GuageNumber.class);
		msg.quality = in.readInt();
		msg.max_skill_count = in.readInt();
		msg.skill_list = (com.slg.entity.Skill[])in.readExternalArray(com.slg.entity.Skill.class);
		msg.max_item_count = in.readInt();
		msg.item_list = (com.slg.entity.Item[])in.readExternalArray(com.slg.entity.Item.class);
	}
	private void _w(com.slg.entity.Hero msg, NetDataOutput out) throws IOException {
		out.writeInt(msg.id);
		out.writeUTF(msg.name);
		out.writeExternal(msg.exp);
		out.writeInt(msg.level);
		out.writeExternal(msg.hp);
		out.writeInt(msg.attack);
		out.writeInt(msg.politics);
		out.writeInt(msg.commander);
		out.writeInt(msg.sex);
		out.writeExternal(msg.loyalty);
		out.writeInt(msg.quality);
		out.writeInt(msg.max_skill_count);
		out.writeExternalArray(msg.skill_list);
		out.writeInt(msg.max_item_count);
		out.writeExternalArray(msg.item_list);
	}

//	----------------------------------------------------------------------------------------------------
//	com.slg.entity.Player
//	----------------------------------------------------------------------------------------------------
	public com.slg.entity.Player new_com_slg_entity_Player(){return new com.slg.entity.Player();}
	private void _r(com.slg.entity.Player msg, NetDataInput in) throws IOException {
		msg.player_id = in.readInt();
		msg.name = in.readUTF();
		msg.office = in.readInt();
		msg.exp = in.readExternal(com.slg.entity.GuageNumber.class);
		msg.level = in.readInt();
		msg.ap = in.readExternal(com.slg.entity.GuageNumber.class);
		msg.currency = in.readExternal(com.slg.entity.Currency.class);
	}
	private void _w(com.slg.entity.Player msg, NetDataOutput out) throws IOException {
		out.writeInt(msg.player_id);
		out.writeUTF(msg.name);
		out.writeInt(msg.office);
		out.writeExternal(msg.exp);
		out.writeInt(msg.level);
		out.writeExternal(msg.ap);
		out.writeExternal(msg.currency);
	}

//	----------------------------------------------------------------------------------------------------
//	com.slg.entity.Position
//	----------------------------------------------------------------------------------------------------
	public com.slg.entity.Position new_com_slg_entity_Position(){return new com.slg.entity.Position();}
	private void _r(com.slg.entity.Position msg, NetDataInput in) throws IOException {
	}
	private void _w(com.slg.entity.Position msg, NetDataOutput out) throws IOException {
	}

//	----------------------------------------------------------------------------------------------------
//	com.slg.entity.Village
//	----------------------------------------------------------------------------------------------------
	public com.slg.entity.Village new_com_slg_entity_Village(){return new com.slg.entity.Village();}
	private void _r(com.slg.entity.Village msg, NetDataInput in) throws IOException {
		msg.id = in.readInt();
		msg.name = in.readUTF();
		msg.food = in.readInt();
		msg.city_id = in.readInt();
		msg.buildings = in.readIntArray();
		msg.heros = in.readIntArray();
		msg.arms_list = (com.slg.entity.Arms[])in.readExternalArray(com.slg.entity.Arms.class);
		msg.soldiers_list = (com.slg.entity.Soldiers[])in.readExternalArray(com.slg.entity.Soldiers.class);
	}
	private void _w(com.slg.entity.Village msg, NetDataOutput out) throws IOException {
		out.writeInt(msg.id);
		out.writeUTF(msg.name);
		out.writeInt(msg.food);
		out.writeInt(msg.city_id);
		out.writeIntArray(msg.buildings);
		out.writeIntArray(msg.heros);
		out.writeExternalArray(msg.arms_list);
		out.writeExternalArray(msg.soldiers_list);
	}

//	----------------------------------------------------------------------------------------------------
//	com.slg.sanguosha.Messages.GetTimeRequest
//	----------------------------------------------------------------------------------------------------
	public com.slg.net.messages.Messages.GetTimeRequest new_com_slg_sanguosha_Messages_GetTimeRequest(){return new com.slg.net.messages.Messages.GetTimeRequest();}
	private void _r(com.slg.net.messages.Messages.GetTimeRequest msg, NetDataInput in) throws IOException {
		msg.message = in.readUTF();
	}
	private void _w(com.slg.net.messages.Messages.GetTimeRequest msg, NetDataOutput out) throws IOException {
		out.writeUTF(msg.message);
	}

//	----------------------------------------------------------------------------------------------------
//	com.slg.sanguosha.Messages.GetTimeResponse
//	----------------------------------------------------------------------------------------------------
	public com.slg.net.messages.Messages.GetTimeResponse new_com_slg_sanguosha_Messages_GetTimeResponse(){return new com.slg.net.messages.Messages.GetTimeResponse();}
	private void _r(com.slg.net.messages.Messages.GetTimeResponse msg, NetDataInput in) throws IOException {
		msg.time = in.readUTF();
	}
	private void _w(com.slg.net.messages.Messages.GetTimeResponse msg, NetDataOutput out) throws IOException {
		out.writeUTF(msg.time);
	}

//	----------------------------------------------------------------------------------------------------
//	com.slg.sanguosha.Messages.LoginRequest
//	----------------------------------------------------------------------------------------------------
	public com.slg.net.messages.Messages.LoginRequest new_com_slg_sanguosha_Messages_LoginRequest(){return new com.slg.net.messages.Messages.LoginRequest();}
	private void _r(com.slg.net.messages.Messages.LoginRequest msg, NetDataInput in) throws IOException {
		msg.name = in.readUTF();
		msg.validate = in.readUTF();
		msg.version = in.readUTF();
	}
	private void _w(com.slg.net.messages.Messages.LoginRequest msg, NetDataOutput out) throws IOException {
		out.writeUTF(msg.name);
		out.writeUTF(msg.validate);
		out.writeUTF(msg.version);
	}

//	----------------------------------------------------------------------------------------------------
//	com.slg.sanguosha.Messages.LoginResponse
//	----------------------------------------------------------------------------------------------------
	public com.slg.net.messages.Messages.LoginResponse new_com_slg_sanguosha_Messages_LoginResponse(){return new com.slg.net.messages.Messages.LoginResponse();}
	private void _r(com.slg.net.messages.Messages.LoginResponse msg, NetDataInput in) throws IOException {
		msg.result = in.readShort();
		msg.version = in.readUTF();
		msg.player_data = in.readExternal(com.slg.entity.Player.class);
	}
	private void _w(com.slg.net.messages.Messages.LoginResponse msg, NetDataOutput out) throws IOException {
		out.writeShort(msg.result);
		out.writeUTF(msg.version);
		out.writeExternal(msg.player_data);
	}

//	----------------------------------------------------------------------------------------------------
//	com.slg.sanguosha.Messages.LogoutRequest
//	----------------------------------------------------------------------------------------------------
	public com.slg.net.messages.Messages.LogoutRequest new_com_slg_sanguosha_Messages_LogoutRequest(){return new com.slg.net.messages.Messages.LogoutRequest();}
	private void _r(com.slg.net.messages.Messages.LogoutRequest msg, NetDataInput in) throws IOException {
	}
	private void _w(com.slg.net.messages.Messages.LogoutRequest msg, NetDataOutput out) throws IOException {
	}


}
