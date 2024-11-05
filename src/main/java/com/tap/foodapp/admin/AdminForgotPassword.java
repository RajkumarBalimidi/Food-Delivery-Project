package com.tap.foodapp.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.foodapp.impl.RestaurantDAOImpl;
import com.tap.foodapp.dao.RestaurantDAO;
import com.tap.foodapp.model.Restaurant;

/**
 * Servlet implementation class AdminForgotPassword
 */
//@WebServlet("/AdminForgotPassword")
public class AdminForgotPassword extends HttpServlet {

		private int update;

		@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String email = req.getParameter("email");
			String Password = req.getParameter("newpassword");
			String CPassword = req.getParameter("confirmpassword");
			
			RestaurantDAO rdao = new RestaurantDAOImpl();
			Restaurant restaurant1 = rdao.getRestaurantByAdminId(email);
			if(restaurant1 != null)
			{
				if(Password.equals(CPassword))
				{
					update = rdao.updateRestaurantAdminPassword(email,Password);
					resp.sendRedirect("successAdminPwd.html");
				}
				else
				{
					resp.sendRedirect("adminCpwdNotMatch.jsp");
				}
			}
			else
			{
				resp.sendRedirect("createAdminAccount.jsp");
			}
		}
	
}
