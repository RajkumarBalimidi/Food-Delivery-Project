package com.tap.foodapp.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.protobuf.Service;

/**
 * Servlet implementation class editRestaurantDetailsLoginId
 */
//@WebServlet("/editRestaurantDetailsLoginId")
public class editRestaurantDetailsLoginId extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int resid = Integer.parseInt(req.getParameter("id"));
		HttpSession session = req.getSession();
		session.setAttribute("RestaurantId", resid);
		resp.sendRedirect("editRestaurantDetailsLogin.jsp");
		
	
	}
	
}
