package com.tap.foodapp.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.foodapp.dao.RestaurantDAO;
import com.tap.foodapp.impl.RestaurantDAOImpl;
import com.tap.foodapp.model.Restaurant;

/**
 * Servlet implementation class CreateAdminAccount
 */
//@WebServlet("/CreateAdminAccount")
public class CreateAdminAccount extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String RestaurantName = req.getParameter("restaurantname");
		String AdminEmail = req.getParameter("email");
		boolean isactive = Boolean.parseBoolean(req.getParameter("isactive"));
		String address = req.getParameter("address");
		String cuisinetype = req.getParameter("cuisinetype");
		
		RestaurantDAO rdao = new RestaurantDAOImpl();
		Restaurant restaurant = new Restaurant(RestaurantName,address,isactive,cuisinetype,AdminEmail);
		int status = rdao.insertRestaurant(restaurant);
		if(status == 0)
		{
			resp.sendRedirect("filldetails.jsp");
		}
		else
		{
			resp.sendRedirect("adminForgotPwd.jsp");			
		}
	}
	
}
