package com.tap.foodapp.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.foodapp.dao.MenuDAO;
import com.tap.foodapp.impl.MenuDAOImpl;

/**
 * Servlet implementation class DeleteMenuItemPerimissionGranted
 */
//@WebServlet("/DeleteMenuItemPerimissionGranted")
public class DeleteMenuItemPerimissionGranted extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		int menuId = (int) session.getAttribute("menuId");
		
		MenuDAO mdao = new MenuDAOImpl();
		int delete = mdao.deleteMenuById(menuId);
		
		if(delete != 0)
		{
			resp.sendRedirect("viewMenuAdmin.jsp");
		}
		else
		{
			resp.sendRedirect("notDeletedItem.jsp");
		}
		
		
	}
	
}
