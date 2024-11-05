package com.tap.foodapp.impl;

import java.util.ArrayList;
import java.util.List;

import com.tap.foodapp.dao.RestaurantDAO;
import com.tap.foodapp.model.Restaurant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class RestaurantDAOImpl implements RestaurantDAO {
	
	Restaurant restaurant;
	static Connection con;
	static PreparedStatement pstmt;
	static Statement stmt;
	static ResultSet result;
	static int res;
	
	
	static ArrayList<Restaurant> restaurantList = new ArrayList<Restaurant>();
	private static final String INSERT_RESTAURANT = "insert into restaurant(restaurant_name,address,isactive,cuisine_type,adminid,image_path) values(?,?,?,?,?,?)"; 
	private static final String FETCH_ALL_RESTAURANTS = "select * from `restaurant`";
	private static final String GET_RESTAURANT_BY_ID = "select * from restaurant where restaurant_id=?";
	private static final String DELETE_RESTAURANT_BY_ID = "delete from restaurant where adminid=?";
	private static final String UPDATE_RATING = "update restaurant set isactive=? where restaurant_id=?";
	private static final String GET_RESTAURANT_BY_ADMINID = "select * from restaurant where adminid=?";
	private static final String UPDATE_ADMIN_PASSWORD = "update restaurant set password=? where adminid=?";
	private static final String UPDATE_RESTAURANT_DETAILS = "update restaurant set restaurant_name=?, address=?, isactive=?, cuisine_type=? where adminid=?"; 
	
	
	
	static 
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/food_delivery_project","root","MySQL");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}



	@Override
	public int insertRestaurant(Restaurant restaurant) {
		
		try 
		{
			pstmt = con.prepareStatement(INSERT_RESTAURANT);
			
			pstmt.setString(1, restaurant.getResname());
			pstmt.setString(2, restaurant.getAddress());
			pstmt.setBoolean(3, restaurant.getIsactive());
			pstmt.setString(4, restaurant.getCuisinetype());
			pstmt.setString(5, restaurant.getAdminid());
			pstmt.setString(6, restaurant.getResImage());
			
			res = pstmt.executeUpdate();			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public List<Restaurant> getAllRestaurants() {
		try {
			stmt = con.createStatement();
			result = stmt.executeQuery(FETCH_ALL_RESTAURANTS);
			
			restaurantList = (ArrayList<Restaurant>) extractRestaurantList(result);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return restaurantList;
	}

	@Override
	public Restaurant getRestaurantById(int id) {
		try {
			pstmt = con.prepareStatement(GET_RESTAURANT_BY_ID);
			pstmt.setInt(1,id);
			result = pstmt.executeQuery();
			restaurantList = (ArrayList<Restaurant>) extractRestaurantList(result);
			restaurant = restaurantList.get(0);
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return restaurant;
	}

	@Override
	public int deleteRestaurantByAdminId(String adminid) {
		try {
			pstmt = con.prepareStatement(DELETE_RESTAURANT_BY_ID);
			pstmt.setString(1,adminid);
			res = pstmt.executeUpdate();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int updateRestaurantById(int id, boolean isActive) {
		try {
			pstmt = con.prepareStatement(UPDATE_RATING);
			pstmt.setInt(2, id);
			pstmt.setBoolean(1, isActive);
			res = pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	
	static List<Restaurant> extractRestaurantList(ResultSet result){
	
		try {
			restaurantList.clear();
			while(result.next()==true) {
				restaurantList.add(new Restaurant(result.getInt("restaurant_id"),
						result.getString("restaurant_name"),
						result.getString("address"),
						result.getFloat("rating"),
						result.getBoolean("isactive"),
						result.getString("adminid"),
						result.getString("password"),
						result.getString("cuisine_type"),
						result.getString("image_path")
						));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return restaurantList;
	}

	@Override
	public Restaurant getRestaurantByAdminId(String adminid) {
		
		try {
			pstmt = con.prepareStatement(GET_RESTAURANT_BY_ADMINID);
			pstmt.setString(1, adminid);
			result = pstmt.executeQuery();
			if(result.next())
			{
				restaurant = new Restaurant(result.getInt("restaurant_id"),result.getString("restaurant_name"),result.getString("address"),result.getFloat("rating"),result.getBoolean("isactive"),result.getString("adminid"),result.getString("password"),result.getString("cuisine_type"),result.getString("image_path"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return restaurant;
	}

	@Override
	public int updateRestaurantAdminPassword(String email, String password) {
		
		try {
			pstmt = con.prepareStatement(UPDATE_ADMIN_PASSWORD);
			pstmt.setString(1, password);
			pstmt.setString(2, email);
			res = pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int updateRestaurantDetails(Restaurant restaurant) {
		
		try {
			pstmt = con.prepareStatement(UPDATE_RESTAURANT_DETAILS);
			
			pstmt.setString(1, restaurant.getResname());
			pstmt.setString(2, restaurant.getAddress());
			pstmt.setBoolean(3, restaurant.getIsactive());
			pstmt.setString(4, restaurant.getCuisinetype());
			pstmt.setString(5, restaurant.getAdminid());
			
			res = pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return 0;
	}
	
	
	
	
}
