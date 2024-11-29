<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "com.tap.foodapp.model.Restaurant" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Restaurant Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }

        h2 {
        	border: 1px solid blue;
            color: white;
            background-color: blue;
            text-align: center;
            margin-top:0;
            width:100%;
            height: 35px;
            padding-top: 13px;
        }

        form {
            background: #fff;
            border-radius: 5px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
            max-width: 400px;
            margin: 0 auto;
        }

        div {
            margin-bottom: 15px;
        }

        label {
            display: block;
            margin-bottom: 2px;
            color: black;
            margin-left:30px;
            font-weight: bold;
        }

        input[type="text"] {
            width: 80%;
            padding: 8px;
            border: 2px solid #ccc;
            border-radius: 4px;
            margin-left:30px;
            margin-bottom:15px;
        }
         input[type="file"] {
         	margin-left: 30px;
         }

        input[type="submit"] {
            background-color: blue;
            color: white;
            border: none;
            padding: 10px;
            border-radius: 4px;
            cursor: pointer;
            margin-left: 100px;
            width: 50%;
        }

        input[type="submit"]:hover {
            background-color: green;
        }
    </style>
</head>
<body>

	<%!Restaurant restaurant; 
//		int RestaurantId;
	%>
	<%restaurant = (Restaurant) session.getAttribute("restaurant");
//	RestaurantId =(int) session.getAttribute("RestaurantId");
	%>
	<form action="ChangeRestaurantDetails" method="post" enctype="multipart/form-data">

	<div>
		<h2><%= restaurant.getResname() %> Details</h2>
		
		<label>Restaurant ID : </label>
		<input type="text" value="<%= restaurant.getResid()%>" readonly><br>
		<label>Restaurant Name : </label>
		<input type="text"  name="resname" value="<%= restaurant.getResname()%>"><br>
		<label>Restaurant Address : </label>
		<input type="text" name="address" value="<%= restaurant.getAddress()%>"><br>
		<label>Restaurant Rating : </label>
		<input type="text"  value="<%out.println(restaurant.getRating());%>" readonly><br>
		<label>Restaurant isActive : </label>
		<input type="text" name="isactive" value="<%= restaurant.getIsactive()%>"><br>
		<label>Restaurant Cuisine Type : </label>
		<input type="text" name="cuisinetype" value="<%= restaurant.getCuisinetype()%>"><br>
		<label>Restaurant Admin Email ID : </label>
		<input type="text" name="adminid" value="<%= restaurant.getAdminid()%>" readonly><br>
		
		<input type="submit" value="update">
	</div>
	</form>
</body>
</html>