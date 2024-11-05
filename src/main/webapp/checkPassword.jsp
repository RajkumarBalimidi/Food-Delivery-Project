<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Incorrect Password</title>
<style>
	body {
    font-family: Arial, sans-serif;
    background-color: #f4f4f4;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    margin: 0;
}

div {
    background-color: white;
    padding: 20px;
    border-radius: 8px;
    box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
    text-align: center;
}

h2 {
    color: #d9534f; /* Bootstrap danger color */
}

p {
    color: #333;
}

button {
    background-color: red; /* Bootstrap info color */
    color: white;
    border: none;
    padding: 10px 15px;
    border-radius: 5px;
    cursor: pointer;
    transition: background-color 0.3s;
}

button:hover {
    background-color: blue; /* Darker shade on hover */
}
	
</style>
</head>
<body>
	<div>
		<h2>Invalid Password</h2>
		<p>You entered a wrong password. Please try Again.</p>
		<a href="editRestaurantDetailsLogin.jsp"><button>Try Again</button></a>	
	</div>
</body>
</html>