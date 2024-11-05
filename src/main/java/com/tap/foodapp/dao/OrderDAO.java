package com.tap.foodapp.dao;

import java.util.List;

import com.tap.foodapp.model.Order;

public interface OrderDAO {

	List<Order> getAllOrders();
	
	int insertOrder(Order order);
	
	Order getOrderByOrderId(int oid);
	
	Order getOrderByUserEmail(String userEmail);
	
	int updateOrderStatusById(int id,String status);
	
	int deleteOrderById(int id);

	
}
