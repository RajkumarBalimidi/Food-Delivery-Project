package com.tap.foodapp.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.foodapp.dao.UserDAO;
import com.tap.foodapp.impl.UserDAOImpl;
import com.tap.foodapp.model.User;

/**
 * Servlet implementation class Register
 */
//@WebServlet("/Register")
public class Register extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("fullname");
		String email = req.getParameter("email");
		String phonenumber = req.getParameter("mobilenumber");
		String address = req.getParameter("address");
		String role = req.getParameter("role");
		
		UserDAO udao = new UserDAOImpl();
		User user = new User(name,email,phonenumber,address,role);
		int status = udao.insertUser(user);
		if(status == 0)
		{
			resp.sendRedirect("filldetails.jsp");
		}
		else
		{
			resp.sendRedirect("forgot.html");
		}

	
	}
	
}
