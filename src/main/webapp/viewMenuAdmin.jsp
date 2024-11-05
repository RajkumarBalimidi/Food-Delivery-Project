<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "java.util.ArrayList, com.tap.foodapp.model.Restaurant, com.tap.foodapp.model.Menu, com.tap.foodapp.dao.MenuDAO, com.tap.foodapp.impl.MenuDAOImpl" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu Items</title>
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
    .menubar {
        margin-top: 0px;
        color: white;
        background-color: blue;
        border: 1px solid darkskyblue;
        height: 50px;
        width: 100%;
        display: flex;
        align-items: center;
        justify-content: space-between;
    }
    .menubar h1 {
        color: white;
        flex-grow: 1;
        text-align: center;
        margin: 0;
        margin-left: 100px;
    }
    .menubar a {
        text-decoration: none;
    }
    .menubar button {
        background-color: orange;
        color: white;
        border: none;
        cursor: pointer;
        height: 50px;
        width: 130px;
        font-size: medium;
    }
    .menubar button:hover {
        background-color: darkorange;
    }
    .AI {
        margin-left: 60px;
    }
    .card-container {
        display: flex;
        flex-wrap: wrap;
        gap: 20px;
        margin-top: 20px;
        width: 100%;
        padding: 0 20px;
        margin-left: 100px;
    }
    .card {
        background-color: #ffffff;
        border: 1px solid #ddd;
        border-radius: 8px;
        width: 250px;
        padding: 20px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        text-align: center;
        transition: transform 0.2s; /* Transition for hover effect */
        
    }
    .card:hover {
    	transform: scale(1.02); /* Slightly enlarge card on hover */
	}
    .card img {
        height: 120px;
        width: 180px;
        border-radius: 4px;
    }
    .card h2 {
        font-size: 1.5em;
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
        font-size: 1em;
        color: #555;
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
        background-color: rgb(26, 149, 7);
    }
    .button1:hover {
        background-color: green;
    }
    .button2 {
        background-color: rgb(243, 61, 48);
    }
    .button2:hover {
        background-color: red;
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
Restaurant r = (Restaurant)session.getAttribute("AdminId"); 
restaurantId = (int) session.getAttribute("restaurantId");
menuList = (ArrayList<Menu>) mdao.getMenuByRestaurantId(restaurantId);
%>
<div class="menubar">
    <a href="adminRestaurant.jsp"><button>Home Page</button></a>
    <h1>Menu Items</h1>
    <a href="addMenuItem.jsp"><button class="AI">ADD ITEM</button></a>
</div>

<div class="card-container">
<%
if (r != null && menuList != null) {
    for (Menu m : menuList) {
%>
        <div class="card">
            <img src="" alt="Image Not Found">
            <h5>Item ID : <%= m.getMenu_id() %></h5>
            <h4>Item Name : <%= m.getMenu_name() %></h4>
            <p class="price">₹<%= m.getPrice() %></p>
            <p class="availability"><%= m.getIsavailable() ? "Available" : "Not Available" %></p>
            <p class="description"><%= m.getDescription() %></p>
            <div>
                <a href="EditParticularMenu?Mid=<%= m.getMenu_id() %>"><button class="button1">EDIT</button></a>
                <a href="DeleteParticularMenu?Mid=<%= m.getMenu_id() %>"><button class="button2">DELETE</button></a>
            </div>
        </div>
<%
    }
} else {
    out.println("No Items are Here");
}
%>
</div>

</body>
</html>
