package com.tap.foodapp.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.foodapp.dao.CartDAO;
import com.tap.foodapp.model.Cart;

public class CartDAOImpl implements CartDAO{
	
	private static Connection con;
	private static PreparedStatement pstmt;	
	private static int result;
	private Statement stmt;
	private ResultSet res;

	private Cart cart;
	private ArrayList<Cart> cartList = new ArrayList<Cart>();

	private static String INSERT_CART_ITEM = "insert into `cart`(`userName`,`menuId`,`menuName`,`quantity`,`price`) values(?, ?, ?, ?, ?)";
	private static String GET_CART_ITEM_BY_USERNAME = "select * from `cart` where `userName`= ?";
	private static String DELETE_CART_ITEM_BY_CARTID = "delete from `cart` where `cartId`= ?";
	private static String GET_ALL_CART_ITEMS_BY_CARTID = "select * from `cart`";
	
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
	public int insertCart(Cart cart)
	{
		try
		{
			pstmt = con.prepareStatement(INSERT_CART_ITEM);
			pstmt.setString(1, cart.getUserName());
			pstmt.setInt(2, cart.getMenuId());
			pstmt.setString(3, cart.getMenuName());
			pstmt.setInt(4, cart.getQuantity());
			pstmt.setFloat(5, cart.getPrice());
			
			result = pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public List<Cart> getAllCartItems() {
		
		try
		{
			stmt = con.createStatement();
			res = stmt.executeQuery(GET_ALL_CART_ITEMS_BY_CARTID);
			
			cartList = (ArrayList<Cart>) extractCartList(res);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return cartList;
	}

	

	@Override
	public List<Cart> getCartByUserId(String userId) {
		try
		{
			pstmt = con.prepareStatement(GET_CART_ITEM_BY_USERNAME);		
			pstmt.setString(1,userId);
			res = pstmt.executeQuery();
			if(res.next())
			{
				cartList = (ArrayList<Cart>) extractCartList(res);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return cartList;
	}

	@Override
	public int RemoveCartItemByCartId(int cartId) {
		try
		{
			pstmt = con.prepareStatement(DELETE_CART_ITEM_BY_CARTID);
			pstmt.setInt(1,cartId);
			result = pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}

	
	private ArrayList<Cart> extractCartList(ResultSet res) {
		try {
			cartList.clear();
			while(res.next()==true) {
				cartList.add(new Cart(
						res.getInt("cartId"),
						res.getString("userName"),
						res.getInt("menuId"),
						res.getString("menuName"),
						res.getInt("quantity"),
						res.getFloat("price")
						));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cartList;
	}
	
}
