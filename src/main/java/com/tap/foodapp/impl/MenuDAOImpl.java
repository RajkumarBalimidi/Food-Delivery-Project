package com.tap.foodapp.impl;

import java.util.ArrayList;
import java.util.List;

import com.tap.foodapp.dao.MenuDAO;
import com.tap.foodapp.model.Menu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class MenuDAOImpl implements MenuDAO {
	Menu menu;
	static PreparedStatement pstmt;
	static Statement stmt;
	static ResultSet result;
	static int res;
	static Connection con;

	static
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/food_delivery_project","root","MySQL");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	static ArrayList<Menu> menuList = new ArrayList<Menu>();
	private static final String INSERT_MENU = "insert into menu(restaurant_id,menu_name,price,description,isavaiable) values(?,?,?,?,?)";
	private static final String GET_ALL_MENUS = "select * from menu";
	private static final String GET_MENU_BY_ID = "select * from menu where menu_id=?";
	private static final String DELETE_MENU_BY_ID = "delete from menu where menu_id=?";
	private static final String UPDATE_PRICE = "update menu set menu_name=?, price=?, description=?, isavaiable=? where menu_id=?";
	private static final String GET_MENU_BY_RESTAURANT_ID = "select * from `menu` where `restaurant_id`=?";
	
	@Override
	public int insertMenu(Menu menu) {
		try {
			pstmt = con.prepareStatement(INSERT_MENU);
			pstmt.setInt(1,menu.getRestaurant_id());
			pstmt.setString(2,menu.getMenu_name());
			pstmt.setFloat(3,menu.getPrice());
			pstmt.setString(4,menu.getDescription());
			pstmt.setBoolean(5,menu.getIsavailable());
			res = pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public List<Menu> getAllMenus() {
		try {
			stmt = con.createStatement();		
			result = stmt.executeQuery(GET_ALL_MENUS);
			menuList = (ArrayList<Menu>) extractgetAllMenus(result);	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return menuList;
	}

	@Override
	public Menu getMenuById(int id) {
		try {
			pstmt = con.prepareStatement(GET_MENU_BY_ID);		
			pstmt.setInt(1,id);
			result = pstmt.executeQuery();
			if(result.next())
			{
				menu = new Menu(result.getInt(1),result.getInt(2),result.getString(3),result.getFloat(4),result.getString(5),result.getBoolean(6));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return menu;
	}

	@Override
	public int deleteMenuById(int id) {
		try {
			pstmt = con.prepareStatement(DELETE_MENU_BY_ID);
			pstmt.setInt(1,id);
			res = pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public Menu updateMenuById(Menu menu) {
		try {
			pstmt = con.prepareStatement(UPDATE_PRICE);
			pstmt.setString(1, menu.getMenu_name() );
			pstmt.setFloat(2, menu.getPrice());
			pstmt.setString(3, menu.getDescription());
			pstmt.setBoolean(4, menu.getIsavailable());
			pstmt.setInt(5, menu.getMenu_id());
			res = pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return menu;
	}
	
	public static List<Menu> extractgetAllMenus(ResultSet result){
		
		try {
			while(result.next())
			{
				menuList.add(new Menu(result.getInt(1),result.getInt(2),result.getString(3),result.getFloat(4),result.getString(5),result.getBoolean(6)));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return menuList;
		
	}

	@Override
	public List<Menu> getMenuByRestaurantId(int restaurantId) {

		try {
			pstmt = con.prepareStatement(GET_MENU_BY_RESTAURANT_ID);
			pstmt.setInt(1,restaurantId);
			result = pstmt.executeQuery();
			menuList.clear();
			while(result.next())
			{
				menuList.add(new Menu(result.getInt("menu_id"),result.getString("menu_name"),result.getFloat("price"),result.getString("description"),result.getBoolean("isavaiable")));				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return menuList;
	}

}
