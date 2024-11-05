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
 * Servlet implementation class deleteRestaurantPerimission
 */
//@WebServlet("/deleteRestaurantPerimission")
public class deleteRestaurantPerimission extends HttpServlet {
	
		@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			int resid = Integer.parseInt(req.getParameter("Id"));
			
			RestaurantDAO rdao = new RestaurantDAOImpl();
			Restaurant restaurantId = rdao.getRestaurantById(resid);
			
			HttpSession session = req.getSession();
			session.setAttribute("restaurantId", restaurantId);
			resp.sendRedirect("deletePermission.jsp");
			
		
			
			
		}
	
}
