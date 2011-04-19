package com.fc.lami.Messages
{
	import com.net.client.Message;
	import com.net.client.MessageFactory;
	import com.net.client.NetDataTypes;


	/**
	 * Java Class [36] [com.fc.lami.Messages.PlayerData]<br>
	 * 此代码为自动生成。不需要在此修改。若有错误，请修改代码生成器。
	 */
	[Bindable]
	public class PlayerData extends Message
	{
		/** Java type is : <font color=#0000ff>int</font> */
		[JavaType(name="int", leaf_type=NetDataTypes.TYPE_INT)]
		public var player_id :  int;
		/** Java type is : <font color=#0000ff>java.lang.String</font> */
		[JavaType(name="java.lang.String", leaf_type=NetDataTypes.TYPE_STRING)]
		public var name :  String;
		/** Java type is : <font color=#0000ff>int</font> */
		[JavaType(name="int", leaf_type=NetDataTypes.TYPE_INT)]
		public var score :  int;
		/** Java type is : <font color=#0000ff>int</font> */
		[JavaType(name="int", leaf_type=NetDataTypes.TYPE_INT)]
		public var win :  int;
		/** Java type is : <font color=#0000ff>int</font> */
		[JavaType(name="int", leaf_type=NetDataTypes.TYPE_INT)]
		public var lose :  int;
		/** Java type is : <font color=#0000ff>int</font> */
		[JavaType(name="int", leaf_type=NetDataTypes.TYPE_INT)]
		public var level :  int;

		/**
		 * @param player_id as <font color=#0000ff>int</font>
		 * @param name as <font color=#0000ff>java.lang.String</font>
		 * @param score as <font color=#0000ff>int</font>
		 * @param win as <font color=#0000ff>int</font>
		 * @param lose as <font color=#0000ff>int</font>
		 * @param level as <font color=#0000ff>int</font>		 */
		public function PlayerData(
			player_id :  int = 0,
			name :  String = null,
			score :  int = 0,
			win :  int = 0,
			lose :  int = 0,
			level :  int = 0) 
		{
			this.player_id = player_id;
			this.name = name;
			this.score = score;
			this.win = win;
			this.lose = lose;
			this.level = level;
		}
	}
}