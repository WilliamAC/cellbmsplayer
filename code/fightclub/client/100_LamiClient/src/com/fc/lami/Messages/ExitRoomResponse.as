package com.fc.lami.Messages
{
	import com.net.client.Message;
	import com.net.client.MessageFactory;
	import com.net.client.NetDataTypes;


	/**
	 * Java Class [16] [com.fc.lami.Messages.ExitRoomResponse]<br>
	 * 此代码为自动生成。不需要在此修改。若有错误，请修改代码生成器。
	 */
	[Bindable]
	public class ExitRoomResponse extends Message
	{
		/** Java type is : <font color=#0000ff>com.fc.lami.Messages.RoomSnapShot[]</font> */
		[JavaType(name="com.fc.lami.Messages.RoomSnapShot[]", leaf_type=NetDataTypes.TYPE_EXTERNALIZABLE)]
		public var rooms :  Array;

		/**
		 * @param rooms as <font color=#0000ff>com.fc.lami.Messages.RoomSnapShot[]</font>		 */
		public function ExitRoomResponse(
			rooms :  Array = null) 
		{
			this.rooms = rooms;
		}
	}
}