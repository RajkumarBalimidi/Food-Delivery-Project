package com.tap.foodapp.dao;

import java.util.List;

import com.tap.foodapp.model.OrderHistory;

public interface OrderHistoryDAO {

	 	OrderHistory fetchOrderHistoryById(int id);  // Fetch order history by orderhistory_id

	    int insertOrderHistory(OrderHistory orderHistory);  // Insert order history details

	    int updateOrderHistoryStatusById(int id, String status);  // Update status by orderhistory_id

	    List<OrderHistory> fetchOrderHistoryByUserId(String uid);  // Fetch order history by user_id
	
}
