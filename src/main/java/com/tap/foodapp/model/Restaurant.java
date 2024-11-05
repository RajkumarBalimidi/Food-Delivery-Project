package com.tap.foodapp.model;

public class Restaurant {

	private int resid ;
	private String resname;
	private String address;
	private float rating;
	private boolean isactive;
	private String adminid;
	private String password;
	private String cuisinetype;
	private String resImage;
	
	public int getResid() {
		return resid;
	}
	public void setResid(int resid) {
		this.resid = resid;
	}
	public String getResname() {
		return resname;
	}
	public void setResname(String resname) {
		this.resname = resname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public boolean getIsactive() {
		return isactive;
	}
	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}
	public String getAdminid() {
		return adminid;
	}
	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCuisinetype() {
		return cuisinetype;
	}
	public void setCuisinetype(String cuisinetype) {
		this.cuisinetype = cuisinetype;
	}
	public String getResImage() {
		return resImage;
	}
	public void setResImage(String resImage) {
		this.resImage = resImage;
	}
	
	public Restaurant() {
		super();
	}
	
	public Restaurant(int resid, String resname, String address, float rating, boolean isactive, String adminid, String password, String cuisinetype, String resImage) {
		super();
		this.resid = resid;
		this.resname = resname;
		this.address = address;
		this.rating = rating;
		this.isactive = isactive;
		this.adminid = adminid;
		this.password = password;
		this.cuisinetype = cuisinetype;
		this.resImage = resImage;
	}
	
	public Restaurant(int resid, String resname, String address, boolean isactive, String adminid, String cuisinetype) {
		super();
		this.resid = resid;
		this.resname = resname;
		this.address = address;
		this.isactive = isactive;
		this.adminid = adminid;
		this.cuisinetype = cuisinetype;
	}
	
	
	public Restaurant(String resname, String address, boolean isactive, String cuisinetype, String adminid, String resImage) {
		super();
		this.resname = resname;
		this.address = address;
		this.isactive = isactive;
		this.adminid = adminid;
		this.cuisinetype = cuisinetype;
		this.resImage = resImage;
	}
	
	public Restaurant(String resname, String address, boolean isactive, String cuisinetype) {
		super();
		this.resname = resname;
		this.address = address;
		this.isactive = isactive;
		this.cuisinetype = cuisinetype;
	}
	
	@Override
	public String toString() {
		return resid + "  " + resname + "  " + address + "  " + rating + "  " + isactive +"  " + adminid + "  " + password +"  "+ cuisinetype;
	}
	
	
	
	
	
}
