<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.tap.foodapp.model.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile</title>

<style>
	body {
    font-family: Arial, sans-serif;
    background-color: #f4f4f4;
    margin: 0;
    padding: 0;
}

.menubar {
    display: flex;
    align-items: center;
    justify-content: space-between;
    background-color: #0056b3; /* Blue background */
    color: white;
    padding: 0 20px; /* Horizontal padding */
    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1); /* Subtle shadow effect */
    height: 50px; /* Fixed height for the menubar */
    position: fixed; /* Stays fixed at the top */
    top: 0;
    width: 100%;
    z-index: 1000; /* Stays on top of other elements */
}

.menubar .hc1{
	color: white;
    text-decoration: none;
    font-weight: bold;
    font-size: 16px;
    padding: 10px 15px;
    border-radius: 5px;
    transition: background-color 0.3s ease;
}
.menubar #logout{
	color: white;
    text-decoration: none;
    font-weight: bold;
    font-size: 16px;
    padding: 10px 15px;
    border-radius: 5px;
    transition: background-color 0.3s ease;
     margin-right: 4%;
}

.menubar a:hover {
    background-color: #004080; /* Darker blue on hover */
}

.container {
    margin-top: 100px; /* To adjust for the fixed menubar */
    max-width: 400px;
    margin: 100px auto; /* Center the container */
    padding: 20px;
    background-color: #ffffff; /* White background for contrast */
    border-radius: 8px; /* Rounded corners */
    box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1); /* Subtle shadow for elevation */
}

.container h2 {
    margin: 0;
    padding: 10px;
    background-color: green; /* Blue header background */
    color: white;
    text-align: center;
    border-radius: 8px 8px 0 0; /* Rounded top corners only */
}

.container label {
    font-weight: bold;
    display: block;
    margin: 10px 0 5px;
    color: #333;
}

.container input[type="text"],
.container input[type="email"] {
    width: 100%;
    padding: 10px;
    margin-bottom: 15px;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
    background-color: #f9f9f9; /* Light background for inputs */
    font-size: 14px;
}

.container input[readonly] {
    background-color: #e9ecef; /* Slightly darker for readonly inputs */
    cursor: not-allowed;
}

.container input[type="text"]:focus,
.container input[type="email"]:focus {
    border-color: #007bff; /* Blue border on focus */
    outline: none;
    background-color: #ffffff; /* White background on focus */
}

.container .button {
    background-color: blue; /* Primary blue button */
    color: white;
    border: none;
    border-radius: 4px;
    padding: 10px 15px;
    cursor: pointer;
    font-size: 16px;
    font-weight: bold;
    transition: background-color 0.3s ease;
    display: block;
    width: 100%; /* Full width button */
    text-align: center;
}

.container .button:hover {
    background-color: green; /* Darker blue on hover */
}

@media (max-width: 600px) {
    .container {
        padding: 15px;
        margin: 20px;
    }

    .menubar a {
        font-size: 14px;
        padding: 8px 10px;
    }

    .container h2 {
        font-size: 18px;
    }
}


</style>

</head>
<body>
	
	<div class="menubar">
        <a href="homeUser.jsp" class="hc1">Home</a>
        
        <a href="homeLogin.jsp" id="logout">Logout</a>
	</div>

	<div class="container">
	<form action="UpdateProfile" method="post">
	
	<%User u = (User)session.getAttribute("user"); %>
		<h2><%out.println(u.getName());%> Details</h2>
		<label>Full Name : </label>
		<input type="text" name="name" value="<%out.println(u.getName());%>" readonly><br>
		<label>Email : </label>
		<input type="email" name="email" value="<%out.println(u.getEmail());%>" readonly><br>
		<label>Address : </label>
		<input type="text" name="address" value="<%out.println(u.getAddress());%>"><br>
		<label>Mobile Number : </label>
		<input type="text" name="mobilenumber" value="<%out.println(u.getPhonenumber());%>" readonly><br>
		<label>Occupation / Role : </label>
		<input type="text" name="role" value="<%out.println(u.getRole());%>"><br>
		
        <input class="button" type="submit" value="update">
	</form>
	</div>
	
	
</body>
</html>