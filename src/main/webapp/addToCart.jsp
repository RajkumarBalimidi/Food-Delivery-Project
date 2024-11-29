<%@ page session="true" %>
<%@ page import="java.util.List, com.tap.foodapp.impl.CartDAOImpl,com.tap.foodapp.dao.CartDAO,
 com.tap.foodapp.model.Cart, com.tap.foodapp.model.Menu,
 com.tap.foodapp.impl.MenuDAOImpl,com.tap.foodapp.dao.MenuDAO, com.tap.foodapp.model.User" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cart Items</title>
    
<style>
/* General Styles */
body {
    font-family: Arial, sans-serif;
    background-color: #f4f4f9;
    margin: 0;
    padding: 0px;
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

/* Cart Container */
.cart-container {
    display: flex;
    flex-wrap: wrap;
    gap: 20px;
    justify-content: left;
    padding: 30px;
    padding-top: 100px;
}

/* Individual Card */
.cart-card {
    background-color: #fff;
    border-radius: 10px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
    width: 300px;
    overflow: hidden;
    transition: transform 0.2s ease-in-out;
    text-align: left;
    padding: 20px;
    margin-right: 25px;
    margin-bottom: 20px;
}

/* Card Hover Effect */
.cart-card:hover {
    transform: scale(1.05);
}

/* Card Image */
.cart-card img {
    width: 100%;
    height: 200px;
    object-fit: cover;
    border-bottom: 1px solid #ddd;
}

/* Card Content */
.cart-card .card-content {
    padding: 10px 20px;
    color: #333;
}

/* Labels and Inputs */
.cart-card label {
    font-weight: bold;
    margin: 10px 0;
    float: left;
    width: 50%;
    text-align: left;
}

.cart-card input[type="text"], 
.cart-card input[type="number"] {
    margin-bottom: 10px;
    width: 45%;
    height: 25px;
    border-radius: 3px;
    text-align: center;
    float: right;
}

input[readonly] {
    background-color: #e9ecef;
}

/* Buttons */

.cart-card .remove {
    color: white;
    background-color: green;
    height: 35px;
    width: 45px;
    font-size: 10px;
    border-radius: 3px;
    border: none;
    cursor: pointer;
    margin: 0px;
    margin-top: 150px;
    margin-left: 0px;
    padding: 5px;;
    text-align: center;
    justify-content: center;
}

/* Remove Button */
.cart-card .remove {
    background-color: red;
    margin-right: 100px;
}
.cart-card .order{
    color: white;
    background-color: green;
    height: 35px;
    width: 80px;
    border-radius: 3px;
    border: none;
    cursor: pointer;
    margin: 0px;
    margin-top: 150px;
    
    text-align: left;
    
}
/* Hover Effects */
.cart-card .order:hover, 
.cart-card .remove:hover {
    background-color: blue;
}

/* Button Alignment: Side by Side */
.cart-card .button-container {
    display: flex;
    justify-content: center;
    margin-top: 10px;
}


</style>
    
</head>
<body>
   <%
   		User user = (User) session.getAttribute("user");
		String userEmail = request.getParameter("userEmail");
        CartDAO cdao = new CartDAOImpl();
        List<Cart> cartList = (List<Cart>) cdao.getCartByUserId(userEmail);
        
        session.setAttribute("user", user);
        session.setAttribute("userid", userEmail);
   %>
<div class="menubar">
        <a href="homeUser.jsp" class="hc1">Home</a>
        <h2>Your Cart Items</h2>
        <a href="addToCart.jsp?userEmail=<%= userEmail%>"><img src="https://png.pngtree.com/png-clipart/20190705/original/pngtree-vector-cart-icon-png-image_4292658.jpg" alt="Cart Not Found"></a>
        <a href="orderHistory.jsp?userEmail=<%= userEmail %>" style="text-decoration : none">Order History</a>
        <a href="profile.jsp" id="profile"><img src="https://www.pngarts.com/files/10/Default-Profile-Picture-Transparent-Image.png" alt="Image Not Found"></a>
        <a href="homeLogin.jsp" id="logout">Logout</a>
</div>
<div class="cart-container">
   <%
   	for(Cart c : cartList) {
            int menuId = c.getMenuId();
            MenuDAO mdao = new MenuDAOImpl();
            Menu mid = mdao.getMenuById(menuId);
            
    %>
    <div class="cart-card">
        <img src="<%= mid.getItemImage() %>" alt="Menu Item">
        <div class="card-content">
        <form action="OrderItemByMenuID" method="post">
            <label>Cart ID : </label>
            <input type="text" name="cartId" value="<%out.println(c.getCartId()); %>" readonly><br>
        
            <label>Menu ID : </label>
            <input type="text" name="menuid" value="<%out.println(c.getMenuId()); %>" readonly><br>
            <label>Menu Name : </label>
            <input type="text" name="menuName" value="<%out.println(c.getMenuName()); %>" readonly><br>
            <label>Price(For 1 Item) : </label>
            <input type="text" value="<%out.println(c.getPrice()); %>" readonly><br>
            <label>Quantity : </label>
            <input type="number" name="quantity" value="<%= c.getQuantity() %>" min="1"><br>
           
		     <div class="button-container">
		    	<a href="RemoveCartItem?cid=<%= c.getCartId() %>">
		        <input class="remove" type="button" value="Remove">
		    	</a>
		    	<input class="order" type="submit" value="Order">
			</div>

        </form> 
            
        </div>
    </div>
    
   <%
   	} 
   %>
</div>

</body>
</html>