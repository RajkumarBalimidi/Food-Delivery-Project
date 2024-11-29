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
 * Servlet implementation class LoginPage
 */
//@WebServlet("/LoginPage")
@SuppressWarnings("serial")
public class LoginPage extends HttpServlet {
	
	private HttpSession session;
//	private int update;

//	@SuppressWarnings("unused")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		UserDAO udao = new UserDAOImpl();
		User user = udao.getUserByEmail(email);
		
		if(user!=null)
		{
			if(password.equals(user.getPassword()))
			{
				String userid = user.getEmail();
				session = req.getSession();
				session.setAttribute("user", user);
				session.setAttribute("userid", userid);
				resp.sendRedirect("home.jsp");
			}
			else
			{
				resp.sendRedirect("inCorrectPwd.html");
			}
		}
		else
		{
			resp.sendRedirect("noAccount.html");
		}
		
		
		
	}
	
}



