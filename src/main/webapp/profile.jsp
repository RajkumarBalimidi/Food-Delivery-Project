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
    padding: 20px;
}

div {
    max-width: 400px;
    margin: 0 auto;
    padding: 20px;
    background-color: #fff;
    border-radius: 8px;
    box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
}

h2 {
	margin-top:10px;
	padding-top: 10px;
	background-color: #0056b3;
    text-align: center;
    color: white;
    height: 45px;
}

label {
    font-weight: bold;
    display: block;
    margin: 10px 0 5px;
}

input[type="text"],
input[type="email"] {
    width: 100%;
    padding: 10px;
    margin-bottom: 15px;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
}

input[readonly] {
    background-color: #e9ecef;
}

input[type="text"]:focus,
input[type="email"]:focus {
    border-color: #007bff;
    outline: none;
}

.button {
    background-color: #007bff;
    color: white;
    border: none;
    border-radius: 4px;
    padding: 10px 15px;
    cursor: pointer;
    margin-top: 10px;
}

.button:hover {
    background-color: blue;
}


@media (max-width: 600px) {
    div {
        padding: 15px;
    }
    
    h2 {
        font-size: 24px;
    }
}


</style>

</head>
<body>
	<form action="UpdateProfile" method="post">
	<div>
	
	<%User u = (User)session.getAttribute("user"); %>
		<h2><%out.println(u.getName());%> Details</h2>
		<label>Full Name : </label>
		<input type="text" name="name" value="<%out.println(u.getName());%>"><br>
		<label>Email : </label>
		<input type="email" name="email" value="<%out.println(u.getEmail());%>" readonly><br>
		<label>Address : </label>
		<input type="text" name="address" value="<%out.println(u.getAddress());%>"><br>
		<label>Mobile Number : </label>
		<input type="text" name="mobilenumber" value="<%out.println(u.getPhonenumber());%>" readonly><br>
		<label>Occupation / Role : </label>
		<input type="text" name="role" value="<%out.println(u.getRole());%>"><br>
		
        <input class="button" type="submit" value="update">
	</div>
	</form>
	
	
</body>
</html>