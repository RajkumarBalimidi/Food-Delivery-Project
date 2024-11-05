package com.tap.foodapp.login;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.foodapp.model.Order;
import com.tap.foodapp.model.OrderHistory;
import com.tap.foodapp.model.OrderItems;
import com.tap.foodapp.model.User;
import com.tap.foodapp.dao.UserDAO;
import com.tap.foodapp.dao.OrderDAO;
import com.tap.foodapp.dao.OrderHistoryDAO;
import com.tap.foodapp.dao.OrderItemsDAO;
import com.tap.foodapp.impl.OrderDAOImpl;
import com.tap.foodapp.impl.OrderHistoryDAOImpl;
import com.tap.foodapp.impl.OrderItemsDAOImpl;
import com.tap.foodapp.impl.UserDAOImpl;

/**
 * Servlet implementation class PlaceOrder
 */
//@WebServlet("/PlaceOrder")
public class PlaceOrder extends HttpServlet {
	


	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		User user = (User) session.getAttribute("user");
		String userEmail = (String) session.getAttribute("userEmail");
		
		
			int orderitemid = Integer.parseInt(req.getParameter("orderitemid"));
			double totalAmount = Double.parseDouble(req.getParameter("totalprice"));
			String paymentOption = req.getParameter("paymentOption") ;
			String orderStatus = "Success";
			
			String userAddress = req.getParameter("useraddress");
			
			OrderItemsDAO oidao = new OrderItemsDAOImpl();
			int update = oidao.updateAddressByOrderItemId(orderitemid, userAddress);
			
			Order order = new Order(orderitemid,userEmail,totalAmount,paymentOption,orderStatus);
			
			OrderDAO odao = new OrderDAOImpl();
			int status = odao.insertOrder(order);
			
			if(status == 1)
			{
				Order orderList = (Order) odao.getOrderByUserEmail(userEmail);
				int orderId = orderList.getOrderid();
				
				Order order1 = odao.getOrderByOrderId(orderId);
				float totalPrice = (float) order1.getTotalAmount();
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
			
				session.setAttribute("userEmail", userEmail);
				resp.sendRedirect("orderSuccess.jsp");
			}
			else
			{
				resp.sendRedirect("orderFailure.jsp");			
			}


		
	}
	
}
















