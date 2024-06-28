<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<link rel="stylesheet" href="assets/css/Login.css" />
</head>
<style>
body {
    font-family: Arial, sans-serif;
    background-color: #FFC1C2;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    margin: 0;
}

.login-container {
    background-color: white;
    padding: 20px;
    border-radius: 10px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    width: 300px;
}

.login-container h2 {
    margin-top: 0;
    margin-bottom: 20px;
    text-align: center;
}

.login-container input[type="text"], 
.login-container input[type="password"] {
    width: 100%;
    padding: 10px;
    margin: 5px 0 20px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
    border-radius: 5px;
}

.button-container {
    display: flex;
    justify-content: space-between;
}

.button-container button {
    font-family: arial;
    background-color: #63B8EE;
    background: linear-gradient(to top, #63B8EE, #468CCF);
    color: #14396A;
    padding: 10px 20px;
    margin: 10px 0;
    border: none;
    cursor: pointer;
    width: 48%;
    border-radius: 5px;
    transition: background 0.3s;
    position: relative;
    overflow: hidden;
}

.button-container button:hover {
    color: white;
    background: #7AA2E3;
    background: linear-gradient(to top, #468CCF, #63B8EE);
}

.button-container button a {
    display: block;
    color: inherit;
    text-decoration: none;
    width: 100%;
    height: 100%;
    position: absolute;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
    line-height: 35px;
    text-align: center;
}

.login-container .register-link {
    display: block;
    text-align: center;
    margin-top: 10px;
    color: #555;
}
</style>
<body>
    <div class="login-container">    
        <h2>Login</h2>
        <form action="LogIn.jsp" method="post">        
            <label for="username">Email Address:</label> 
            <input type="text" id="username" name="username" required> 
            <label for="password">Password:</label> 
            <input type="password" id="password" name="password" required>
            <div class="button-container">
                <button class="submit" type="button" onclick="window.location.href='home.jsp'">Login</button> 
                <button class="submit" type="button" onclick="window.location.href='Registration.jsp'">Register</button>
            </div>
        </form>
    </div>
</body>
</html>