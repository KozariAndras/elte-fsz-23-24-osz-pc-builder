<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>PCBuilder - Register</title>
    <link href="<c:url value="css/styles.css" />" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
</head>
<body>

<div class="register-container">
<h2>Registration Page</h2>
<form action="<c:url value='/login'/>" method="post">
    <label for="username">Username:</label>
    <input type="text" id="username" name="credential.username" required>
    <br>
    <label for="password">Password:</label>
    <input type="password" id="password" name="credential.password" required>
    <br>
    <!-- Add other fields related to user registration -->
    <br>
    <button type="submit">Register</button>
</form>
</div>

</body>
</html>
