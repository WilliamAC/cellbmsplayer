package com.fc.lami.Messages
{
	import com.net.client.Message;
	import com.net.client.MessageFactory;
	import com.net.client.NetDataTypes;


	/**
	 * Java Class [68] [com.fc.lami.Messages.SpeakToPrivateRequest]<br>
	 * 此代码为自动生成。不需要在此修改。若有错误，请修改代码生成器。
	 */
	[Bindable]
	public class SpeakToPrivateRequest extends Message
	{
		/** Java type is : <font color=#0000ff>java.lang.String</font> */
		[JavaType(name="java.lang.String", leaf_type=NetDataTypes.TYPE_STRING)]
		public var uid :  String;
		/** Java type is : <font color=#0000ff>java.lang.String</font> */
		[JavaType(name="java.lang.String", leaf_type=NetDataTypes.TYPE_STRING)]
		public var message :  String;

		/**
		 * @param uid as <font color=#0000ff>java.lang.String</font>
		 * @param message as <font color=#0000ff>java.lang.String</font>		 */
		public function SpeakToPrivateRequest(
			uid :  String = null,
			message :  String = null) 
		{
			this.uid = uid;
			this.message = message;
		}
	}
}