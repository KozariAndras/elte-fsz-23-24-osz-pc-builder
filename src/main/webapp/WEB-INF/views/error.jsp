<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>PCBuilder - Cart</title>
    <link href="<c:url value="css/styles.css" />" rel="stylesheet" >
    <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
</head>
<body>
<header>
    <jsp:include page="fragments/NavbarFragment.jsp"></jsp:include>
</header>
<main>
    <h1 class="textcenter">${errorMessage}</h1>
</main>
<footer>

</footer>
</body>
</html>