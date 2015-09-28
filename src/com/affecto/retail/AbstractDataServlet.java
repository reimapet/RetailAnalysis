package com.affecto.retail;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class AbstractDataServlet
 */

public class AbstractDataServlet<T> extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// Name of the context parameter where data is kept
	private String contextParameter;
	
	private List<String> columnList = null;
	Class dataClass = null;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AbstractDataServlet(String contextParameterName , Class dataClass  ) {
        super();
        this.contextParameter = contextParameterName;
        this.dataClass = dataClass;
        
        // TODO Auto-generated constructor stub
    }

    public void setColumnList( List columnList )
    {
    	this.columnList = columnList;
    }
    
    public List<String> getColumnList()
    {
    	return columnList;
    }
    
    public DataCollection<T> getDataCollection(HttpServletRequest request )
    {
    	DataCollection<T> data = (DataCollection<T>)request.getServletContext().getAttribute(contextParameter);
    	if( data == null )
    	{
    		data = new DataCollection<T>();
    		setDataCollection( request, data );
    	}
    	return data;
    }
    
    public void setDataCollection( HttpServletRequest request, DataCollection<T> collection)
    {
    	request.getServletContext().setAttribute(contextParameter, collection);
    }
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");

		
		DataCollection<T> data = this.getDataCollection(request);
		
		if( data != null )
		{
			response.getWriter().append(data.getJSON(getColumnList()));
		} else {
			System.err.println("DATA not set for" + contextParameter );
			response.getWriter().append("null");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Gson gson = new Gson();
		BufferedReader reader = request.getReader();
		
		T data = gson.fromJson( reader, dataClass );
		//MoodDataCollection col = (MoodDataCollection)request.getServletContext().getAttribute(DATA_ENTITY_NAME);
		DataCollection<T> col = getDataCollection(request);
		col.add(data);
	}

}
