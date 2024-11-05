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
    background-color: #f4f4f4;
    color: #333;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    margin: 0;
}

div {
    background-color: #fff;
    border-radius: 8px;
    box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
    padding: 20px;
    text-align: center;
}

h2 {
    margin-bottom: 30px;
    color: #333; /* Default color for the heading */
}

button {
    color: white;
    border: none;
    border-radius: 5px;
    padding: 10px 30px;
    cursor: pointer;
    transition: background-color 0.3s ease;
    font-size: medium;
}

#no {
    background-color: green; /* Green background for Yes */
}

#no:hover {
    background-color: darkgreen; /* Darker green on hover */
}

#yes {
    background-color: red; /* Red background for No */
}

#yes:hover {
    background-color: darkred; /* Darker red on hover */
}

a {
    text-decoration: none; /* Remove underline from links */
    margin: 0 10px; /* Space between buttons */
}

</style>

</head>
<body>
	<%session.setAttribute("resraurantId", session.getAttribute("restaurantId")); %>
	<div>
		<h2> Are you sure to Delete Restaurant</h2>
		<a href="DeleteRestaurantPerimissionGranted"><button id="yes">Yes</button></a>
		<a href="adminRestaurant.jsp"><button id="no">No</button></a>
	</div>
</body>
</html>