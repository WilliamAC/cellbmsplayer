package com.fc.lami.Messages
{
	import com.net.client.Message;
	import com.net.client.MessageFactory;
	import com.net.client.NetDataTypes;


	/**
	 * Java Class [65] [com.fc.lami.Messages.SpeakToChannelNotify]<br>
	 * 此代码为自动生成。不需要在此修改。若有错误，请修改代码生成器。
	 */
	[Bindable]
	public class SpeakToChannelNotify extends Message
	{
		/** Java type is : <font color=#0000ff>int</font> */
		[JavaType(name="int", leaf_type=NetDataTypes.TYPE_INT)]
		public var player_id :  int;
		/** Java type is : <font color=#0000ff>java.lang.String</font> */
		[JavaType(name="java.lang.String", leaf_type=NetDataTypes.TYPE_STRING)]
		public var message :  String;

		/**
		 * @param player_id as <font color=#0000ff>int</font>
		 * @param message as <font color=#0000ff>java.lang.String</font>		 */
		public function SpeakToChannelNotify(
			player_id :  int = 0,
			message :  String = null) 
		{
			this.player_id = player_id;
			this.message = message;
		}
	}
}