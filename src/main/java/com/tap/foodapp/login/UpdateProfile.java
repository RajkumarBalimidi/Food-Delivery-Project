package com.tap.foodapp.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.foodapp.dao.UserDAO;
import com.tap.foodapp.impl.UserDAOImpl;
import com.tap.foodapp.model.User;

/**
 * Servlet implementation class updateProfile
 */
//@WebServlet("/UpdateProfile")
public class UpdateProfile extends HttpServlet {
	
	private int update;
	private User user;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//For Login Page
	
		String email = req.getParameter("email");
		String address = req.getParameter("address");
		String role = req.getParameter("role");
		
		HttpSession session = req.getSession();
		session.setAttribute("email", email);
		session.setAttribute("address", address);
		session.setAttribute("role", role);
		
		UserDAO udao = new UserDAOImpl();
		update = udao.updateUserDetails(address, role, email);
		
		user = udao.getUserByEmail(email);
		session.setAttribute("user", user);
		resp.sendRedirect("profileUpdated.jsp");
		
	
	}
	
}
