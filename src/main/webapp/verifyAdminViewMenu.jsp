<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Verify Account View Menu</title>
<style>
    body {
        font-family: Arial, sans-serif; /* Sets a font for the body */
        background-color: #f4f4f4; /* Light background color */
        margin: 0; /* Resets default margin */
        padding: 20px; /* Adds padding around the body */
    }

    div {
        border: 2px solid #333; /* Dark border */
        padding: 8px 15px 25px 15px; /* Space inside the border */
        border-radius: 10px; /* Rounded corners */
        width: 300px; /* Fixed width */
        margin: 120px 0px 0px 450px; /* Centers the div */
        background-color: #fff; /* White background for the div */
        box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1); /* Adds a subtle shadow */
    }

    h2 {
        text-align: center; /* Centers the heading */
        color: #333; /* Dark color for the heading */
    }

    input[type="email"],
    input[type="password"] {
        width: 100%; /* Full width */
        padding: 10px; /* Padding inside the input */
        margin: 12px 0; /* Space between inputs */
        border: 2px solid #ccc; /* Light border */
        border-radius: 5px; /* Slightly rounded corners */
        box-sizing: border-box; /* Ensures padding is included in total width */
    }

    input[type="submit"] {
        background-color: #28a745; /* Green background */
        color: white; /* White text */
        border: none; /* No border */
        padding: 10px; /* Padding inside the button */
        border-radius: 5px; /* Slightly rounded corners */
        cursor: pointer; /* Pointer cursor on hover */
        width: 100%; /* Full width */
        transition: background-color 0.3s; /* Smooth transition for hover effect */
        margin-top: 20px;
    }

    input[type="submit"]:hover {
        background-color: #218838; /* Darker green on hover */
    }
</style>
</head>
<body>
	
	<%session.setAttribute("restaurantId", session.getAttribute("restaurantId"));%>
	 <div>
        <h2>Verify Account</h2>
        <form action="GetParticularRestaurantIdByAdmin">
        <input type="email" name="email" placeholder="Username" required><br>
        <input type="password" name="password" placeholder="Password" required><br>
        <input type="submit" value="Submit">
        </form>
    </div>
	
</body>
</html>