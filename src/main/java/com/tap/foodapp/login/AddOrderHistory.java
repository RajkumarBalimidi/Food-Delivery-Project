package com.tap.foodapp.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.foodapp.dao.OrderDAO;
import com.tap.foodapp.dao.OrderHistoryDAO;
import com.tap.foodapp.dao.OrderItemsDAO;
import com.tap.foodapp.impl.OrderDAOImpl;
import com.tap.foodapp.impl.OrderHistoryDAOImpl;
import com.tap.foodapp.impl.OrderItemsDAOImpl;
import com.tap.foodapp.model.Order;
import com.tap.foodapp.model.OrderHistory;
import com.tap.foodapp.model.OrderItems;

/**
 * Servlet implementation class AddOrderHistory
 */
//@WebServlet("/AddOrderHistory")
public class AddOrderHistory extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		HttpSession session = req.getSession();
		
		int orderId = (int) session.getAttribute("orderId");
		String userEmail = (String) session.getAttribute("userEmail");
		
		OrderDAO odao = new OrderDAOImpl();
		Order order = odao.getOrderByOrderId(orderId);
		float totalPrice = (float) order.getTotalAmount();
		String paymentType = order.getPaymentOption();
		int oitemid = order.getOrderItemId();
		
		OrderItemsDAO orderItem = new OrderItemsDAOImpl();
		OrderItems orditem = orderItem.fetchOrderItemById(oitemid);
		
		String restaurantName = orditem.getRestaurantName();
		int menuId = orditem.getMenuId();
		String menuName = orditem.getMenuName();
		int quantity = orditem.getQuantity();
		String orderedAddress = orditem.getUserAddress();
		
		OrderHistory oh = new OrderHistory(orderId,userEmail,restaurantName,menuId,menuName,quantity,totalPrice,paymentType,orderedAddress);
		
		OrderHistoryDAO ohdao = new OrderHistoryDAOImpl();
		int addHis = ohdao.insertOrderHistory(oh);
		
		if(addHis == 1)
		{
			resp.sendRedirect("homeUser.jsp");
		}
		else
		{
			resp.sendRedirect("failure.jsp");
		}
	}
	
}
