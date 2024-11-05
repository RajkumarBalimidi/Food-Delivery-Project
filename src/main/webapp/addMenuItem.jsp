<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Menu Item</title>
<style>
body {
    font-family: Arial, sans-serif;
    background-color: #f4f4f4;
    margin: 0;
    padding: 20px;
}

h2 {
    color: white;
    background-color: blue;
    height: 40px;
    text-align: center;
    padding-top: 10px;
}

form {
    background: white;
    padding: 8px;
    border-radius: 8px;
    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
    max-width: 400px;
    margin: auto;
}

label {
    display: block;
   
    font-weight: bold;
}

input[type="text"] {
    width: calc(100% - 20px);
    padding: 8px;
    margin-bottom: 15px;
    border: 1px solid #ccc;
    border-radius: 4px;
    font-size: medium;
}

input[type="submit"] {
    background-color: blue;
    color: white;
    padding: 10px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    font-size: 12px;
    transition: background-color 0.3s;
    margin-left: 230px;
    
}
input[type="reset"]{
	color: white;
	background-color: red;
	padding: 10px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    font-size: 15px;
    width: 80px;
    transition: background-color 0.3s;
    margin-left:5px;
}

input[type="submit"]:hover {
    background-color: #218838;
}

@media (max-width: 480px) {
    form {
        width: 90%;
    }
}

</style>
</head>
<body>
	
	<%! int restaurantId; %>
	<%
		restaurantId = (int) session.getAttribute("restaurantId");
		session.setAttribute("restaurantId", restaurantId);
	%>
	
	
	<form action="AddMenuItem">
		<div>
			<h2>Add Menu Item</h2>
			<label>Restaurant ID : </label><br>
			<input type="text" value="<%= restaurantId%>" readonly><br>
			<label>Item Name : </label><br>
			<input type="text" name="name" placeholder="Item Name" required><br>
			<label>Price : </label><br>
			<input type="text" name="price" placeholder="Price" required><br>
			<label>Description : </label><br>
			<input type="text" name="description" placeholder="Description" required><br>
			<label>Is Available : </label><br>
			<input type="text" name="isavailable" placeholder="Currently Available" required><br>
			<input type="reset" value="clear">
			<input type="submit" value="ADD ITEM"><br>
			
		</div>
	</form>
	
</body>
</html>