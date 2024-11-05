<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.tap.foodapp.model.Menu, com.tap.foodapp.dao.MenuDAO, com.tap.foodapp.impl.MenuDAOImpl" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Menu Item</title>

<style>
body {
    font-family: Arial, sans-serif;
    background-color: #f8f9fa;
    margin: 0;
    padding: 20px;
}

h2 {
    text-align: center;
    color: white;
    border : 1px solid blue;
    background-color: blue;
    height: 50px;
    width:100%;
    padding-top: 15px;
}

form {
    max-width: 400px;
    margin: auto;
    padding: 20px;
    background-color: #ffffff;
    border-radius: 8px;
    box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
}

div {
    margin-bottom: 5px;
}

label {
    display: block;
    margin-bottom: 3px;
    font-weight: bold;
}

input[type="number"],
input[type="text"] {
    width: 100%;
    padding: 8px;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
    margin-bottom: 15px;
}

input[type="submit"] {
    background-color: #007bff;
    color: white;
    padding: 10px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    width: 50%;
    margin-left: 100px;
}

input[type="submit"]:hover {
    background-color: green;
}

</style>

</head>
<body>
	<%! int menuId;
		Menu m;
	%>
	<%menuId = (int) session.getAttribute("menuId");
	  MenuDAO mdao = new MenuDAOImpl();
	  m = mdao.getMenuById(menuId);
	%>	  
	<% session.setAttribute("menuId", menuId); %>
	
	<form action="EditMenuById">
	<div>
		
		<h2><%= m.getMenu_name()%> Details</h2>
		
		<label>Restaurant ID :</label>
		<input type="number" value="<%= m.getRestaurant_id()%>" readonly><br>
		<label>Menu ID :</label>
		<input type="number" value="<%= m.getMenu_id() %>" readonly><br>
		<label>Menu Name :</label>
		<input type="text" name="name" value="<%= m.getMenu_name() %>"><br>
		<label>Price :</label>
		<input type="text" name="price" value="<%= m.getPrice() %>"><br>
		<label>Description :</label>
		<input type="text" name="description" value="<%= m.getDescription() %>"><br>
		<label>Is Availabel :</label>
		<input type="text" name="isavailable" value="<%= m.getIsavailable() %>"><br>
		
		<input type="submit" value="Update"><br>
	</div>
	</form>
</body>
</html>