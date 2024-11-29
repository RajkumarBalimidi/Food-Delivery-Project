package com.tap.foodapp.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.foodapp.dao.CartDAO;
import com.tap.foodapp.impl.CartDAOImpl;
import com.tap.foodapp.model.Cart;
import com.tap.foodapp.model.User;

/**
 * Servlet implementation class PutToCartByMenuId
 */

//@WebServlet("/PutToCartByMenuId")
public class PutToCartByMenuId extends HttpServlet {
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		String userName = (String) session.getAttribute("userid");
		int mId = Integer.parseInt(req.getParameter("menuId"));
		String mName = req.getParameter("itemName");
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		float price = Float.parseFloat(req.getParameter("price"));
			
		Cart cart = new Cart(userName,mId,mName,quantity,price);
		
		CartDAO cdao = new CartDAOImpl();
		int addItem = cdao.insertCart(cart);
		
		
		if(addItem == 1)
		{
			resp.sendRedirect("viewMenuUser.jsp");
		}
		
	}

}
