package com.tap.foodapp.model;

public class Order {
	
	private int orderid;
	private int orderItemId;
	private String userEmail;
	private double totalAmount;
	private String paymentOption;
	private String status;
	
	
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public int getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getPaymentOption() {
		return paymentOption;
	}
	public void setPaymentOption(String paymentOption) {
		this.paymentOption = paymentOption;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Order(int orderid, int orderItemId, String userEmail, double totalAmount, String paymentOption, String status) {
		super();
		this.orderid = orderid;
		this.orderItemId = orderItemId;
		this.userEmail = userEmail;
		this.totalAmount = totalAmount;
		this.paymentOption = paymentOption;
		this.status = status;
	}
	
	public Order(int orderItemId, String userEmail, double totalAmount, String paymentOption, String status) {
		super();
		this.orderItemId = orderItemId;
		this.userEmail = userEmail;
		this.totalAmount = totalAmount;
		this.paymentOption = paymentOption;
		this.status = status;
	}
	
	public Order() {
		super();
	}
	
	
	
	
	
}
