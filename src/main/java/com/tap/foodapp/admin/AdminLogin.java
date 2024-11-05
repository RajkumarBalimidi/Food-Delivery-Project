package com.tap.foodapp.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.foodapp.dao.RestaurantDAO;
import com.tap.foodapp.impl.RestaurantDAOImpl;
import com.tap.foodapp.model.Restaurant;

/**
 * Servlet implementation class AdminLogin
 */
//@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	
	private HttpSession session;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String Adminemail = req.getParameter("email");
		String password = req.getParameter("password");
		
		RestaurantDAO rdao = new RestaurantDAOImpl();
		Restaurant RestaurantAdmin = rdao.getRestaurantByAdminId(Adminemail);
		
		if(RestaurantAdmin != null)
		{
			if(password.equals(RestaurantAdmin.getPassword()))
			{
				session = req.getSession();
				session.setAttribute("RestaurantAdmin", RestaurantAdmin);
				resp.sendRedirect("adminRestaurantHome.jsp");
			}	
			else
			{
				resp.sendRedirect("wrongAdminPassword.jsp");
			}
		}
		else
		{
			resp.sendRedirect("createAdminAccount.jsp");
		}
		
	}
	
}
