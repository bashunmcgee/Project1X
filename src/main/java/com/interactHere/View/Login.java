package com.interactHere.View;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = null;
		
		if(username == null || username.trim().isBlank()) {
			request.setAttribute("status", "invalid Username");
			dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
			
		}
		
		if(password == null || password.trim().isBlank()) {
			request.setAttribute("status", "invalid Password");
			dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/USA_AZ?useSSL=false", "Bashunmcgee","Dujuan2021!");
			PreparedStatement pst = conn.prepareStatement("SELECT * FROM Account where username = ? and password = ?");
			pst.setString(1, username);
			pst.setString(2, password);
		
		
		ResultSet rs = pst.executeQuery();
		if(rs.next()) {
			session.setAttribute("name", rs.getString("username"));
			dispatcher = request.getRequestDispatcher("index.jsp");
		}
		else {
			//Maybe Request instead of session
			request.setAttribute("status", "failed");
			dispatcher = request.getRequestDispatcher("login.jsp");
		}
		
		dispatcher.forward(request, response);
		
		}
		
		catch (Exception e) {
		
			e.printStackTrace();
		}
	}

}
