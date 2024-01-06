
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>PCBuilder - Login</title>
    <link href="<c:url value="css/styles.css" />" rel="stylesheet" >
    <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
</head>
<body>


<header>
<jsp:include page="fragments/NavbarWithSearchFragment.jsp"></jsp:include>
</header>

<main>
    <div class="login-container">
        <h2>Sign in</h2>
        <p class="error">${message}</p>
            <form:form action="/login" modelAttribute="user" method="post">
                <div>
                    <form:label path="username">Username:</form:label>
                    <form:input type="text" path="username" placeholder="Username" required="true"/>
                    <br>
                </div>
                <div>
                    <form:label path="password">Password:</form:label>
                    <form:input type="password" path="password" placeholder="Password" required="true"/>
                    <br>
                </div>
                <form:button>Login</form:button>
            </form:form>
    </div>
</main>

</body>
</html>