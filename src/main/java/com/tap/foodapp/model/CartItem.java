package com.tap.foodapp.model;


public class CartItem {

    // Fields to represent the details of an item in the cart
    private int menuId;          // Unique ID of the item
    private int restaurantId;    // ID of the restaurant the item belongs to
    private String menuName;         // Name of the item
    private int quantity;        // Quantity of the item
    private float price;        // Price of the item
    
    

    // Constructor to initialize the fields when creating a new CartItem object
    public CartItem(int menuId, int restaurantId, String menuName, int quantity, float price) {
        this.menuId = menuId;
        this.restaurantId = restaurantId;
        this.menuName = menuName;
        this.quantity = quantity;
        this.price = price;
    }
    
    public CartItem() {
		super();
	}

    // Getter and setter methods for each field

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

    public double getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

	@Override
	public String toString() {
		return "CartItem [itemId=" + menuId + ", restaurantId=" + restaurantId + ", name=" + menuName + ", quantity="
				+ quantity + ", price=" + price + "]";
	}

	
    
}