package com.tap.foodapp.dao;

import java.util.List;

import com.tap.foodapp.model.User;

public interface UserDAO {

	int insertUser(User user);
	
	List<User> getAllUsers(); 
	
	User getUserByEmail(String email);
	
	User getUserById(int userid);
	
	int deleteUserByEmail(String email);
	
	int updateUserByAddress(String email, String address);
	
	int updateUserPasswordByEmail(String email, String password);
	
	int updateUserDetails(String name, String address, String role, String email);
	
}
