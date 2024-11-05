package com.tap.foodapp.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.foodapp.model.Restaurant;

/**
 * Servlet implementation class DeleteRestaurantPerimissionGranted
 */
//@WebServlet("/DeleteRestaurantPerimissionGranted")
public class DeleteRestaurantPerimissionGranted extends HttpServlet {
	
	private HttpSession session;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		 session = req.getSession();
		Restaurant restaurantId = (Restaurant) session.getAttribute("restaurantId");
		session.setAttribute("restaurantId", restaurantId);
		resp.sendRedirect("verifyAccounttoDelete.jsp");
	
	}
	
}
