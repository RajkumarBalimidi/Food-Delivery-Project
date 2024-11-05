<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Password Not Matched</title>
<style>
	body {
    font-family: Arial, sans-serif;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    margin: 0;
}

div {
    background-color: white;
    padding: 20px;
    border-radius: 10px;
    box-shadow: 0 4px 15px rgba(0, 0, 0, 0.2);
    text-align: center;
    width: 300px; /* Set a width for better layout */
}

h2 {
    color: #dc3545; /* Bootstrap danger color */
}

p {
    color: #721c24; /* Darker shade for warning text */
}

button {
    background-color: #007bff; /* Bootstrap primary color */
    color: white;
    border: none;
    padding: 10px 15px;
    border-radius: 5px;
    cursor: pointer;
    transition: background-color 0.3s;
}

button:hover {
    background-color: #0056b3; /* Darker shade on hover */
}
	
</style>
</head>
<body>
	<div>
		<h2>Password Not Matched</h2>
		<p>Confirm Password not matched to the New Password. Please Try Again!</p>
		<a href="adminForgotPwd.jsp"><button>Try Again</button></a>
	</div>
</body>
</html>