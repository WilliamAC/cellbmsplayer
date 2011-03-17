package com.net.client
{
	public class Protocol
	{
		/** Session/Server 之间的消息 */
		public static const PROTOCOL_SESSION_MESSAGE	 	: int	= 0x30;
		/** Session/Channel 之间的消息 */
		public static const PROTOCOL_CHANNEL_MESSAGE 		: int	= 0x52;
		/** 当前Session加入频道的事件 */
		public static const PROTOCOL_CHANNEL_JOIN_S2C		: int	= 0x50;
		/** 当前Session离开频道的事件 */
		public static const PROTOCOL_CHANNEL_LEAVE_S2C 	: int	= 0x51;
		
		
		internal var		protocol 			: int ;
		
		internal var  		session_id 			: Number;
		
		internal var		packet_number 		: int;
		
		internal var 		channel_id 			: int;
		
		internal var 		channel_session_id 	: Number;
		
		internal var 		sent_time 			: Number;
		
		internal var 		received_time 		: Number;
		
		internal var 		message 			: Message;
		
		
		
		/**消息类型*/
		public function		getProtocol() : int {
			return this.protocol;
		}
		
		/**该链接对于服务器的唯一ID*/
		public function  		getSessionID() : Number {
			return this.session_id;
		}
		
		/**匹配Request和Response的值，如果为0，则代表为Notify*/
		public function		getPacketNumber() : int {
			return this.packet_number;
		}
		
		/**频道ID<br>
		 * 仅PROTOCOL_CHANNEL_*类型的消息有效*/
		public function 		getChannelID() : int {
			return this.channel_id;
		}
		
		/**频道发送者的SessionID<br>
		 * 仅PROTOCOL_CHANNEL_*类型的消息有效*/
		public function 		getChannelSesseionID() : Number{
			return this.channel_session_id;
		}
		
		
		/**发送时间*/
		public function 		getSentTime(): Number {
			return this.sent_time;
		}
		
		/**接收时间*/
		public function 		getReceivedTime():Number {
			return this.received_time;
		}
		
		/**包含的消息*/
		public function 		getMessage() : Message {
			return this.message;
		}
		
	}
	
	
	
}