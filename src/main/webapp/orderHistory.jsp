<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.List, com.tap.foodapp.model.OrderHistory, com.tap.foodapp.dao.OrderHistoryDAO, com.tap.foodapp.impl.OrderHistoryDAOImpl" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order History</title>
<style>
    /* Style for the header */
    h1 {
        color: white;
        background-color: blue;
        text-align: center;
        padding: 10px;
        width: 100%;
        margin: 0;
    }

    /* Container for all the cards */
    .card-container {
        display: flex;
        border : 1px solid balck;
        flex-wrap: wrap;
        gap: 50px;
        padding: 25px;
    }

    /* Individual card styling */
    .order-card {
        background-color: #fff;
        border-radius: 8px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        padding: 20px;
        height : 300px;
		width : 260px;
        box-sizing: border-box;
        border : 1px solid black;
        margin-bottom :10px;
        margin-left :15px;
    }
    
    .order-card:hover {
    transform: scale(1.02); /* Slightly enlarge card on hover */
    transition: 0.2s;
}
    

    /* Styling for the content inside each card */
    .order-card b {
        color: #333;
        padding-bottom : 10px;
    }

    .order-card p {
        margin: 0;
        color: #555;
        margin-bottom: 10px;
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
</style>
</head>
<body>

<h1>Your Order History</h1>

<div class="card-container">
<%
String userEmail = request.getParameter("userEmail");

OrderHistoryDAO ohdao = new OrderHistoryDAOImpl();
List<OrderHistory> ordHisList = ohdao.fetchOrderHistoryByUserId(userEmail);

for(OrderHistory ohl : ordHisList)
{
%>
    <div class="order-card">
        <b>Order ID:</b> <%= ohl.getOrderId() %><br>
        <b>Menu ID:</b> <%= ohl.getMenuId() %><br>
        <b>Restaurant Name:</b> <%= ohl.getRestaurantName() %><br>
        <b>Item Name:</b> <%= ohl.getMenuName() %><br>
        <b>Quantity:</b> <%= ohl.getQuantity() %><br>
        <b>Total Price:</b> <%= ohl.getTotalAmount() %><br>
        <b>Payment Type:</b> <%= ohl.getPaymentType() %><br>
        <b>Ordered Address :</b> <%= ohl.getOrderedAddress() %><br>
        <b>Order Status:</b> <%= ohl.getOrderStatus() %><br>
    </div>
<%	
}
%>
</div>

</body>
</html>
