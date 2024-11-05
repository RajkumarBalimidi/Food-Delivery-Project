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
 * Servlet implementation class ForgotPassword
 */
//@WebServlet("/ForgotPassword")
public class ForgotPassword extends HttpServlet {
	
	private int update;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("email");
		String password = req.getParameter("newpassword");
		String cpassword = req.getParameter("confirmpassword");
		
		UserDAO udao = new UserDAOImpl();
		User user = udao.getUserByEmail(email);
		
		
		if(user != null)
		{
			if(password.equals(cpassword))
			{
				update = udao.updateUserPasswordByEmail(email, password);
				resp.sendRedirect("success.html");
			}
			else
			{
				resp.sendRedirect("pwdNotMatch.html");
			}
		}
		else
		{
			resp.sendRedirect("register.html");
		}
		
	}
	
}
