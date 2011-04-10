package com.fc.lami.Messages
{
	import com.net.client.Message;
	import com.net.client.MessageFactory;
	import com.net.client.NetDataTypes;


	/**
	 * Java Class [39] [com.fc.lami.Messages.RetakeCardNotify]<br>
	 * 此代码为自动生成。不需要在此修改。若有错误，请修改代码生成器。
	 */
	[Bindable]
	public class RetakeCardNotify extends Message
	{
		/** Java type is : <font color=#0000ff>int</font> */
		[JavaType(name="int", leaf_type=NetDataTypes.TYPE_INT)]
		public var player_id :  int;
		/** Java type is : <font color=#0000ff>com.fc.lami.Messages.CardData[]</font> */
		[JavaType(name="com.fc.lami.Messages.CardData[]", leaf_type=NetDataTypes.TYPE_EXTERNALIZABLE)]
		public var cards :  Array;

		/**
		 * @param player_id as <font color=#0000ff>int</font>
		 * @param cards as <font color=#0000ff>com.fc.lami.Messages.CardData[]</font>		 */
		public function RetakeCardNotify(
			player_id :  int = 0,
			cards :  Array = null) 
		{
			this.player_id = player_id;
			this.cards = cards;
		}
	}
}