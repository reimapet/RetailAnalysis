package com.affecto.retail;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataCollection<T> {

	private List<T> dataList;
	
	private Class dataClass;
	
	public DataCollection()
	{
		dataList = new ArrayList<T>();
	}
	
	public void add( T data )
	{
		dataList.add( data );
	}
	
	/**
	 * 
	 * @param columnNames
	 * @return
	 */
	public String getJSON( List<String> columnNames )
	{
		
		Iterator<String> names = columnNames.iterator();
		StringBuffer retString = new StringBuffer();
		
		retString.append("{");
		
		while( names.hasNext() )
		{
			String colName = names.next();
			String getter = "get" + colName;

			try {

				Method method = null;
				
				Iterator<T> it = dataList.iterator();
				retString.append("\"" + colName + "\":" );
				retString.append("[");

				while( it.hasNext())	
				{
					T data = it.next();
					method = data.getClass().getMethod(getter);
					Object retVal = method.invoke( data );
					retString.append( "\"" + retVal.toString() + "\"");
					if( it.hasNext() )
					{
						retString.append(",");
					}
				}
				retString.append("]");
				if( names.hasNext() )
				{
					retString.append(",");
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
		}
		retString.append("}");
		return retString.toString();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataCollection dc = new DataCollection<MoodData>();
		List list = new ArrayList();
		list.add("Timestamp");
		list.add("HappyMale");
		list.add("HappyFemale");

		MoodData d = new MoodData();
		d.setHappyFemale(1);
		d.setTimestamp(2);
		d.setHappyMale(2);
		dc.add( d );

		d = new MoodData();
		d.setHappyFemale(2);
		d.setTimestamp(3);
		d.setHappyMale(4);
		dc.add( d );

		System.out.println( dc.getJSON(list) ) ;
		
	}

}
