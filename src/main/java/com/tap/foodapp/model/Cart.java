package com.tap.foodapp.model;

public class Cart {
	
	private int cartId;
	private String userName;
	private int menuId;
	private String menuName;
	private int quantity;
	private float price;
	
	
	
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	
	
	public Cart(int cartId, String userName, int menuId, String menuName, int quantity, float price) {
		super();
		this.cartId = cartId;
		this.userName = userName;
		this.menuId = menuId;
		this.menuName = menuName;
		this.quantity = quantity;
		this.price = price;
	}
	public Cart(String userName, int menuId, String menuName, int quantity, float price) {
		super();
		this.userName = userName;
		this.menuId = menuId;
		this.menuName = menuName;
		this.quantity = quantity;
		this.price = price;
	}
	public Cart() {
		super();
	}
	
}
