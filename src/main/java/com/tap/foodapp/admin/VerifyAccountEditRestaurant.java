package com.tap.foodapp.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.foodapp.dao.RestaurantDAO;
import com.tap.foodapp.impl.RestaurantDAOImpl;
import com.tap.foodapp.model.Restaurant;

/**
 * Servlet implementation class VerifyAccountEditRestaurant
 */
//@WebServlet("/VerifyAccountEditRestaurant")
public class VerifyAccountEditRestaurant extends HttpServlet {
	

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		String adminId = req.getParameter("email");
		String password = req.getParameter("password");
		
		RestaurantDAO rdao = new RestaurantDAOImpl();
		Restaurant restaurant = rdao.getRestaurantByAdminId(adminId);
		
	//	 int RestaurantId =  (int) session.getAttribute("RestaurantId");
		
		if(restaurant != null)
		{
			if(password.equals(restaurant.getPassword()))
			{
				session.setAttribute("restaurant", restaurant);
//				session.setAttribute("RestaurantId", RestaurantId);
				resp.sendRedirect("editRestaurantDetails.jsp");
			}
			else
			{
				resp.sendRedirect("checkPassword.jsp");
			}
		}
		else
		{
			resp.sendRedirect("notEligibletoEditRestaurant.jsp");
		}
		
	}
	
}
