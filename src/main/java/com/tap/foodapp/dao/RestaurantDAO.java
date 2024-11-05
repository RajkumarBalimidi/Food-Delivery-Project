package com.tap.foodapp.dao;

import java.util.List;

import com.tap.foodapp.model.Restaurant;

public interface RestaurantDAO {
	
	int insertRestaurant(Restaurant restaurant);
	
	List<Restaurant> getAllRestaurants();
	
	Restaurant getRestaurantById(int id);
	
//	Restaurant getRestaurantByName(String name);	
	
	int deleteRestaurantByAdminId(String adminid);

	int updateRestaurantById(int id, boolean isActive);
	
	Restaurant getRestaurantByAdminId(String adminid);
	
	int updateRestaurantAdminPassword(String email, String password);
	
	int updateRestaurantDetails(Restaurant restaurant);
	
}
