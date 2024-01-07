<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <meta charset="UTF-8">
    <title>PCBuilder - Order History</title>
    <link href="<c:url value="css/styles.css" />" rel="stylesheet" >
    <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
</head>
<body>

<header>
    <jsp:include page="fragments/NavbarFragment.jsp"></jsp:include>
</header>
<main>

<c:choose>
    <c:when test="${orders.isEmpty()}">
        <div class="textcenter">You dont have any orders!</div>
    </c:when>
    <c:otherwise>
        <table>
        <c:forEach items="${orders}" var="order">
            <tr>
                <th><p>Order id:${order.getId()}</p></th>
            </tr>
            <tr>
                <th><p>Order content:</p></th>
            </tr>
            <c:forEach items="${order.getPcComponents()}" var="component">
            <tr>
                <td><p>${component.getName()}</p></td>
            </tr>
            <tr>
                <td><p>${component.getPrice().intValue()}ft</p></td>
            </tr>
            </c:forEach>
        </c:forEach>
        </table>
    </c:otherwise>
</c:choose>

</main>

</body>
<script src="<c:url value="js/index.js"/>"></script>
</html>