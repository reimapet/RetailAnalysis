
package com.affecto.retail;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MoodDataCollection {

	public List moodData;
	
	public MoodDataCollection()
	{
		moodData = new ArrayList<MoodData>();
	}
	
	public void add( MoodData data )
	{
		moodData.add(data);
	}
	
	public String getJSON()
	{
		StringBuffer sb = new StringBuffer();
		
		sb.append("{");
		
		Iterator<MoodData> it = moodData.iterator();
		while( it.hasNext())
		{
			MoodData next = it.next();
			sb.append(next.toJSON());
			if( it.hasNext())
				sb.append(",");
			
		}
		
		sb.append("}");
		return sb.toString();
	}
	
	public String getJSONTransposed()
	{
		StringBuffer sb = new StringBuffer();
		
		sb.append("{");
//		sb.append("\"timestamp\" : ");
//		sb.append("[");
//		
		Iterator<MoodData> it = moodData.iterator();
//		while( it.hasNext())
//		{
//			MoodData next = it.next();
//			sb.append(next.timestamp);
//			if( it.hasNext())
//				sb.append(",");
//			
//		}
//		sb.append("],");

		sb.append("\"happyMale\" : ");
		sb.append("[");

		it = moodData.iterator();
		while( it.hasNext())
		{
			MoodData next = it.next();
			sb.append(next.happyMale);
			if( it.hasNext())
				sb.append(",");
			
		}
		sb.append("],");

		sb.append("\"nothappyMale\" : ");
		sb.append("[");

		it = moodData.iterator();
		while( it.hasNext())
		{
			MoodData next = it.next();
			sb.append(next.nothappyMale);
			if( it.hasNext())
				sb.append(",");
			
		}
		sb.append("],");

		sb.append("\"happyFemale\" : ");
		sb.append("[");

		it = moodData.iterator();
		while( it.hasNext())
		{
			MoodData next = it.next();
			sb.append(next.happyFemale);
			if( it.hasNext())
				sb.append(",");
			
		}
		sb.append("],");
		sb.append("\"nothappyFemale\" : ");
		sb.append("[");

		it = moodData.iterator();
		while( it.hasNext())
		{
			MoodData next = it.next();
			sb.append(next.nothappyFemale);
			if( it.hasNext())
				sb.append(",");
			
		}
		
		sb.append("]");

		
		sb.append("}");
		return sb.toString();
	}
	
	
	/**
	 * Empty the data
	 */
	public void reset()
	{
		moodData.clear();
	}
}
