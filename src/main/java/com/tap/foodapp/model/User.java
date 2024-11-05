package com.tap.foodapp.model;

public class User {
	
	private int userid;
	private String name;
	private String email;
	private String password;
	private String phonenumber;
	private String address;
	private String role;
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String passsword) {
		this.password = passsword;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public User() {
		super();
	}
	
	public User(int userid, String name, String email, String passsword, String phonenumber, String address,
			String role) {
		super();
		this.userid = userid;
		this.name = name;
		this.email = email;
		this.password = passsword;
		this.phonenumber = phonenumber;
		this.address = address;
		this.role = role;
	}
	
	public User(String name, String email, String passsword, String phonenumber, String address, String role) {
		super();
		this.name = name;
		this.email = email;
		this.password = passsword;
		this.phonenumber = phonenumber;
		this.address = address;
		this.role = role;
	}
	
	
	
	public User(String name, String email, String phonenumber, String address, String role) {
		super();
		this.name = name;
		this.email = email;
		this.phonenumber = phonenumber;
		this.address = address;
		this.role = role;
	}
	@Override
	public String toString() {
		return userid + "  " + name + "  " + email + "  " + password
				+ "  " + phonenumber + "  " + address + "  " + role;
	}
	
	
	
}
