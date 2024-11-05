<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Login Page</title>
<style>
	body {
    font-family: Arial, sans-serif;
    background-color: #f4f4f4;
    margin: 0;
    padding: 0;
}

.container {
    width: 400px;
    margin: auto;
    background: white;
    padding: 20px;
    border-radius: 5px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    margin-top: 100px;
}

h2 {
    text-align: center;
    color: #333;
}

input[type="email"],
input[type="password"] {
    width: 60%;
    padding: 10px 0px 10px 20px;
    margin: 10px 0px 5px 50px;
    border: 2px solid #ccc;
    border-radius: 5px;
}

input[type="submit"] {
    background-color: #4CAF50;
    color: white;
    padding: 10px;
    margin-left: 50px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    width: 68%;
}

input[type="submit"]:hover {
    background-color: #45a049;
}

a {
    text-decoration: none;
    color: #007BFF;
}

a:hover {
    text-decoration: underline;
}

.forgot {
    margin-top: 10px;
    font-size: small;
     color: blue;
    margin-left: 15px;
    text-decoration: none;
}

.notreg {
    font-size: small;
    margin-left:85px;
}

.create {
     margin-left :5px;
    font-size: 14px;
}
.button{
	font-size: medium;
	
}
input{
	margin-left: 15px;
}


</style>
</head>
<body>
	 <form action="AdminLogin" method="post">
            <div class="container">
                <h2>Admin Login Page</h2><br>
                
                <input type="email" name="email" placeholder="Username" required><br><br>
                <input type="password" name="password" placeholder="Password" required><br><br>
                <input class="button" type="submit" value="Login"><br><br>
                <a class="forgot" href="adminForgotPwd.jsp">Forgot Password</a>
        
                <label class="notreg">Not Registered ?</label><a href="createAdminAccount.jsp" class="create">create account</a>
            </div>  
        
        </form>
</body>
</html>