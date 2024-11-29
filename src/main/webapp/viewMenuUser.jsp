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
    
 
.menubar {
    display: flex;
    align-items: center;
    justify-content: space-between;
    background-color: #12ccf6; /* Light yellow background */
    padding: 5px 0px; /* Padding around the items */
    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1); /* Subtle shadow effect */
    height: 45px;
     position: fixed;
    top: 0;
    width: 100%;
}

.menubar img {
    height: 40px; /* Adjust height of logo */
    width: 40px;
    border-radius: 20px;
    background-color: none;
}

.menubar h2 {
    margin: 0;
    color: #333; /* Dark text color */
}

.menubar a {
    color: #333; /* Dark text color for links */
    text-decoration: none; /* Remove underline */
    font-weight: bold; /* Bold font for links */
}

.menubar .auth-links {
    display: flex; /* Flexbox for login and signup links */
    margin-left: 100px;
    margin-right:50px;
}

.menubar .auth-links a {
	padding-left: 20px;
    margin: 0; /* Remove margin for auth links */
}

.menubar .separator {
    margin: 0 5px; /* Space around the separator */
    color: #333; /* Dark text color for separator */
}

.menubar #profile {
    padding-top: 0px;
    text-align: center;
    height: 40px;
    width: 40px;
    border-radius: 38px;
    background-color: white;

}
.menubar .hc1{
	font-size:15px;
	margin-left: 20px;
}

.menubar .hc{
	font-size:16px;
}

.menubar a:hover {
    color: red; /* Change color on hover */
}
.menubar #logout{
	margin-right: 20px;
}

.menubar #logout:hover{
	transition: 0.2s;
	font-size: 13px;
}


/* After menu bar page style*/

    
    .card-container {
        display: flex;
        flex-wrap: wrap;
        gap: 20px;
        margin-top: 20px;
        width: 100%;
        padding: 0 20px;
        margin-left: 80px
    }
    .card {
        background-color: #ffffff;
        border: 1px solid #ddd;
        border-radius: 8px;
        width: 250px;
        padding: 20px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        text-align: center;
        margin-left: 8px;
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
        background-color: blue;
    }
    .button2 {
        background-color: rgb(15, 155, 5);
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
User user = (User) session.getAttribute("user");
%>
<%
String userId = (String) session.getAttribute("userid");

session.setAttribute("user", user);
session.setAttribute("userid", userId);
%>
<% if(user != null) { %>
<div class="menubar">
        <a href="homeUser.jsp" class="hc1">Home</a>
        <h2>Menu Items</h2>
        <a href="addToCart.jsp?userEmail=<%= userId%>"><img src="https://png.pngtree.com/png-clipart/20190705/original/pngtree-vector-cart-icon-png-image_4292658.jpg" alt="Cart Not Found"></a>
        <a href="orderHistory.jsp?userEmail=<%= userId %>" style="text-decoration : none">Order History</a>
        <a href="profile.jsp" id="profile"><img src="https://www.pngarts.com/files/10/Default-Profile-Picture-Transparent-Image.png" alt="Image Not Found"></a>
        <a href="homeLogin.jsp" id="logout">Logout</a>
</div>
<div class="card-container">
<%
if(menuList != null) {
    for(Menu m : menuList) {
%>
    <div class="card">
    	<img src="<%= m.getItemImage() %>" alt="Image Not Found" height="150px" width="250px">
        <h5>Item ID : <%= m.getMenu_id() %></h5>
        <h4><%= m.getMenu_name() %></h4>
        <p class="price">₹<%= m.getPrice() %></p>
        <p class="availability"><%= m.getIsavailable() ? "Available" : "Not Available" %></p>
        <p class="description"><%= m.getDescription() %></p>

        <!-- Add to Cart form with Quantity -->
        <form action="PutToCartByMenuId" method="post">
            <input type="hidden" name="menuId" value="<%= m.getMenu_id() %>">
            <input type="hidden" id="itemName" name="itemName" value="<%= m.getMenu_name() %>">
            <input type="hidden" name="price" value="<%= m.getPrice() %>">
            <input type="hidden" name="act" value="add">
            <input type="number" name="quantity" value="1" min="1">
            <input type="submit" onclick="addCart()" value="Add to Cart" class="button1">
            
            <script>
            	var itemName = document.getElementById("itemName");
    			var btn = document.getElementByClass("button1")
    			function addCart(){
    				alert("The Item is Added To Cart");
    			}
    		</script>
            
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
