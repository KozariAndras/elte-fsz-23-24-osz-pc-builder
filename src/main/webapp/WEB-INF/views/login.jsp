<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>PCBuilder - Login</title>
    <link href="<c:url value="css/styles.css" />" rel="stylesheet" >
    <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
</head>
<body>
    <div class="login-container">
            <h2>Login Page</h2>
            <form id="loginForm" action="<c:url value='/'/>" method="post">
                <label for="username">Username:</label>
                <input type="text" id="username" name="username" placeholder="username" required><br>

                <label for="password">Password:</label>
                <input type="password" id="password" name="password" placeholder="password" required><br>

                <button type="submit">Login</button>
            </form>
        </div>
</body>
</html>