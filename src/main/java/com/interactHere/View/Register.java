package com.interactHere.View;

import java.io.IOException;  
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String userName = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String repwd = request.getParameter("re_pass");
		String mobile = request.getParameter("contact");
		
		
		
		Connection conn = null;
		RequestDispatcher dispatcher = null;
		
		
		if(firstName == null || firstName.trim().isBlank()) {
			request.setAttribute("status", "invalidFirstname");
			dispatcher = request.getRequestDispatcher("registration.jsp");
			dispatcher.forward(request, response);
			
		}	
		if(lastName == null || lastName.trim().isBlank()) {
			request.setAttribute("status", "invalidLastname");
			dispatcher = request.getRequestDispatcher("registration.jsp");
			dispatcher.forward(request, response);
			
		}
		
		if(userName == null || userName.trim().isBlank()) {
			request.setAttribute("status", "invalidUsername");
			dispatcher = request.getRequestDispatcher("registration.jsp");
			dispatcher.forward(request, response);
			
		}
		if(email == null || email.trim().isBlank() || (!(valEmail(email))))  {
			request.setAttribute("status", "invalidEmail");
			dispatcher = request.getRequestDispatcher("registration.jsp");
			dispatcher.forward(request, response);
		} 
		
		
		if(password == null || password.trim().isBlank() ) {
			request.setAttribute("status", "invalidPassword");
			dispatcher = request.getRequestDispatcher("registration.jsp");
			dispatcher.forward(request, response);
		}else if(!password.equals(repwd)) {
			request.setAttribute("status", "invalidConfirmPassword");
			dispatcher = request.getRequestDispatcher("registration.jsp");
			dispatcher.forward(request, response);
			
		}
		if((mobile == null || mobile.trim().isBlank()) || (!(valMobile(mobile))))  {
			request.setAttribute("status", "invalidMobile");
			dispatcher = request.getRequestDispatcher("registration.jsp");
			dispatcher.forward(request, response);
		}
		
		

		
		
		try {
			
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/USA_AZ?useSSL=false","Bashunmcgee", "Dujuan2021!");
			PreparedStatement pst = conn.prepareStatement("insert into Account(firstname, lastname, username, email, password, mobile) values(?, ?, ?, ?, ? , ?)");
			pst.setString(1, firstName);
			pst.setString(2, lastName);
			pst.setString(3, userName);
			pst.setString(4, email);
			pst.setString(5, password);
			pst.setString(6, mobile);
			
			int rowCount = pst.executeUpdate();
			dispatcher = request.getRequestDispatcher("registration.jsp");
			
			if(rowCount > 0) {
				
				request.setAttribute("status", "success");
				
			}
			else {
				request.setAttribute("status", "failed");
			}
			
			dispatcher.forward(request, response);
		
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Validation for Mobile
	 * @param item
	 * @return
	 */
	public static Boolean valMobile(String item) {
		
		String regex = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$" 
			      + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$" 
			      + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$";
		Pattern pat = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher match = pat.matcher(item);
		
		return match.find();
	}
	
	
	/**
	 * Validation for Email
	 * @param item
	 * @return
	 */
	public static Boolean valEmail(String item) {
		
		String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
		Pattern pat = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher matched =pat.matcher(item);
		
		return matched.find();
	}
	
}
