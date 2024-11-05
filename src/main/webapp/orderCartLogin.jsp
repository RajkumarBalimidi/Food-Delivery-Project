<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    body {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
    }
    div {
    	border:1px solid black;
        box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        border-radius: 8px;
        text-align: center;
         width: 450px;
         height:150px;
    }
    h2 {
        color: green;
    }
    button {
        margin: 0 10px; /* Space between buttons */
        padding: 10px 20px; /* Padding for buttons */
        border: none;
        border-radius: 5px;
        color: white;
        cursor: pointer;
    }
    .login {
        background-color: blue;
    }
    .register {
        background-color: red;
    }
</style>
</head>
<body>
    <div>
        <h2>Please Login/Signup</h2>
        <p>If you have an account click on Login or else Register Now</p>
        <a href="login.html"><button class="login">Login</button></a>
        <a href="register.html"><button class="register">Register Now</button></a>
    </div>
</body>
</html>
