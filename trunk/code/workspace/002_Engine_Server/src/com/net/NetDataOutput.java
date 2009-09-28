package com.net;

import java.io.DataOutput;
import java.io.IOException;

public interface NetDataOutput extends DataOutput
{
	public void writeBooleanArray(boolean[] bools) throws IOException;
	
	public void writeCharArray(char[] chars) throws IOException;
	
	public void writeByteArray(byte[] bytes) throws IOException;
	
	public void writeShortArray(short[] shorts) throws IOException;
	
	public void writeIntArray(int[] ints) throws IOException;
	
	public void writeLongArray(long[] longs) throws IOException;
	
	public void writeFloatArray(float[] floats) throws IOException;
	
	public void writeDoubleArray(double[] doubles) throws IOException;
}
