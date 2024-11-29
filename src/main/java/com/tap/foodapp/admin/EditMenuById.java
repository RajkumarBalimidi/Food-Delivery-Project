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
 * Servlet implementation class EditMenuById
 */
//@WebServlet("/EditMenuById")
public class EditMenuById extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		Float price = Float.parseFloat(req.getParameter("price"));
		String description = req.getParameter("description");
		Boolean isavailable = Boolean.parseBoolean(req.getParameter("isavailable"));
		
		HttpSession session = req.getSession();
		int menuId = (int) session.getAttribute("menuId");
		
		MenuDAO mdao = new MenuDAOImpl();
		int update = mdao.updateMenuById(name, price, description, isavailable, menuId);
		
		if(update != 0)
		{
			resp.sendRedirect("viewMenuAdmin.jsp");
		}
		else
		{
			resp.sendRedirect("notUpdatedMenu.jsp");
		}
	}

}
