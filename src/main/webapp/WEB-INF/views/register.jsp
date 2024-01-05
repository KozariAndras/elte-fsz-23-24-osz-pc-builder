<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
    <p>${message}</p>
        <form:form action="/register" modelAttribute="user" method="post">
            <div>
                <form:label path="username">Username:</form:label>
                    <form:input type="text" path="username" required="true"/>
                    <br>
            </div>
            <div>
                <form:label path="password">Password:</form:label>
                    <form:input path="password" type="password" required="true"/>
                    <br>
            </div>
            <div>
                <form:label path="matchingPassword">Confirm Password:</form:label>
                <form:input type="password" path="matchingPassword" required="true"/>
            </div>
            <!-- Add other fields related to user registration -->
            <br>
            <form:button>Register</form:button>
        </form:form>
</div>

</body>
</html>
