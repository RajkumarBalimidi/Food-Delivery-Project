package com.tap.foodapp.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.foodapp.dao.MenuDAO;
import com.tap.foodapp.impl.MenuDAOImpl;
import com.tap.foodapp.model.Menu;

/**
 * Servlet implementation class AddMenuItem
 */
//@WebServlet("/AddMenuItem")
public class AddMenuItem extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("name");
		Float price = Float.parseFloat(req.getParameter("price"));
		String description = req.getParameter("description");
		Boolean isavailable = Boolean.parseBoolean(req.getParameter("isavailable"));
		
		HttpSession session = req.getSession();
		int restaurantId = (int) session.getAttribute("restaurantId");
		
		MenuDAO mdao = new MenuDAOImpl();
		Menu menu = new Menu(name, restaurantId, price, description, isavailable);
		int insert = mdao.insertMenu(menu);
		if(insert == 1)
		{
			resp.sendRedirect("viewMenuAdmin.jsp");
		}
		else
		{
			resp.sendRedirect("notInsertedMenuItem.jsp");
		}
	}
	
}
