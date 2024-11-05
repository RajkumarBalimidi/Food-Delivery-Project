package com.tap.foodapp.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.foodapp.dao.RestaurantDAO;
import com.tap.foodapp.impl.RestaurantDAOImpl;
import com.tap.foodapp.model.Restaurant;

/**
 * Servlet implementation class GetParticularRestaurantIdByAdmin
 */
//@WebServlet("/GetParticularRestaurantIdByAdmin")
public class GetParticularRestaurantIdByAdmin extends HttpServlet {
	
		@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			HttpSession session = req.getSession();
			int RestaurantId = (int) session.getAttribute("restaurantId");
			
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			
			RestaurantDAO rdao = new RestaurantDAOImpl();
			Restaurant restaurant = rdao.getRestaurantByAdminId(email);
			
			if(restaurant != null)
			{
				if((email.equals(restaurant.getAdminid()) && (password.equals(restaurant.getPassword()))))
				{
					session.setAttribute("restaurantId", RestaurantId);
					session.setAttribute("AdminId", restaurant);
					resp.sendRedirect("viewMenuAdmin.jsp");
				}
				else
				{
					resp.sendRedirect("wrongViewMenuPwd.jsp");
				}
			}
			else
			{
				resp.sendRedirect("createAdminAccount.jsp");
			}
		

		
		}
	
}
