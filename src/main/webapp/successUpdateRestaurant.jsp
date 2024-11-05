<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	body {
    font-family: Arial, sans-serif;
    background-color: #f0f8ff;
    color: #333;
    text-align: center;
    margin: 0;
    padding: 50px;
}

div {
    background-color: white;
    padding: 20px;
    margin-left: 500px;
    margin-top: 100px;
    border-radius: 8px;
    box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
    text-align: center;
    width: 300px;
}

h2 {
    margin-bottom: 20px;
}

button {
    background-color: #4CAF50; /* Green */
    color: white;
    border: none;
    padding: 12px 30px;
    font-size: medium;
    border-radius: 5px;
    cursor: pointer;
    height: 40px;
    width: 80px;
    transition: background-color 0.3s;
}

button:hover {
    background-color: blue; /* Darker green */
}
	
</style>
</head>
<body>
	
	<% session.setAttribute("restaurant", session.getAttribute("RestaurantId"));%>

	<div>
		<h2>Successfully Updated Restaurant Details</h2>
		<a href="adminRestaurant.jsp"><button>OK</button></a>
	</div>
</body>
</html>