package com.sample.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDbConnection
 */
@WebServlet("/TestDbConnection")
public class TestDbConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestDbConnection() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// set up conneciton variable
		
		String user = "springstudent";
		String pass = "springstudent";
		String jdbcUrl= "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
		String driver ="com.mysql.jdbc.Driver";
		
		// get connection to database
		try{
			PrintWriter out = response.getWriter();
			out.println("Connecting to database");
			
			Class.forName(driver);
			Connection myConn = DriverManager.getConnection(jdbcUrl,user,pass);
			out.println("Success!!!!!!");
			myConn.close();
			
		}catch(Exception e){
			e.printStackTrace();
			throw new ServletException(e);
			
		}
		
		
		
	}

	

}
