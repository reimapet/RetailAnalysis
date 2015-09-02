package com.affecto.retail;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MoodStatsFile {
	private String fileName;
	
	private StringBuffer fileContent;
	
	
	
	// timestamp of last file load
	private long lastLoad;
	public static long FILE_LOAD_INTERVAL = 2000;
	
	public StringBuffer getFileContent() throws IOException
	{
		if( fileContent == null)
		{
			load();
		}
		
		if( System.currentTimeMillis()+FILE_LOAD_INTERVAL > lastLoad )
		{
			load();
		}
		return fileContent;
		
	}
	
	public MoodStatsFile( String fileName ) throws IOException
	{
		this.fileName = fileName;
	}
	
	public void load() throws IOException
	{
		File file;
		file = new File( fileName );
		lastLoad = System.currentTimeMillis();
		FileReader rd = new FileReader( file );
		BufferedReader brd = new BufferedReader( rd );
		String line = null;
		fileContent = new StringBuffer();
		line = brd.readLine();
		
		while( line != null )
		{
			fileContent.append(line);
			line = brd.readLine();
		}
		
		rd.close();
	}
}
