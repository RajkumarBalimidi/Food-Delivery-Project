package com.tap.foodapp.model;

public class OrderItems {

	private int orderitemsId;
	private String userEmail;
	private User userEmaill;
	private String userAddress;
	private int menuId;
	private String menuName;
	private int restaurantId;
	private String restaurantName;
	private int quantity;
	private double subtotalPrice;
	
	public int getOrderitemsId() {
		return orderitemsId;
	}
	public void setOrderitemsId(int orderitemsId) {
		this.orderitemsId = orderitemsId;
	}

	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getSubtotalPrice() {
		return subtotalPrice;
	}
	public void setSubtotalPrice(double subtotalPrice) {
		this.subtotalPrice = subtotalPrice;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public User getUserEmaill() {
		return userEmaill;
	}
	public void setUserEmaill(User userEmaill) {
		this.userEmaill = userEmaill;
	}
	
	
	public OrderItems(int orderitemsId, String userEmail,String userAddress, int menuId,String menuName, int restaurantId, String restaurantName, int quantity, double subtotalPrice) {
		super();
		this.orderitemsId = orderitemsId;
		this.userEmail = userEmail;
		this.userAddress = userAddress;
		this.menuId = menuId;
		this.menuName = menuName;
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.quantity = quantity;
		this.subtotalPrice = subtotalPrice;
	}
	
	
	public OrderItems(String userEmail,String userAddress, int menuId, String menuName, int restaurantId, String restaurantName,
			int quantity, double subtotalPrice) {
		super();
		this.userEmail = userEmail;
		this.userAddress = userAddress;
		this.menuId = menuId;
		this.menuName = menuName;
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.quantity = quantity;
		this.subtotalPrice = subtotalPrice;
	}
	public OrderItems() {
		super();
	}
	
}
