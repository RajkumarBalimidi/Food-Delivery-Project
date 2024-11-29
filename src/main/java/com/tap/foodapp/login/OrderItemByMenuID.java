package com.tap.foodapp.login;

import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.foodapp.model.Menu;
import com.tap.foodapp.model.OrderItems;
import com.tap.foodapp.model.Restaurant;
import com.tap.foodapp.model.User;
import com.tap.foodapp.dao.MenuDAO;
import com.tap.foodapp.impl.MenuDAOImpl;
import com.tap.foodapp.dao.RestaurantDAO;
import com.tap.foodapp.dao.UserDAO;
import com.tap.foodapp.impl.RestaurantDAOImpl;
import com.tap.foodapp.impl.UserDAOImpl;
import com.tap.foodapp.dao.OrderItemsDAO;
import com.tap.foodapp.impl.OrderItemsDAOImpl;


public class OrderItemByMenuID extends HttpServlet {
	
	
	private String userEmail;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   
		HttpSession session = req.getSession();
        int menuId = Integer.parseInt(req.getParameter("menuid"));
        User user = (User) session.getAttribute("user");
        
        if(user != null)
        {
        	userEmail = (String) session.getAttribute("userid");
        	UserDAO udao = new UserDAOImpl();
        	User uid = udao.getUserByEmail(userEmail);
        	String userAddress = uid.getAddress();
      
	        MenuDAO mdao = new MenuDAOImpl();
	        Menu mid = mdao.getMenuById(menuId);
	        
	        String menuName = mid.getMenu_name();
	        double price = mid.getPrice();
	        int restaurantId = mid.getRestaurant_id();
	        
	        RestaurantDAO rdao = new RestaurantDAOImpl();
	        Restaurant rid = rdao.getRestaurantById(restaurantId);
	        
	        String restaurantName = rid.getResname();
	        
	        int quantity = Integer.parseInt(req.getParameter("quantity"));
	        double subTotalPrice = price * quantity;
	        
	        OrderItems oitem = new OrderItems(userEmail, userAddress, menuId, menuName, restaurantId, restaurantName, quantity, subTotalPrice);
	        
	        OrderItemsDAO oidao = new OrderItemsDAOImpl();
	        int status = oidao.insertOrderItem(oitem);
	        
	        if (status == 1)
	        {
	        	OrderItemSuccess(req, resp, user);
	        }
	        else
	        {
	        	resp.sendRedirect("failureOitem.jsp");
	        }
	        
        }
	}
	

	private void OrderItemSuccess(HttpServletRequest req, HttpServletResponse resp,User user) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		ArrayList<OrderItems> oili = null;
		
		OrderItems oite = null;
		OrderItemsDAO oidao = new OrderItemsDAOImpl();
		oili = (ArrayList<OrderItems>) oidao.fetchOrderItemsByEmail(userEmail);
		
		ListIterator<OrderItems> lit=oili.listIterator(oili.size());
		while(lit.hasPrevious()) {
			oite = (OrderItems) lit.previous();
			break;
		}
		
		int oiId = oite.getOrderitemsId();
		session.setAttribute("oiid", oiId);
		session.setAttribute("user", user);
		session.setAttribute("userEmail", userEmail);
		resp.sendRedirect("orderItem.jsp");
		
	}
	
}





















