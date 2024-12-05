<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List, com.tap.foodapp.model.OrderHistory, com.tap.foodapp.dao.OrderHistoryDAO,
 com.tap.foodapp.impl.OrderHistoryDAOImpl, com.tap.foodapp.model.Menu, com.tap.foodapp.dao.MenuDAO,
 com.tap.foodapp.impl.MenuDAOImpl" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order History</title>
<style>
     /* Add padding to the top of the body to prevent overlap with the fixed header */
    body {
        padding: 0px; /* Adjust this value based on header height */
        margin:0px;
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


  

    /* Container for all the cards */
    .card-container {
        display: flex;
        flex-wrap: wrap;
        gap: 30px;
        padding: 20px;
        border: 1px solid green;
        margin-top: 20px;
    }

    /* Individual card styling */
    .order-card {
    	text-align: center;
        background-color: #f9f9f9;
        border-radius: 8px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        padding: 12px;
        width: 270px;
        box-sizing: border-box;
        border: 1px solid white;
        transition: transform 0.3s;
        margin-bottom :10px;
        margin-left :50px;
        
    }
    
    .order-card:hover {
        transform: scale(1.02);
    }

    /* Styling for the content inside each card */
    .order-card b {
        color: #333;
        display: inline-block;
        margin-bottom: 5px;
        font-weight: 600;
    }

    .order-card p {
        margin: 0;
        color: #555;
        margin-bottom: 10px;
        font-size: 14px;
    }
    .order-card a{
    	text-decoration: none;
    	border: 1px solid black;
    	border-radius: 3px;
    	font-size: 15px;
    	padding : 8px;
    	color: white;
    	background-color: blue;
    }
    .order-card a:hover
    {
    	background-color: green;
    }

    /* Responsive styling for smaller screens */
    @media (max-width: 768px) {
        .order-card {
            width: 45%; /* Two cards per row on small screens */
        }
    }

    @media (max-width: 480px) {
        .order-card {
            width: 100%; /* One card per row on very small screens */
        }
    }

    /* Message styling */
    .no-orders-message {
        text-align: center;
        color: #555;
        font-size: 18px;
        margin-top: 20px;
    }
</style>
</head>
<body>

<%
String userEmail = request.getParameter("userEmail");
OrderHistoryDAO ohdao = new OrderHistoryDAOImpl();
List<OrderHistory> ordHisList = ohdao.fetchOrderHistoryByUserId(userEmail);
%>

<div class="menubar">
        <a href="homeUser.jsp" class="hc1">Home</a>
        <h2>Your Order History</h2>
        <a href="addToCart.jsp?userEmail=<%= userEmail%>"><img src="https://png.pngtree.com/png-clipart/20190705/original/pngtree-vector-cart-icon-png-image_4292658.jpg" alt="Cart Not Found"></a>
        <a href="orderHistory.jsp?userEmail=<%= userEmail %>" style="text-decoration : none">Order History</a>
        <a href="profile.jsp" id="profile"><img src="https://www.pngarts.com/files/10/Default-Profile-Picture-Transparent-Image.png" alt="Image Not Found"></a>
        <a href="homeLogin.jsp" id="logout">Logout</a>
</div>

<div class="card-container">
<%
if (ordHisList == null || ordHisList.isEmpty()) {
%>
    <div class="no-orders-message">You have no order history.</div>
<%
} else {
    for(OrderHistory ohl : ordHisList) {
%>
    <div class="order-card">
    
    <%
    MenuDAO mdao = new MenuDAOImpl();
    Menu mid = mdao.getMenuById(ohl.getMenuId());
    String mimg = mid.getItemImage();
    %>
    	<img src="<%= mimg%>" alt="Image Not Found" height="150px" width="250px">
     
        <b>Item Name:</b> <%= ohl.getMenuName() %><br>
        
        <b>Payment Type:</b> <%= ohl.getPaymentType() %><br>
        
        <b>Order Status:</b> <%= ohl.getOrderStatus() %><br><br>
        
        <a href="viewHisDetails.jsp?ohid=<%= ohl.getOrderHistoryId()%>">View Details</a><br>
    </div>
<%
    }
}
%>
</div>

</body>
</html>
