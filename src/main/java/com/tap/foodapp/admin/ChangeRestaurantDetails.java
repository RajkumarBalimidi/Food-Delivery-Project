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
 * Servlet implementation class ChangeRestaurantDetails
 */
//@WebServlet("/ChangeRestaurantDetails")
public class ChangeRestaurantDetails extends HttpServlet {
	

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String resname = req.getParameter("resname");
		String address = req.getParameter("address");
		Boolean isactive =Boolean.parseBoolean(req.getParameter("isactive"));
		String cuisinetype = req.getParameter("cuisinetype");
		String adminid = req.getParameter("adminid");
		String imagePath = req.getParameter("resimagepath");
		
		RestaurantDAO rdao = new RestaurantDAOImpl();
		Restaurant restaurant = new Restaurant(resname,address,isactive,cuisinetype,adminid,imagePath);
		int update = rdao.updateRestaurantDetails(restaurant);
		
			HttpSession session = req.getSession();
			Restaurant RestaurantId = rdao.getRestaurantByAdminId(adminid);
			session.setAttribute("RestaurantAdmin", RestaurantId);
			resp.sendRedirect("successUpdateRestaurant.jsp");
		
		
	}
	
}
