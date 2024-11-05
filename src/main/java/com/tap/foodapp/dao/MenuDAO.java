package com.tap.foodapp.dao;

import java.util.List;

import com.tap.foodapp.model.Menu;

public interface MenuDAO {

	 int insertMenu(Menu menu);
	
	 List<Menu> getAllMenus();
	
	Menu getMenuById(int id);
	
	int deleteMenuById(int id);
	
	Menu updateMenuById(Menu menu);
	
	List<Menu> getMenuByRestaurantId(int restaurantId);
	
	
}
