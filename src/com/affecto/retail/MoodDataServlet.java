package com.affecto.retail;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.*;
import com.google.gson.Gson;

/**
 * Servlet implementation class MoodDataServlet
 */
@WebServlet("/MoodDataServlet")
public class MoodDataServlet extends AbstractDataServlet<MoodData> {
	private static final long serialVersionUID = 1L;
      
	private static String DATA_ENTITY_NAME = "mooddata-entity";

	/**
     * @throws IOException 
	 * @see HttpServlet#HttpServlet()
     */
    public MoodDataServlet() throws IOException {
        super(DATA_ENTITY_NAME, MoodData.class);
        List<String> columnList = null;
        columnList = new ArrayList<String>();
        //columnList.add("Timestamp");
		
        columnList.add("HappyMale");
        columnList.add("NothappyMale");
        columnList.add("HappyFemale");
        columnList.add("NothappyFemale");
        setColumnList(columnList);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
    	// TODO Auto-generated method stub
    	super.init(config);
      
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
	}
	


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		
	}
	

}
