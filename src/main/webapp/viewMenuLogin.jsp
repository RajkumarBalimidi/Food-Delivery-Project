<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "java.util.ArrayList, com.tap.foodapp.model.User, com.tap.foodapp.model.Menu, com.tap.foodapp.dao.MenuDAO, com.tap.foodapp.impl.MenuDAOImpl" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Menu Items Login</title>
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
        border:1px solid darkskyblue;
        height:50px;
        width:100%;
        padding-top:10px;
    }
    .card-container {
        display: flex;
        flex-wrap: wrap;
        gap: 20px;
        margin-top: 20px;
        width: 100%;
        margin-left:150px;
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
        margin-right:40px;
        
    }
    
    .card:hover {
    transform: scale(1.02); /* Slightly enlarge card on hover */
	}
    .card h2 {
        font-size: 1.5em;
        color: #333;
    }
    .card p {
        font-size: 1em;
        color: #555;
    }
    .price {
        font-weight: bold;
        color: #008000;
        margin-top: 10px;
    }
    .availability {
        color: #333;
        margin-bottom: 10px;
    }
    .button-container {
        margin-top: 10px;
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
        background-color: blue;
    }
    .button2 {
        background-color: rgb(15, 155, 5, 0.936);
    }
    .button2:hover {
        background-color: blue;
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
%>
<%session.setAttribute("menu", menuList);%>
<h1>Menu Items</h1>
<div class="card-container">
<%
if(menuList != null) {
    for(Menu m : menuList) {
%>
        <div class="card">
            <img src="<%= m.getItemImage() %>" alt="Image Not Found" height="150px" width="250px">
        	<h5>ID : <%=m.getMenu_id() %></h5>
            <h4>Item Name : <%= m.getMenu_name() %></h4>
            <p class="price">₹<%= m.getPrice() %></p>
            <p class="availability"><%= m.getIsavailable() ? "Available" : "Not Available" %></p>
            <p><%= m.getDescription() %></p>
            <div class="button-container">
                <a href="orderCartLogin.jsp"><button class="button1">Add To Cart</button></a>
                <a href="orderCartLogin.jsp"><button class="button2">Order Now</button></a>
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
