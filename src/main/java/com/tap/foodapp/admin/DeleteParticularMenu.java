package com.tap.foodapp.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DeleteParticularMenu
 */
//@WebServlet("/DeleteParticularMenu")
public class DeleteParticularMenu extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int menuId = Integer.parseInt(req.getParameter("Mid"));
		HttpSession session = req.getSession();
		session.setAttribute("menuId", menuId);
		resp.sendRedirect("deleteMenuItemPermisssion.jsp");
		
	}
	
}
