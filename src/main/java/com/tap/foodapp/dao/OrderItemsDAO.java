package com.tap.foodapp.dao;

import java.util.List;

import com.tap.foodapp.model.OrderItems;

public interface OrderItemsDAO {

	// Fetch all order items for a specific orderId
    List<OrderItems> fetchOrderItemsByOrderId(int orderitemId);
    
    // Fetch all order items for a specific email
    List<OrderItems> fetchOrderItemsByEmail(String userEmail);

    // Insert an order item
    int insertOrderItem(OrderItems orderItem);

    // Update the quantity and subtotal price of an order item by orderItemId
    int updateOrderItemById(int orderItemId, int quantity, double subtotalPrice);
    
    int updateAddressByOrderItemId(int orderitemid, String Address);

    // Delete an order item by orderItemId
    int deleteOrderItemById(int orderItemId);

    // Fetch order item by orderItemId
    OrderItems fetchOrderItemById(int orderItemId);
	
}
