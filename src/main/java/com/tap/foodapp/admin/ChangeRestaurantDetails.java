package com.tap.foodapp.admin;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.servlet.annotation.MultipartConfig;

import com.tap.foodapp.dao.RestaurantDAO;
import com.tap.foodapp.impl.RestaurantDAOImpl;
import com.tap.foodapp.model.Restaurant;
/**
 * Servlet implementation class ChangeRestaurantDetails
 */


@SuppressWarnings("serial")
@MultipartConfig(
	    fileSizeThreshold = 1024 * 1024 * 1,  // 1 MB
	    maxFileSize = 1024 * 1024 * 10,       // 10 MB
	    maxRequestSize = 1024 * 1024 * 15     // 15 MB
	)

//@WebServlet("/ChangeRestaurantDetails")
public class ChangeRestaurantDetails extends HttpServlet {
	


	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		InputStream imagePath = null;
		String resname = req.getParameter("resname");
		String address = req.getParameter("address");
		Boolean isactive =Boolean.parseBoolean(req.getParameter("isactive"));
		String cuisinetype = req.getParameter("cuisinetype");
		String adminid = req.getParameter("adminid");

		RestaurantDAO rdao = new RestaurantDAOImpl();
		Restaurant restaurant = new Restaurant(resname,address,isactive,cuisinetype,adminid);
		int update = rdao.updateRestaurantDetails(restaurant);
		if(update == 1)
		{
			HttpSession session = req.getSession();
			Restaurant RestaurantId = rdao.getRestaurantByAdminId(adminid);
			session.setAttribute("RestaurantAdmin", RestaurantId);
			resp.sendRedirect("successUpdateRestaurant.jsp");
		}
	}
	
}
