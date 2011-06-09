package com.fc.lami.Messages
{
	import com.net.client.Message;
	import com.net.client.MessageFactory;
	import com.net.client.NetDataTypes;


	/**
	 * Java Class [18] [com.fc.lami.Messages.GameOverToRoomNotify]<br>
	 * 此代码为自动生成。不需要在此修改。若有错误，请修改代码生成器。
	 */
	[Bindable]
	public class GameOverToRoomNotify extends Message
	{
		/** Java type is : <font color=#0000ff>int</font> */
		[JavaType(name="int", leaf_type=NetDataTypes.TYPE_INT)]
		public var desk_id :  int;

		/**
		 * @param desk_id as <font color=#0000ff>int</font>		 */
		public function GameOverToRoomNotify(
			desk_id :  int = 0) 
		{
			this.desk_id = desk_id;
		}
	}
}