<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.tap.foodapp.model.Restaurant,com.tap.foodapp.dao.RestaurantDAO,com.tap.foodapp.impl.RestaurantDAOImpl, java.util.ArrayList" %> 

 
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
    background-color: rgb(205, 126, 7);
}

.menubar {
    display: flex;
    align-items: center;
    justify-content: space-between;
    background-color: #12ccf6; /* Light yellow background */
    padding: 10px 20px; /* Padding around the items */
    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1); /* Subtle shadow effect */
    height: 30px;
}

.menubar img {
    height: 40px; /* Adjust height of logo */
    width: 40px;
    border-radius: 20px;
    background-color: orange;
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
}

.menubar .auth-links a {
    margin: 0; /* Remove margin for auth links */
}

.menubar .separator {
    margin: 0 5px; /* Space around the separator */
    color: #333; /* Dark text color for separator */
}

.menubar a:hover {
    color: #ff6600; /* Change color on hover */
}
	
.container {
    max-width: 1200px; /* Max width for the container */
    margin: 0 auto; /* Center the container */
    padding: 10px; /* Padding around the container */
    display: flex; /* Flexbox layout */
    flex-wrap: wrap; /* Allow cards to wrap */
    gap: 20px; /* Space between cards */
}

h2 {
    text-align: center; /* Center the heading */
    color: blue; /* Set heading color to blue */
    margin-bottom: 20px; /* Space below the heading */
}
#show {
    text-align: center; /* Center the heading */
    color: black; /* Set heading color to blue */
    margin-bottom: 20px; /* Space below the heading */
    font-size: medium;
    font-weight: bold;
    background-color: rgb(18, 236, 6);
    height:30px;
    width:200px;
    margin-left: 42%;
    border-radius: 3px;
	
}


.card {
    background-color: #ffffff; /* White background for cards */
    border: 1px solid #ddd; /* Light gray border */
    border-radius: 8px; /* Rounded corners */
    padding: 10px; /* Inner padding */
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1); /* Shadow effect */
    transition: transform 0.2s; /* Transition for hover effect */
    width: 300px; /* Fixed width for cards */
    height: 380px; /* Fixed height for cards */
    overflow: hidden; /* Prevent overflow of text */
    padding-left: 10px;
    margin-left: 40px;
    margin-right:3px;
    margin-bottom:20px;
    text-align: center;
}

.card:hover {
    transform: scale(1.02); /* Slightly enlarge card on hover */
}

.card b {
    color: #333; /* Dark gray color for bold text */
}

.card p {
    margin: 5px 0; /* Space between paragraphs */
}
.card a .viewmenu,.edit,.delete{
	font-size: 9px;
	height:25px;
	width: 70px;
	border-radius: 4px;
	justify-content: space-evenly;
	
}
.card a .viewmenu{
	
	color: white;
	background-color: rgb(61, 67, 233);
}
.card a .viewmenu:hover{
	color: white;
	background-color: blue;
}
.card .edit{
	margin-left: 30px;
	color: white;
	background-color: green;
}
.card .edit:hover{
	background-color: rgb(17, 180, 11);
}
.card .delete{
	margin-left: 30px;
	color: white;
	background-color: red;
}
.card .delete:hover{
	background-color: rgb(226, 0, 0);
}

				
	</style>

</head>
<body>

	<% Restaurant res = (Restaurant) session.getAttribute("RestaurantAdmin"); 
	if(res != null)
    {
	%>
    <div class="menubar">
        <img src="https://static.vecteezy.com/system/resources/previews/018/867/174/non_2x/chili-pepper-on-fire-free-png.png" alt="Image Not Found">
        <h2>Hi <%= res.getResname()%> ! Welcome to the Restaurants</h2>
        <div class="auth-links">
            <a href="adminLogin.jsp" id="login">Logout</a>
        </div>
    </div><br>
    <%session.setAttribute("AdminId", res.getAdminid()); %>
    
   	<%!
   			RestaurantDAO rdao = new RestaurantDAOImpl();
			ArrayList<Restaurant> restaurant;
			String resname;
			
	%>
    <a href="createAdminAccount.jsp"><button id="show">Add Restaurant</button></a><br>
    <div class="container">
    <%
    resname = res.getResname();
    restaurant = (ArrayList<Restaurant>) rdao.getAllRestaurants();
    
    if (restaurant != null) {
        for (Restaurant r : restaurant) {
    %>
        <div class="card">
            <img src="<%= r.getResImage() %>" height="200px" width="300px"><br>
            <b>Restaurant ID :</b> <%= r.getResid() %><br>
            <b>Name :</b> <%= r.getResname() %><br>
            <b>Address :</b> <%= r.getAddress() %><br>
            <b>Rating :</b> <%= r.getRating() %><br>
            <b>IsActive :</b> <%= r.getIsactive() %><br>
            <b>Cuisine Type :</b> <%= r.getCuisinetype() %><br>
            <br>
            <a href="GetParticularRestaurantIdByMenu?Id=<%= r.getResid()%>"><button class="viewmenu">VIEW MENU</button></a>
            <a href="editRestaurantDetailsLoginId?id=<%= r.getResid()%>"><button class="edit">EDIT</button></a>
            <a href="deleteRestaurantPerimission?Id=<%= r.getResid()%>"><button class="delete">DELETE</button></a>
        </div>
    <%
        }
    } 
    	else 
    	{
    	    out.println("No Restaurants Found");
    	}%>
    	<%
    }
    else
    {
    	response.sendRedirect("adminRestaurantHome.jsp");
    }
    %>
</div>

</body>
</html>