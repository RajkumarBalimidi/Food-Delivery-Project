<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList,com.tap.foodapp.model.User, com.tap.foodapp.model.Menu, com.tap.foodapp.dao.MenuDAO, com.tap.foodapp.impl.MenuDAOImpl" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Menu Items User</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        display: flex;
        flex-direction: column;
        align-items: center;
        background-color: #f5f5f5;
    }
    h1 {
        margin-top: 20px;
        text-align: center;
        color: white;
        background-color: blue;
        border: 1px solid darkskyblue;
        height: 50px;
        width: 100%;
        padding-top: 10px;
    }
    .card-container {
        display: flex;
        flex-wrap: wrap;
        gap: 20px;
        margin-top: 20px;
        width: 100%;
        padding: 0 20px;
        margin-left: 100px
    }
    .card {
        background-color: #ffffff;
        border: 1px solid #ddd;
        border-radius: 8px;
        width: 230px;
        padding: 20px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        text-align: center;
        margin-left: 20px;
   		transition: transform 0.2s; /* Transition for hover effect */
    }
    .card:hover {
    	transform: scale(1.02); /* Slightly enlarge card on hover */
	}
    .card h2 {
        font-size: 1.2em;
        color: #333;
        margin: 10px 0;
    }
    .price {
        font-weight: bold;
        color: #008000;
        margin: 10px 0;
    }
    .availability {
        color: #333;
        margin-bottom: 10px;
    }
    .description {
        font-size: 0.9em;
        color: #555;
        margin-bottom: 10px;
    }
    input[type="number"] {
        width: 50px;
        text-align: center;
        margin-bottom: 10px;
    }
    .button1, .button2 {
        padding: 8px 16px;
        margin: 5px;
        cursor: pointer;
        font-size: medium;
        border-radius: 3px;
        color: white;
        border: none;
    }
    .button1 {
        background-color: red;
    }
    .button1:hover {
        background-color: darkred;
    }
    .button2 {
        background-color: rgb(15, 155, 5);
    }
    .button2:hover {
        background-color: green;
    }
</style>
</head>
<body>

<%!
ArrayList<Menu> menuList; 
MenuDAO mdao = new MenuDAOImpl();
int restaurantId;
%>

<%
restaurantId = (int) session.getAttribute("RestaurantId");
menuList = (ArrayList<Menu>) mdao.getMenuByRestaurantId(restaurantId);
User user = (User) session.getAttribute("user");
%>
<%
session.setAttribute("user", user);
session.setAttribute("userid", session.getAttribute("userid"));
%>
<% if(user != null) { %>
<h1>Menu Items</h1>

<div class="card-container">
<%
if(menuList != null) {
    for(Menu m : menuList) {
%>
    <div class="card">
    	<img src="" alt="Image Not Found">
        <h5>Item ID : <%= m.getMenu_id() %></h5>
        <h4><%= m.getMenu_name() %></h4>
        <p class="price">₹<%= m.getPrice() %></p>
        <p class="availability"><%= m.getIsavailable() ? "Available" : "Not Available" %></p>
        <p class="description"><%= m.getDescription() %></p>

        <!-- Add to Cart form with Quantity -->
        <form action="AddToCartByMenuID" method="post">
            <input type="hidden" name="menuId" value="<%= m.getMenu_id() %>">
            <input type="hidden" name="itemName" value="<%= m.getMenu_name() %>">
            <input type="hidden" name="price" value="<%= m.getPrice() %>">
            <input type="hidden" name="act" value="add">
            <input type="number" name="quantity" value="1" min="1">
            <input type="submit" value="Add to Cart" class="button1">
        </form>

        <!-- Order Now form with Quantity -->
        <form action="OrderItemByMenuID" method="post">
            <input type="hidden" name="menuid" value="<%= m.getMenu_id() %>">
            <input type="number" name="quantity" value="1" min="1">
            <input type="submit" class="button2" value="Order Now">
        </form>
    </div>
<%
    }
} else {
    out.println("No Items are Here");
}
%>
</div>
<% } %>

</body>
</html>
