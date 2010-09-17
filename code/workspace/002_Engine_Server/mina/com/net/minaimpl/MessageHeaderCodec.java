package com.net.minaimpl;

import java.io.Serializable;

import org.apache.mina.filter.codec.ProtocolCodecFactory;

import com.net.ExternalizableFactory;
import com.net.ExternalizableMessage;

public abstract class MessageHeaderCodec implements ProtocolCodecFactory
{
	/** 标识为 {@link Serializable} 方式序列化 */
	final public static byte	TRANSMISSION_TYPE_SERIALIZABLE		= 0;
	/** 标识为 {@link ExternalizableMessage} 方式序列化，即以纯手工序列化/反序列化 */
	final public static byte	TRANSMISSION_TYPE_EXTERNALIZABLE	= 1;
	
//	-----------------------------------------------------------------------------------------
	
	// 消息头
	final protected static byte		protocol_start[] 		= new byte[] { 2, 0, 0, 6, };
	// 消息头固定尺寸
	final protected static int		protocol_fixed_size 	= 4 + 4;
	// 消息传送固定尺寸
	final protected static int		header_fixed_size 		= 4 + 8 + 8 + 2 + 4 + 1;

	final protected static byte[]	zerodata				= new byte[0];

	final public static void setProtocolStart(byte b1, byte b2, byte b3, byte b4) 
	{
		protocol_start[0] = b1;
		protocol_start[1] = b2;
		protocol_start[2] = b3;
		protocol_start[3] = b4;
	}

//	-----------------------------------------------------------------------------------------

	final protected ClassLoader				class_loader;
    final protected ExternalizableFactory	ext_factory;
    
//	trace var
    protected long 							TotalSentBytes 			= 0;
    protected long 							TotalReceivedBytes 		= 0;
    
    protected long 							SendedMessageCount 		= 0;
    protected long							ReceivedMessageCount 	= 0;

//	-----------------------------------------------------------------------------------------

    public MessageHeaderCodec(ClassLoader cl, ExternalizableFactory ext_factory) 
    {
    	this.class_loader	= cl;
    	this.ext_factory	= ext_factory;
    }

	public long getTotalSentBytes() {
		return TotalSentBytes;
	}

	public long getTotalReceivedBytes() {
		return TotalReceivedBytes;
	}

	public long getSendedMessageCount() {
		return SendedMessageCount;
	}

	public long getReceivedMessageCount() {
		return ReceivedMessageCount;
	}
}