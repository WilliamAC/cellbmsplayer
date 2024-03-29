package com.slg.net.messages.Messages
{
	import com.net.client.Message;
	import com.net.client.MessageFactory;
	import com.net.client.NetDataTypes;
	import com.slg.entity.*;

	/**
	 * Java Class [11] [com.slg.net.messages.Messages.GetTimeResponse]<br>
	 * 此代码为自动生成。不需要在此修改。若有错误，请修改代码生成器。
	 */
	[Bindable]
	public class GetTimeResponse extends Message
	{
		/** Java type is : <font color=#0000ff>java.lang.String</font> */
		[JavaType(name="java.lang.String", leaf_type=NetDataTypes.TYPE_STRING)]
		public var time :  String;

		/**
		 * @param time as <font color=#0000ff>java.lang.String</font>		 */
		public function GetTimeResponse(
			time :  String = null) 
		{
			this.time = time;
		}
	}
}