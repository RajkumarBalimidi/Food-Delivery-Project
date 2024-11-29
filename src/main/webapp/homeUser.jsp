<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.tap.foodapp.model.User" %>
<%@ page import="com.tap.foodapp.model.Restaurant,com.tap.foodapp.dao.RestaurantDAO,com.tap.foodapp.impl.RestaurantDAOImpl, java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home Page</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css" integrity="sha512-Kc323vGBEqzTmouAECnVceyQqyqdsSiqLQISBL29aUW4U/M7pSPA/gEUZQqv1cwx4OnYxTxve5UMg5GT6L4JJg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
	
	<style>
		
	
@charset "UTF-8";

body {
    margin: 0;
    font-family: Arial, sans-serif;
    background-color: #ffff;
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
	font-size:14px;
}

.menubar .hc{
	font-size:16px;
}

.menubar a:hover {
    color: red; /* Change color on hover */
}
.menubar #logout{
	margin-right:20px;
}

.menubar #logout:hover{
	transition: 0.2s;
	font-size: 13px;
}


/* After menu bar page style*/

/* Container Styles */
.container{
    max-width: 1200px; /* Max width for the container */
    margin: 0 auto; /* Center the container */
    padding: 20px; /* Padding around the container */
    display: flex; /* Flexbox layout */
    flex-wrap: wrap; /* Allow cards to wrap */
    gap: 20px; /* Space between cards */
    margin-left : 50px;
}

#show {
    text-align: center; /* Center the heading */
    color: black; /* Set heading color to blue */
    margin-top: 100px;
    background-color: rgba(39, 225, 10, 0.936);
    height:40px;
    width:300px;
    margin-left: 40%;
    padding-top:13px;
    border-radius: 10px;
	
}

/* Card Styles */

.card {
	
    background-color: #ffffff; /* White background for cards */
    border: 1px solid #ddd; /* Light gray border */
    border-radius: 8px; /* Rounded corners */
    padding: 10px; /* Inner padding */
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1); /* Shadow effect */
    transition: transform 0.2s; /* Transition for hover effect */
    width: 300px; /* Fixed width for cards */
    height: 400px; /* Fixed height for cards */
    overflow: hidden; /* Prevent overflow of text */
    padding-left: 10px;
    margin-left: 35px;
    margin-bottom: 20px;
    text-align: center;
    
}

.card:hover {
    transform: scale(1.02); /* Slightly enlarge card on hover */
    background : blur;
}

.card b {
    color: #333; /* Dark gray color for bold text */
}

.card p {
    margin: 5px 0; /* Space between paragraphs */
}
.card a button{
	font-size: medium;
	height:40px;
	width: 125px;
	border-radius: 4px;
	color: white;
	background-color: rgb(61, 67, 233);
}
.card a button:hover{
	color: white;
	background-color: blue;
	transition: 0.2s;
	height: 45px;
	width: 130px;
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
	<%
	User u = (User)session.getAttribute("user");
	String userId = (String) session.getAttribute("userid");
	%>
	<% if(u != null){ %>
    <div class="menubar">
        <img src="https://static.vecteezy.com/system/resources/previews/018/867/174/non_2x/chili-pepper-on-fire-free-png.png" alt="Image Not Found">
        <a href="index.html" class="hc1">ABOUT US</a>
        <h2>Hi <%out.println(u.getName());%>! Welcome to the Restaurants</h2>
        <a href="addToCart.jsp?userEmail=<%= userId%>"><img src="https://png.pngtree.com/png-clipart/20190705/original/pngtree-vector-cart-icon-png-image_4292658.jpg" alt="Cart Not Found"></a>
        <a href="orderHistory.jsp?userEmail=<%= userId %>" style="text-decoration : none">Order History</a>
        <a href="contactUs.html" class="hc">Contact us</a>
        <a href="profile.jsp" id="profile"><img src="https://www.pngarts.com/files/10/Default-Profile-Picture-Transparent-Image.png" alt="Image Not Found"></a>
        <a href="homeLogin.jsp" id="logout">Logout</a>
    </div>
    
	<%
	session.setAttribute("user", u);
	session.setAttribute("userid", session.getAttribute("userid"));
	
	%>
     
       	<%!
   			RestaurantDAO rdao = new RestaurantDAOImpl();
			ArrayList<Restaurant> restaurant;
			
	%>
    <h2 id="show">All Restaurants List</h2><br>
    <div class="container">
    <%
    restaurant = (ArrayList<Restaurant>) rdao.getAllRestaurants();
    if (restaurant != null) {
        for (Restaurant r : restaurant) {
    %>
        <div class="card">
        	<img src="<%= r.getResImage() %>" height="200px" width="100%"><br><br>
            <b>Restaurant ID :</b> <%= r.getResid() %><br>
            <b>Name :</b> <%= r.getResname() %><br>
            <b>Address :</b> <%= r.getAddress() %><br>
            <b>Rating :</b> <%= r.getRating() %><br>
            <b>IsActive :</b> <%= r.getIsactive() %><br>
            <b>Cuisine Type : </b><%= r.getCuisinetype() %><br><br>
            <a href="GetParticularRestaurantIdUser?Id=<%= r.getResid()%>"><button>View Menu</button></a>
        </div>
        
    <%
        }
    %>    
      <script>
        	alert("If you are a New User the Add To Cart of your first item will not be added (or) Displayed. Remind it as you are New User.")
        </script>  
    <%    
    } else {
        out.println("No Restaurants Found");
    }
    %>
</div>

    <%}
	else{
		response.sendRedirect("homeLogin.jsp");
	}
	%>
	
	
</body>
</html>