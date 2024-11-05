<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.tap.foodapp.model.Restaurant" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%Restaurant restaurant = (Restaurant) session.getAttribute("RestaurantAdmin"); %>
	<%if(restaurant != null)
	{
		request.setAttribute("restaurant", restaurant);
		response.sendRedirect("adminRestaurant.jsp");
	}
	else
	{
		response.sendRedirect("adminHomeWithoutLogin.jsp");		
	}
		%>
</body>
</html>