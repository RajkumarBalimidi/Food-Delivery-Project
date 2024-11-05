<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile Update</title>
<style>
	body {
    font-family: Arial, sans-serif;
    background-color: #f4f4f4;
    margin: 0;
    padding: 20px;
}

div {
    background-color: #fff;
    border-radius: 8px;
    box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
    padding: 20px;
    max-width: 400px;
    margin: 0 auto;
    text-align: center;
}

h2 {
    color: #4CAF50;
}

p {
    color: #555;
}

input[type="submit"] {
    background-color: #4CAF50;
    color: white;
    border: none;
    border-radius: 5px;
    padding: 10px 20px;
    cursor: pointer;
    font-size: 16px;
}

input[type="submit"]:hover {
    background-color: #45a049;
}
	
</style>
</head>
<body>

	<div>
	<h2>Successfully Updated Your Profile</h2>
	<p>Your profile is updated.If your updated profile did't get close the website and Re-open it.</p><br>
	<% request.setAttribute("user", session.getAttribute("user")); %>
	<a href="homeUser.jsp"><input type="submit" value="OK"></a>
	</div>
</body>
</html>