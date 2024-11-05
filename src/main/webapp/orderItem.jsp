<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.tap.foodapp.dao.OrderItemsDAO,com.tap.foodapp.model.User, com.tap.foodapp.impl.OrderItemsDAOImpl, com.tap.foodapp.model.OrderItems" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Item</title>

<style>
    /* Center the form on the page */
    body {
        display: flex;
        justify-content: center;
        align-items: center;
        min-height: 100vh;
        margin: 0;
        font-family: Arial, sans-serif;
        background-color: #f3f4f6;
    }

    /* Style for the form container */
    form {
        background-color: #ffffff;
        padding: 20px 30px;
        border-radius: 10px;
        box-shadow: 0px 4px 12px rgba(0, 0, 0, 0.1);
        width: 300px;
        text-align: center;
    }

    /* Style for the header */
    h1 {
        color: #333;
        font-size: 24px;
        margin-bottom: 20px;
    }

    /* Label and input styling */
    label {
        font-weight: bold;
        font-size: 14px;
        color: #333;
        display: block;
        margin: 10px 0 5px;
        text-align: left;
    }

    input[type="text"] {
        width: 100%;
        padding: 8px;
        margin-bottom: 10px;
        border: 1px solid #ccc;
        border-radius: 5px;
        background-color: #f9f9f9;
        font-size: 14px;
    }

    select {
        width: 100%;
        padding: 8px;
        border: 1px solid #ccc;
        border-radius: 5px;
        font-size: 14px;
        background-color: #f9f9f9;
        margin-bottom: 15px;
    }

    /* Style for the submit button */
    input[type="submit"] {
        background-color: #4CAF50;
        color: white;
        padding: 10px 20px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        font-size: 16px;
        transition: background-color 0.3s;
        width: 100%;
    }

    /* Hover effect for submit button */
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
%>
<%
if(user != null){
%>
<form action="PlaceOrder">
	<h1>Order Item</h1>
	<label>Order Item ID : </label><input type="text" name="orderitemid" value="<%= oiId.getOrderitemsId() %>" readonly><br>
	<label>Menu ID : </label><input type="text" name="menuid" value="<%= oiId.getMenuId() %>" readonly><br>
	<label>Menu Name : </label><input type="text" name="menuname" value="<%= oiId.getMenuName() %>" readonly><br>
	<label>Restaurant Name : </label><input type="text" name="resname" value="<%= oiId.getRestaurantName() %>" readonly><br>
	<label>Quantity : </label><input type="text" name="quantity" value="<%= oiId.getQuantity() %>" readonly><br>
	<label>Total Price : </label><input type="text" name="totalprice" value="<%= oiId.getSubtotalPrice() %>" readonly><br>

	<label>Address : </label><input type="text" name="useraddress" value="<%= oiId.getUserAddress() %>"><br>
	
	<label>Select Payment Option</label>
    <select name="paymentOption">
        <option value="cash">Cash on Delivery</option>
        <option value="phonepe">PhonePe</option>
        <option value="paytm">Paytm</option>
        <option value="gpay">GPay</option>
    </select>
    <br>
    <input type="submit" value="Order">
</form>

<%} %>

</body>
</html>