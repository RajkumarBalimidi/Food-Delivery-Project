<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.tap.foodapp.model.OrderHistory, com.tap.foodapp.dao.OrderHistoryDAO,
 com.tap.foodapp.impl.OrderHistoryDAOImpl, com.tap.foodapp.model.Menu, com.tap.foodapp.dao.MenuDAO,
 com.tap.foodapp.impl.MenuDAOImpl" %>  
  
<<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Details</title>
<style>
  body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
    display: flex;
    justify-content: center; /* Center the container horizontally */
    align-items: center; /* Center the container vertically */
    height: 100vh; /* Set the height of the viewport */
    background-color: #f4f4f4; /* Optional: Light background for better contrast */
  }

  .container {
    display: flex;
    width: 90%; /* Total width of the container */
    height: 100%; /* Set the height of the container */
    background-color: #fff; /* Optional: Add a white background for the container */
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1); /* Optional: Add shadow for depth */
    border-radius: 8px; /* Optional: Rounded corners */
    overflow: hidden; /* Ensure content doesn't overflow the container */
  }

  .image-container {
    width: 50%; /* Image occupies 50% of the container width */
    height: 100%; /* Image occupies 100% of the container height */
  }

  .image-container img {
    width: 100%; /* Fill the image container horizontally */
    height: 100%; /* Fill the image container vertically */
    object-fit: cover; /* Ensure the image maintains aspect ratio and fills the space */
  }

  .content-container {
    width: 45%; /* Remaining 45% for the content */
    margin-left: 5%; /* 5% space between image and content */
    display: flex;
    flex-direction: column;
    justify-content: center; /* Vertically center the content */
    padding: 20px; /* Add padding for better spacing inside the content */
    box-sizing: border-box; /* Include padding in width/height calculation */
  }

  .content-container b {
    display: inline-block;
    width: 150px; /* Fixed width for labels */
    margin-bottom: 2px; /* Space between each row */
  }

  .content-container span {
    display: inline-block;
    margin-bottom: 5px;
  }
</style>
</head>
<body>
<%
int ohid = Integer.parseInt(request.getParameter("ohid"));
OrderHistoryDAO ohdao = new OrderHistoryDAOImpl();
OrderHistory ohl = ohdao.fetchOrderHistoryById(ohid); 
MenuDAO mdao = new MenuDAOImpl();
Menu mid = mdao.getMenuById(ohl.getMenuId());
String mimg = mid.getItemImage();
%>
<div class="container">
  <div class="image-container">
    <img src="<%= mimg %>" alt="Image Not Found">
  </div>
  <div class="content-container">
    <b>Order ID:</b> <span><%= ohl.getOrderId() %></span><br>
    <b>Menu ID:</b> <span><%= ohl.getMenuId() %></span><br>
    <b>Restaurant Name:</b> <span><%= ohl.getRestaurantName() %></span><br>
    <b>Item Name:</b> <span><%= ohl.getMenuName() %></span><br>
    <b>Quantity:</b> <span><%= ohl.getQuantity() %></span><br>
    <b>Total Price:</b> <span><%= ohl.getTotalAmount() %></span><br>
    <b>Payment Type:</b> <span><%= ohl.getPaymentType() %></span><br>
    <b>Ordered Address:</b> <span><%= ohl.getOrderedAddress() %></span><br>
    <b>Order Status:</b> <span><%= ohl.getOrderStatus() %></span><br>
  </div>
</div>
</body>
</html>
