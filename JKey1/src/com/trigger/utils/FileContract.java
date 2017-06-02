package com.trigger.utils;

public interface FileContract 
{
	public void initWriter(String fileName);
	public void writeString(String content);
	public void closeWriter();
	public void writeChar(int c);	
	public void writeEnter();
}
