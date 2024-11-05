package com.tap.foodapp.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.foodapp.model.User;


//@WebServlet("/GetParticularRestaurantId")
public class GetParticularRestaurantIdLogin extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		int RestaurantId = Integer.parseInt(req.getParameter("Id"));
		req.getSession().setAttribute("RestaurantId", RestaurantId);
	//	String RestaurantName = req.getParameter("RestaurantName");
	//	String RestaurantName = (String) session.getAttribute("RestaurantName");
	//	req.getSession().setAttribute("RestaurantName", RestaurantName);
//		User user1 = (User) session.getAttribute("user");
		
	
			resp.sendRedirect("viewMenuLogin.jsp");			
	
		
		
	}
	
}
