package com.fc.lami.Messages
{
	import com.net.client.Message;
	import com.net.client.MessageFactory;


	/**
	 * Java Class [18] [com.fc.lami.Messages.PlayerData]<br>
	 * 此代码为自动生成。不需要在此修改。若有错误，请修改代码生成器。
	 */
	public class PlayerData extends Message
	{
		/** Java type is : <font color=#0000ff>int</font> */
		public var player_id :  int;
		/** Java type is : <font color=#0000ff>java.lang.String</font> */
		public var name :  String;

		/**
		 * @param player_id as <font color=#0000ff>int</font>
		 * @param name as <font color=#0000ff>java.lang.String</font>		 */
		public function PlayerData(
			player_id :  int = 0,
			name :  String = null) 
		{
			this.player_id = player_id;
			this.name = name;
		}
	}
}