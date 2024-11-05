<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import = "com.tap.foodapp.model.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<% User u = (User)session.getAttribute("user");
	%>
	
	<%
		if(u!=null){
			
			session.setAttribute("user",u);
			session.setAttribute("userid", session.getAttribute("userid"));
			response.sendRedirect("homeUser.jsp");
		}
	
	else{
	response.sendRedirect("homeLogin.jsp");
	}%>
	
</body>
</html>