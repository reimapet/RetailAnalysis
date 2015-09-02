package com.affecto.retail;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.*;

/**
 * Servlet implementation class MoodDataServlet
 */
@WebServlet("/MoodDataServlet")
public class MoodDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	private static String[] moodNames = {"Happy", "Neutral", "Not happy"};
	private static String MOOD_FILE_NAME = "moodStatsFile";
	private String moodFilename = null;
	private MoodStatsFile file = null;
	
	/**
     * @throws IOException 
	 * @see HttpServlet#HttpServlet()
     */
    public MoodDataServlet() throws IOException {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
    	// TODO Auto-generated method stub
    	super.init(config);
        moodFilename = this.getInitParameter(MOOD_FILE_NAME);
        if( moodFilename == null )
        {
        	moodFilename = "C:/tmp/datafile.txt";
        }
        try {
			file = new MoodStatsFile(moodFilename);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//JSONArray names = new JSONArray(moodNames);
		
		JSONArray data  =  null;// CDL.toJSONArray(names, file.getFileContent().toString() );
		
		data = fileToJSON(file.getFileContent());
		
		response.getWriter().append(data.toString());

		//response.getWriter().append(file.getFileContent().toString());

	}
	
	private static JSONArray fileToJSON (StringBuffer list)
	{
		JSONArray array = new JSONArray(list.toString());
		
		return array;

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
