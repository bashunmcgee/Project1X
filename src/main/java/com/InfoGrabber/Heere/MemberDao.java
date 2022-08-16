package com.InfoGrabber.Heere;

import java.sql.Connection;
import java.sql.DriverManager;



public class MemberDao {

	private String uname = "Bashunmcgee";
	private String pword = "Dujuan2021!";
	private String jdbcUrl = "jdbc:mysql://localhost:3306/USA_AZ";
	private Connection conn;
	
	

	
	
	public void loadDriver() throws ClassNotFoundException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
	}
	
	
	public Connection getConnection() throws Exception{
		loadDriver();
		conn = DriverManager.getConnection(jdbcUrl, uname, pword);
		return conn;
	}

}
