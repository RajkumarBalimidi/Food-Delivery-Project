package com.tap.foodapp.model;

public class OrderHistory {
	
    private int orderHistoryId;
    private int orderId;
    private String userEmail;
    private String restaurantName;
    private int menuId;
    private String menuName;
    private int quantity;
    private float totalAmount;
    private String paymentType;
    private String orderedAddress;
    private String orderStatus;
    
	public int getOrderHistoryId() {
		return orderHistoryId;
	}
	public void setOrderHistoryId(int orderHistoryId) {
		this.orderHistoryId = orderHistoryId;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public float getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public String getOrderedAddress() {
		return orderedAddress;
	}
	public void setOrderedAddress(String orderedAddress) {
		this.orderedAddress = orderedAddress;
	}
	
	public OrderHistory(int orderHistoryId, int orderId, String userEmail, String restaurantName, int menuId, String menuName,
			int quantity, float totalAmount, String paymentType,String orderedAddress, String orderStatus) {
		super();
		this.orderHistoryId = orderHistoryId;
		this.orderId = orderId;
		this.userEmail = userEmail;
		this.restaurantName = restaurantName;
		this.menuId = menuId;
		this.menuName = menuName;
		this.quantity = quantity;
		this.totalAmount = totalAmount;
		this.paymentType = paymentType;
		this.orderedAddress = orderedAddress;
		this.orderStatus = orderStatus;
	}
	
	
	public OrderHistory(int orderId, String userEmail, String restaurantName, int menuId, String menuName, int quantity,
			float totalAmount, String paymentType, String orderedAddress) {
		super();
		this.orderId = orderId;
		this.userEmail = userEmail;
		this.restaurantName = restaurantName;
		this.menuId = menuId;
		this.menuName = menuName;
		this.quantity = quantity;
		this.totalAmount = totalAmount;
		this.paymentType = paymentType;
		this.orderedAddress = orderedAddress;
	}
	public OrderHistory() {
		super();
	}
    
		
	
    
}
