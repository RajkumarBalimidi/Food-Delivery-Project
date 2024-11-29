<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.tap.foodapp.dao.OrderItemsDAO,com.tap.foodapp.model.User,
		 com.tap.foodapp.impl.OrderItemsDAOImpl, com.tap.foodapp.model.OrderItems,
		 com.tap.foodapp.impl.MenuDAOImpl, com.tap.foodapp.dao.MenuDAO, com.tap.foodapp.model.Menu" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Item</title>

<style>
    /* Ensure the entire page uses Flexbox for layout */
    body {
        display: flex;
        justify-content: space-between;
        align-items: center;
        min-height: 100vh;
        margin: 0;
        font-family: Arial, sans-serif;
        background-color: #f3f4f6;
        padding: 0 2%; /* Add space on both sides of the page */
    }

    /* Main container for image and form */
    .container {
        display: flex;
        width: 100%; /* Total width, leaving 5% padding on both sides */
        max-width: 1200px;
        background-color: #ffffff;
        margin: 0 auto;
        gap: 5%; /* Space between image and form */
    }

    /* Image styling */
    .image-container img {
        width: 100%;
        height: auto;
        object-fit: cover;
        border-radius: 10px;
        box-shadow: 0px 4px 12px rgba(0, 0, 0, 0.1);
    }

    .image-container {
        width: 50%; /* Image occupies 50% of the container */
        display: flex;
        align-items: center;
        justify-content: center;
    }

    /* Form styling */
    .form-container {
        width: 40%; /* Form occupies 40% of the container */
        padding: 20px 30px;
        background-color: #ffffff;
        border-radius: 10px;
        box-shadow: 0px 4px 12px rgba(0, 0, 0, 0.1);
        display: flex;
        flex-direction: column;
        justify-content: center;
    }

    form {
        display: grid;
        grid-template-columns: 1fr 1fr; /* Two columns for labels and inputs */
        gap: 15px 10px; /* Spacing between rows and columns */
        width: 100%;
    }

    h1 {
        color: white;
        background-color: blue;
        height: 35px;
        font-size: 24px;
        margin-bottom: 20px;
        grid-column: span 2; /* Header spans both columns */
        text-align: center;
     	padding-top: 10px;
       
    }

    label {
        font-weight: bold;
        font-size: 14px;
        color: #333;
        text-align: left;
    }

    input[type="text"], select {
        width: 100%;
        padding: 8px;
        border: 1px solid #ccc;
        border-radius: 5px;
        font-size: 14px;
    }
    input[readonly] {
    background-color: #e9ecef;
}
	input[type="address"]{
	 width: 100%;
	  padding: 8px;
        border: 1px solid #ccc;
        border-radius: 5px;
		background-color: white;
		font-size: 14px;
	}
	
    select {
    	background-color: white;
        grid-column: span 2; /* Dropdown spans both columns */
    }

    input[type="submit"] {
        background-color: #4CAF50;
        color: white;
        padding: 15px 20px;
        margin-top: 15px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        font-size: 16px;
        transition: background-color 0.3s;
        grid-column: span 2; /* Submit button spans both columns */
    }

    input[type="submit"]:hover {
        background-color: #45a049;
    }
</style>


</head>
<body>
<%
int oiid = (int) session.getAttribute("oiid"); 
OrderItemsDAO oidao = new OrderItemsDAOImpl();
OrderItems oiId = oidao.fetchOrderItemById(oiid);
String userEmail = (String) session.getAttribute("userEmail");
User user = (User) session.getAttribute("user");
session.setAttribute("userEmail", userEmail);
session.setAttribute("user", user);

MenuDAO mdao = new MenuDAOImpl();
Menu mid = mdao.getMenuById(oiId.getMenuId());
String mimg = mid.getItemImage();
%>
<%
if(user != null){
%>
<div class="container">
    <div class="image-container">
        <img src="<%= mimg %>" alt="Menu Item">
    </div>
    <div class="form-container">
        <form action="PlaceOrder">
            <h1>Order Item</h1>
            <label>Order Item ID:</label>
            <input type="text" name="orderitemid" value="<%= oiId.getOrderitemsId() %>" readonly>
            
            <label>Menu ID:</label>
            <input type="text" name="menuid" value="<%= oiId.getMenuId() %>" readonly>
            
            <label>Menu Name:</label>
            <input type="text" name="menuname" value="<%= oiId.getMenuName() %>" readonly>
            
            <label>Restaurant Name:</label>
            <input type="text" name="resname" value="<%= oiId.getRestaurantName() %>" readonly>
            
            <label>Quantity:</label>
            <input type="text" name="quantity" value="<%= oiId.getQuantity() %>" readonly>
            
            <label>Total Price:</label>
            <input type="text" name="totalprice" value="<%= oiId.getSubtotalPrice() %>" readonly>
            
            <label>Address:</label>
            <input type="address" name="useraddress" value="<%= oiId.getUserAddress() %>">
            
            <label>Select Payment Option</label>
            <select name="paymentOption">
                <option value="cash">Cash on Delivery</option>
                <option value="phonepe">PhonePe</option>
                <option value="paytm">Paytm</option>
                <option value="gpay">GPay</option>
            </select>
            
            <input type="submit" value="Order">
            
        </form>
    </div>
</div>
<% } %>
</body>
</html>
