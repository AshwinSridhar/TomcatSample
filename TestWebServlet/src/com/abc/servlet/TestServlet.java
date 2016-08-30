package com.abc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.persistence.jpa.PersistenceProvider;

/**
 * Servlet implementation class TestServlet
 */
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("The request came here...");
		
		Map<String, String> propMap = new HashMap<String, String>();
		String userid="QAREGRESSION";
        String password="letmein";
		propMap.put("javax.persistence.jdbc.driver","oracle.jdbc.OracleDriver");
		propMap.put("javax.persistence.jdbc.user", userid);
		propMap.put("javax.persistence.jdbc.password", password);
		propMap.put("javax.persistence.jdbc.url", "jdbc:oracle:thin:@ashptilodb-u01.advisory.com:1526:piccore");
		propMap.put("javax.persistence.logging.level", "DEBUG");
		propMap.put("javax.persistence.ddl-generation.output-mode", "sql-script");
		propMap.put("javax.persistence.logging.file","Persistence.log");
		propMap.put("eclipselink.logging.file", "Persistence.log");
		propMap.put("javax.persistence.logging.level.sql","ALL");
		//Start-Added By Persistent System Limited in release 9.12 for US11633(Develop infrastructure for JPA reconnection)
		//End-Added By Persistent System Limited in release 9.12 for US11633(Develop infrastructure for JPA reconnection)
		
		System.out.println("Created the map...");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence" , propMap);
		System.out.println("The value is "+emf);
		EntityManager em = emf.createEntityManager();
		
		System.out.println("The persistence manager s created.... "+em);
		
		response.setContentType("text/html");
        PrintWriter printWriter  = response.getWriter();
        printWriter.println("<h1>Hello World!</h1>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
