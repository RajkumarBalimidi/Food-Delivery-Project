package com.tap.foodapp.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.foodapp.dao.UserDAO;
import com.tap.foodapp.model.User;


public class UserDAOImpl implements UserDAO {
	
	User user;
	static Connection con;
	static PreparedStatement pstmt;
	static Statement stmt;
	static int res;
	static ResultSet result;
	
	
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
	
	private static final String INSERT_USER = "insert into users(name,email,phonenumber,address,role) values(?,?,?,?,?)";
	private static final String GET_ALL_USERS = "select * from users";
	private static final String GET_USER_BY_EMAIL = "select * from users where email=?";
	private static final String GET_USER_BY_ID = "select * from users where NoofUsers=?";
	private static final String DELETE_USER_BY_EMAIL = "delete from users where email=?";
	private static final String UPADATE_USER_ADDRESS = "update users set address=? where email=?";
	private static final String UPDATE_USER_PASSWORD = "update users set password=? where email=?";
	private static final String UPDATE_USER_DETAILS = "update users set name=?,address=?,role=? where email=?";
	
	
	static ArrayList<User> userList = new ArrayList<User>();
	@Override
	public int insertUser(User user) {
		
		try {
			
			pstmt = con.prepareStatement(INSERT_USER);
			pstmt.setString(1,user.getName());
			pstmt.setString(2,user.getEmail());
//			pstmt.setString(3,user.getPassword());
			pstmt.setString(3,user.getPhonenumber());
			pstmt.setString(4,user.getAddress());
			pstmt.setString(5,user.getRole());
			
			res = pstmt.executeUpdate();
			
			} catch (Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public List<User> getAllUsers() {
		try {
			stmt = con.createStatement();
			result = stmt.executeQuery(GET_ALL_USERS);
			userList = (ArrayList<User>) extractUserListFromResultSet(result);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return userList;
	}

	@Override
	public User getUserByEmail(String email) {
		try
		{
			pstmt = con.prepareStatement(GET_USER_BY_EMAIL);
			pstmt.setString(1,email);
			result = pstmt.executeQuery();
			if(result.next())
			{
				user = new User(result.getString("name"),result.getString("email"),result.getString("password"),result.getString("phonenumber"),result.getString("address"),result.getString("role"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public int deleteUserByEmail(String email) {
		try
		{
			pstmt = con.prepareStatement(DELETE_USER_BY_EMAIL);
			pstmt.setString(1,email);
			res = pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int updateUserByAddress(String email, String address) {
		try
		{
			pstmt = con.prepareStatement(UPADATE_USER_ADDRESS);
			pstmt.setString(1,address);
			pstmt.setString(2, email);
			res = pstmt.executeUpdate();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return res;
	}
	
	
	static List<User> extractUserListFromResultSet(ResultSet result) {
		try {
			while(result.next() == true)
			{
				userList.add(new User(result.getInt(1),
				result.getString(2),
				result.getString(3),
				result.getString(4),
				result.getString(5),
				result.getString(6),
				result.getString(7)));
			}
		}
			catch(Exception e) {
				e.printStackTrace();
			}
		return userList;
		
	}
	
	@Override
	public int updateUserPasswordByEmail(String email, String password) {
		try
		{
			pstmt = con.prepareStatement(UPDATE_USER_PASSWORD);
			pstmt.setString(1,password);
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
	public int updateUserDetails(String name, String address, String role, String email) {

		try {
			pstmt = con.prepareStatement(UPDATE_USER_DETAILS);
			pstmt.setString(1, name);
			pstmt.setString(2, address);
			pstmt.setString(3, role);
			pstmt.setString(4, email);
			res = pstmt.executeUpdate();
//			pstmt = con.prepareStatement(GET_USER_BY_EMAIL);
//			pstmt.setString(1, email);
//			result = pstmt.executeQuery();
//			if(result.next())
//			{
//				user = new User(result.getString("name"),result.getString("email"),result.getString("password"),result.getString("phonenumber"),result.getString("address"),result.getString("role"));
//			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public User getUserById(int userid) {
		try
		{
			pstmt = con.prepareStatement(GET_USER_BY_ID);
			pstmt.setInt(1,userid);
			result = pstmt.executeQuery();
			if(result.next())
			{
				user = new User(result.getString("name"),result.getString("email"),result.getString("password"),result.getString("phonenumber"),result.getString("address"),result.getString("role"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return user;
	}
	
}
