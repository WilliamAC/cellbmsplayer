package com.fc.castle.data.message.Messages
{
	import com.cell.net.io.MutualMessage;
	import com.cell.net.io.MessageFactory;
	import com.cell.net.io.NetDataTypes;
	import com.fc.castle.data.*;
	import com.fc.castle.data.message.*;
	import com.fc.castle.data.message.Messages.*;
	import com.fc.castle.data.template.*;
	import com.fc.castle.data.template.Enums.*;


	/**
	 * 下一关新手引导<br>
	 * Java Class [21] [com.fc.castle.data.message.Messages.NextGuideRequest]<br>
	 * 此代码为自动生成。不需要在此修改。若有错误，请修改代码生成器。
	 */
	[Bindable] 
	public class NextGuideRequest implements MutualMessage
	{
		/** Java type is : <font color=#0000ff>int</font>*/
		public var player_id :  int;

		/**
		 * @param player_id as <font color=#0000ff>int</font>		 */
		public function NextGuideRequest(
			player_id :  int = 0) 
		{
			this.player_id = player_id;
		}
	}
}