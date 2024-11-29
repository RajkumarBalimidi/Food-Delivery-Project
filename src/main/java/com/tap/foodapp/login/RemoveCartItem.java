package com.tap.foodapp.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.foodapp.dao.CartDAO;
import com.tap.foodapp.impl.CartDAOImpl;

/**
 * Servlet implementation class RemoveCartItem
 */
//@WebServlet("/RemoveCartItem")
public class RemoveCartItem extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int cartId = Integer.parseInt(req.getParameter("cid"));
		
		CartDAO cdao = new CartDAOImpl();
		
		int cid = cdao.RemoveCartItemByCartId(cartId);
		
		if(cid == 1)
		{
			resp.sendRedirect("homeUser.jsp");
		}
		else
		{
			resp.sendRedirect("failure.jsp");			
		}
		
	}
	
}
