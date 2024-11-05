package com.tap.foodapp.model;

public class Menu {
	
	private int menu_id;
	private int restaurant_id;
	private String menu_name;
	private Float price;
	private String description;
	private Boolean isavailable;
	
	
	
	public int getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}
	public int getRestaurant_id() {
		return restaurant_id;
	}
	
	public void setRestaurant_id(int restaurant_id) {
		this.restaurant_id = restaurant_id;
	}
	public String getMenu_name() {
		return menu_name;
	}
	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Boolean getIsavailable() {
		return isavailable;
	}
	public void setIsavailabel(Boolean isavailable) {
		this.isavailable = isavailable;
	}
	
	
	
	public Menu(int menu_id, int restaurant_id, String menu_name, Float price, String description, Boolean isavailable) {
		super();
		this.menu_id = menu_id;
		this.restaurant_id = restaurant_id;
		this.menu_name = menu_name;
		this.price = price;
		this.description = description;
		this.isavailable = isavailable;
	}
	
	public Menu(int menu_id, String menu_name, Float price, String description, Boolean isavailable) {
		super();
		this.menu_id = menu_id;
		this.menu_name = menu_name;
		this.price = price;
		this.description = description;
		this.isavailable = isavailable;
	}
	
	public Menu(String menu_name1,int restaurant_id1, Float price1, String description1, Boolean isavailable1)
	{
		super();
		this.restaurant_id = restaurant_id1;
		this.menu_name = menu_name1;
		this.price = price1;
		this.description = description1;
		this.isavailable = isavailable1;
	}
	
	public Menu() {
		super();
	}

	@Override
	public String toString() {
		return menu_id + "  " + restaurant_id + "  " + menu_name + "  " + price + "   " + description + "  " + isavailable;
	}
	
}
