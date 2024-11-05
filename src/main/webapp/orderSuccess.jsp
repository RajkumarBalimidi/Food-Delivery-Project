<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Success</title>

<style>
/* Basic reset */
* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

body {
    font-family: Arial, sans-serif;
    display: flex;
    justify-content: center;
    align-items: center;
    min-height: 100vh;
    background-color: #f4f4f9;
    color: #333;
}

/* Container styling */
.container {
    width: 60%;
    height: 100%;
    text-align: center;
    padding: 20px;
    border-radius: 8px;
    background-color: #fff;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

/* Heading (h1) styling */
h1 {
    font-size: 24px;
    color: green; /* Different color than green */
    margin-bottom: 15px;
}

/* Image styling */
img {
    width: 130px;
    height: 130px;
    margin-bottom: 15px;
    border-radius: 65px;
}

/* Done button styling */
a.done {
    display: inline-block;
    margin: 10px 5px;
    padding: 10px 15px;
    color: #fff;
   
    background-color: green;
    text-decoration: none;
    border-radius: 5px;
    transition: background-color 0.3s ease;
}

a.done:hover {
    background-color: #45a049;
}

</style>

</head>
<body>

<%
String userEmail = (String)session.getAttribute("userEmail");
session.setAttribute("userEmail", userEmail);
%>

    	<div class="container">
	        <h1>Your Order is Successful</h1><br>
	        <img src="https://cdn.pixabay.com/photo/2021/07/02/04/48/check-6380867_1280.png" alt="Image Not Found"><br>
	        <a href="homeUser.jsp" class="done">Done</a>
    	</div>
    
    
</body>

</html>