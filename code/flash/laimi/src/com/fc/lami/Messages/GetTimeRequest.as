package com.fc.lami.Messages
{
	import com.net.client.Message;
	import com.net.client.MessageFactory;


	/**
	 * Java Class [7] [com.fc.lami.Messages.GetTimeRequest]<br>
	 * 此代码为自动生成。不需要在此修改。若有错误，请修改代码生成器。
	 */
	public class GetTimeRequest extends Message
	{
		/** Java type is : <font color=#0000ff>java.lang.String</font> */
		public var message :  String;

		/**
		 * @param message as <font color=#0000ff>java.lang.String</font>		 */
		public function GetTimeRequest(
			message :  String = null) 
		{
			this.message = message;
		}
	}
}