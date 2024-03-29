package com.fc.lami.Messages
{
	import com.net.client.Message;
	import com.net.client.MessageFactory;
	import com.net.client.NetDataTypes;


	/**
	 * Java Class [10] [com.fc.lami.Messages.EnterDeskResponse]<br>
	 * 此代码为自动生成。不需要在此修改。若有错误，请修改代码生成器。
	 */
	[Bindable]
	public class EnterDeskResponse extends Message
	{
		/** Java type is : <font color=#0000ff>int</font> */
		[JavaType(name="int", leaf_type=NetDataTypes.TYPE_INT)]
		static public const ENTER_DESK_RESULT_SUCCESS :  int = 0;
		/** Java type is : <font color=#0000ff>int</font> */
		[JavaType(name="int", leaf_type=NetDataTypes.TYPE_INT)]
		static public const ENTER_DESK_RESULT_FAIL_PLAYER_EXIST :  int = 1;
		/** Java type is : <font color=#0000ff>int</font> */
		[JavaType(name="int", leaf_type=NetDataTypes.TYPE_INT)]
		static public const ENTER_DESK_RESULT_FAIL_NOT_HAVE_ROOM :  int = 2;
		/** Java type is : <font color=#0000ff>int</font> */
		[JavaType(name="int", leaf_type=NetDataTypes.TYPE_INT)]
		static public const ENTER_DESK_RESULT_FAIL_NO_IDLE_SEAT :  int = 3;
		/** Java type is : <font color=#0000ff>int</font> */
		[JavaType(name="int", leaf_type=NetDataTypes.TYPE_INT)]
		static public const ENTER_DESK_RESULT_FAIL_NO_IDLE_DESK :  int = 4;
		/** Java type is : <font color=#0000ff>int</font> */
		[JavaType(name="int", leaf_type=NetDataTypes.TYPE_INT)]
		static public const ENTER_DESK_RESULT_FAIL_GAME_STARTED :  int = 5;
		/** Java type is : <font color=#0000ff>int</font> */
		[JavaType(name="int", leaf_type=NetDataTypes.TYPE_INT)]
		public var result :  int;
		/** Java type is : <font color=#0000ff>int</font> */
		[JavaType(name="int", leaf_type=NetDataTypes.TYPE_INT)]
		public var desk_id :  int;
		/** Java type is : <font color=#0000ff>int</font> */
		[JavaType(name="int", leaf_type=NetDataTypes.TYPE_INT)]
		public var seat :  int;
		/** Java type is : <font color=#0000ff>int</font> */
		[JavaType(name="int", leaf_type=NetDataTypes.TYPE_INT)]
		public var turn_interval :  int;
		/** Java type is : <font color=#0000ff>int</font> */
		[JavaType(name="int", leaf_type=NetDataTypes.TYPE_INT)]
		public var operate_time :  int;
		/** Java type is : <font color=#0000ff>com.fc.lami.Messages.PlayerState[]</font> */
		[JavaType(name="com.fc.lami.Messages.PlayerState[]", leaf_type=NetDataTypes.TYPE_EXTERNALIZABLE)]
		public var ps :  Array;

		/**
		 * @param result as <font color=#0000ff>int</font>
		 * @param desk_id as <font color=#0000ff>int</font>
		 * @param seat as <font color=#0000ff>int</font>
		 * @param turn_interval as <font color=#0000ff>int</font>
		 * @param operate_time as <font color=#0000ff>int</font>
		 * @param ps as <font color=#0000ff>com.fc.lami.Messages.PlayerState[]</font>		 */
		public function EnterDeskResponse(
			result :  int = 0,
			desk_id :  int = 0,
			seat :  int = 0,
			turn_interval :  int = 0,
			operate_time :  int = 0,
			ps :  Array = null) 
		{
			this.result = result;
			this.desk_id = desk_id;
			this.seat = seat;
			this.turn_interval = turn_interval;
			this.operate_time = operate_time;
			this.ps = ps;
		}
	}
}