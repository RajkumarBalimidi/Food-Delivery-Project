package com.tap.foodapp.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.foodapp.dao.RestaurantDAO;
import com.tap.foodapp.dao.UserDAO;
import com.tap.foodapp.impl.RestaurantDAOImpl;
import com.tap.foodapp.impl.UserDAOImpl;
import com.tap.foodapp.model.Restaurant;
import com.tap.foodapp.model.User;

/**
 * Servlet implementation class GetParticularRestaurantIdUser
 */
//@WebServlet("/GetParticularRestaurantIdUser")
public class GetParticularRestaurantIdUser extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		int RestaurantId = Integer.parseInt(req.getParameter("Id"));

		RestaurantDAO rdao = new RestaurantDAOImpl();
		Restaurant resid = rdao.getRestaurantById(RestaurantId);
		String RestaurantName = resid.getResname();
		
		User u = (User) session.getAttribute("user");
		
//		UserDAO udao = new UserDAOImpl();
//		String user = udao.getUserByEmail(u);
//		String useremail = user.getUserid();
		
		if(u != null)
		{
		session.setAttribute("RestaurantId", RestaurantId);
		session.setAttribute("RestaurantName", RestaurantName);
		session.setAttribute("userid", session.getAttribute("userid"));
		session.setAttribute("user", u);
		
		resp.sendRedirect("viewMenuUser.jsp");		
		}
	}
	
}
