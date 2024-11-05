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
 * Servlet implementation class VerifyAccountDeleteRestaurant
 */
//@WebServlet("/VerifyAccountDeleteRestaurant")
public class VerifyAccountDeleteRestaurant extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String adminId = req.getParameter("email");
		String password = req.getParameter("password");
		
		RestaurantDAO rdao = new RestaurantDAOImpl();
		Restaurant restaurant = rdao.getRestaurantByAdminId(adminId);
		if(restaurant != null)
		{
			if((adminId.equals(restaurant.getAdminid())) && (password.equals(restaurant.getPassword())))
			{
				int delete = rdao.deleteRestaurantByAdminId(adminId);
				resp.sendRedirect("adminRestaurant.jsp");
			}
			else
			{
				resp.sendRedirect("wrongAdminPasswordtoDelete.jsp");
			}
		}
		else
		{
			resp.sendRedirect("noAccount.jsp");
		}
		
	}
	
}
