<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Restaurants Forgot Password Page</title>
    <style>
    	@charset "UTF-8";

*{
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    background-color: white;
}
.forgotpwd{
    border: 1px solid black;
    border-radius: 3px;
    background-color: white;
    height: 380px;
    width: 300px;
    margin-top: 80px;
    margin-left: 500px;
}
.forgotpwd form{
    background-color: white;
}
.forgotpwd h2{
    padding-top: 8px;
    margin-bottom: 30px;
    text-align: center;
    background-color: rgb(55, 172, 9);
    border: 2px solid rgb(55, 172, 9);
    height: 50px;
    color: white;    
}

.forgotpwd label{
    background-color: white;
    margin-left: 35px;
}
.forgotpwd input{
    background-color: white;
    margin-left: 35px;
    margin-bottom: 15px;
    height: 33px;
    width: 230px;
    border-radius: 3px;    
}
.forgotpwd .submit{
    height: 35px;
    width: 230px;
    margin-left: 40px;
    border-radius: 5px;
    margin-top: 10px;
    margin-bottom: 10px;
    cursor: pointer;
    font-size: medium;
    background-color: rgb(55, 172, 9);
    color: white;
}
.forgotpwd .submit:hover{
	background-color: rgb(6, 226, 43);
}
.forgotpwd input[placeholder]{
    padding-left: 10px;
}

</style>

</head>
<body>

    <div class="forgotpwd">
        <h2>Set New Password</h2>
        <form action="AdminForgotPassword">
            <label>Email</label><br>
            <input type="email" name="email" placeholder="Email" required><br>
            <label>New Password</label><br>
            <input id="pwd" type="password" name="newpassword" placeholder="New password" required><br>
            <label>Confirm Password</label><br>
            <input id="cpwd" type="password" name="confirmpassword" placeholder="Confirm password" required><br><br>
            <input id="submit" type="submit" class="submit" value="submit">
        </form>
    </div>
    
</body>
</html>