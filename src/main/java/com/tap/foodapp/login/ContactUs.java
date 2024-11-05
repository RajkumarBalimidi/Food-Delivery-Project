package com.tap.foodapp.login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContactUs
 */
//@WebServlet("/ContactUs")
public class ContactUs extends HttpServlet {
	
	private Connection con;
	private PreparedStatement pstmt;
	private static String INSERT_EMPLOYEE = "insert into `contactus`(`name`,`email`,`queries`) values(?,?,?)";
	
	@Override
	public void init() throws ServletException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jeepractice","root","MySQL");
			pstmt = con.prepareStatement(INSERT_EMPLOYEE);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
