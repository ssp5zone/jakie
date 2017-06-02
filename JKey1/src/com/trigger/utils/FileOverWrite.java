package com.trigger.utils;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;

public class FileOverWrite implements FileContract 
{
	Writer writer = null;
	String fileName = null;
	
	public void initWriter(String fileName)
	{
		this.fileName = fileName;	
		try 
		{
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "utf-8"));
			writer.write("Logger Started: ");
			writer.write(System.getProperty("line.separator"));
		} 
		catch (IOException e) {}
	}
	
	public void writeString(String content)
	{
		try 
		{
			writer.write(content);
		} 
		catch (IOException e) {}
	}

	public void closeWriter()
	{
		try {
			if(writer!=null)
			writer.close();
			writer=null;
		} catch (IOException e) {
		}
	}
	
	public void writeChar(int c){
		try {
			writer.write(c);
		} catch (IOException e) {}
	}
	
	public void writeEnter()
	{
		if(writer!=null)
			try {
				writer.write('\u21B2');
				writer.write(System.getProperty("line.separator"));
			} catch (IOException e) {}
	}

}
