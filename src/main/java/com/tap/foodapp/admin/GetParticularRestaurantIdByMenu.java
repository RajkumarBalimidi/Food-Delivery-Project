package com.tap.foodapp.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GetParticularRestaurantIdByMenu
 */
//@WebServlet("/GetParticularRestaurantIdByMenu")
public class GetParticularRestaurantIdByMenu extends HttpServlet {
	
		@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			HttpSession session = req.getSession();
			int resId = Integer.parseInt(req.getParameter("Id"));
			session.setAttribute("restaurantId", resId);
			resp.sendRedirect("verifyAdminViewMenu.jsp");
			
		}
	
}
