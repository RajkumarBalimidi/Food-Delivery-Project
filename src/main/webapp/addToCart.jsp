<%@ page session="true" %>
<%@ page import="com.tap.foodapp.impl.CartItemDAOImpl, com.tap.foodapp.model.CartItem,com.tap.foodapp.model.Menu" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Your Cart</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(to bottom, #f4f4f4, #e2e2e2);
            margin: 0;
            padding: 0;
        }
        .container {
            margin: 50px auto;
            padding: 20px;
            background: #fff;
            border-radius: 8px; /* Rounded corners */
            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);
        }
        h1 {
            text-align: center;
            margin-bottom: 20px;
            color: #333;
        }
        .cart-card {
            border: 1px solid #ddd;
            border-radius: 8px;
            padding: 15px;
            background-color: white;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            transition: box-shadow 0.3s, transform 0.3s;
            margin-bottom: 20px; /* Space between cards */
        }
        .cart-card:hover {
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.3);
            transform: translateY(-5px);
        }
        .cart-card img {
            max-width: 100%; /* Responsive image */
            height: auto;
            border-radius: 8px; /* Rounded image corners */
        }
        .cart-total {
            font-size: 1.5em;
            color: #333;
        }
        .cart-actions .btn {
            text-decoration: none;
            margin: 5px;
            padding: 10px 20px;
            border-radius: 5px;
            transition: background-color 0.3s;
        }
        .cart-actions .btn:hover {
            background-color: #0056b3;
            color: white;
        }
        .checkout-btn {
            background-color: #28a745; /* Green for checkout */
        }
        .checkout-btn:hover {
            background-color: #218838;
        }
        /* Animation for empty cart message */
        .empty-cart {
            text-align: center;
            font-size: 1.2em;
            margin-top: 20px;
            opacity: 0;
            animation: fadeIn 1s forwards; /* Fade in animation */
        }
        @keyframes fadeIn {
            from { opacity: 0; }
            to { opacity: 1; }
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Your Cart</h1>
        <%
        	Menu menu=new Menu();
            CartItem cart = (CartItem) session.getAttribute("cart");
            if (cart != null && cart.getItems() != null && !cart.getItems().isEmpty()) {
        %>
        <div class="row">
            <%
                double total = 0;
                for (CartItem item : cart.getItems().values()) {
                    double itemTotal = item.getQuantity() * item.getPrice();
                    total += itemTotal;
            %>
            <div class="col-md-4">
                <div class="cart-card">
                    <h3><%= item.getMenuName() %></h3>
                    <p class="price">Price: Rs <%= String.format("%.2f", item.getPrice()) %></p>
                    <p class="total">Total: Rs <%= String.format("%.2f", itemTotal) %></p>
                    <form action="Cart" method="post" style="display:inline-block;">
                        <input type="hidden" name="itemId" value="<%= item.getMenuId() %>">
                        <input type="number" name="quantity" value="<%= item.getQuantity() %>" min="1" class="form-control" style="width: 100px; display: inline-block;">
                        <input type="hidden" name="act" value="update">
                        <button type="submit" class="btn btn-primary">Update</button>
                    </form>
                    <form action="Cart" method="post" style="display:inline-block;">
                        <input type="hidden" name="itemId" value="<%= item.getMenuId() %>">
                        <input type="hidden" name="act" value="remove">
                        <button type="submit" class="btn btn-danger">Remove</button>
                    </form>
                </div>
            </div>
            <% } %>
        </div>
        <div class="cart-total text-right">
            <h3>Total: Rs <%= String.format("%.2f", total) %></h3>
        </div>
        <%
            } else {
        %>
        <p class="empty-cart">Your cart is empty. Start shopping now!</p>
        <%
            }
        %>
        <div class="cart-actions text-center">
            <a href="menu.jsp" class="btn btn-secondary">Continue Shopping</a>
            <a href="checkout.jsp" class="btn checkout-btn">Proceed to Checkout</a>
        </div>
    </div>
    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>