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
<c:choose>
    <c:when test = "${Data.getItems().isEmpty()}">
        <div class="textcenter"><a>Your cart is currently empty!</a></div>
    </c:when>
    <c:otherwise>
        <div>
            <table>
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Price</th>
                    <th></th>
                    <th>Quantity</th>
                    <th></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${Data.getItems()}" var="Item">
                    <tr>
                        <td>
                            <a href="<c:url value='/details${Item.id}'/>">${Item.name}</a>
                        </td>
                        <td>${Item.price.intValue()}ft</td>
                        <td>
                            <form action="<c:url value='/removeFromCart'/>" method="post" class="smallMargin">
                                <input type="hidden" name="componentId" value="${Item.id}">
                                <button class="button redButtonHover" type="submit">-</button>
                            </form>
                        </td>
                        <td class="textcenter">${Item.quantity}</td>
                        <td>
                            <form action="<c:url value='/addToCart'/>" method="post" class="smallMargin">
                                <input type="hidden" name="componentId" value="${Item.id}">
                                <button class="button greenButtonHover" type="submit">+</button>
                            </form>
                        </td>
                        <td>
                            <form action="<c:url value='/removeAllFromCart'/>" method="post" class="smallMargin">
                                <input type="hidden" name="componentId" value="${Item.id}">
                                <button class="button blackButtonHover" type="submit">Remove from cart</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                    <tr>
                        <td class>
                            <p>Total price: ${Data.getTotalPrice().intValue()}ft</p>
                        </td>
                        <td>
                            <form action="<c:url value='/checkout'/>" method="post" class="smallMargin">
                                <button class= "button greenButtonHover" type="submit">Checkout</button>
                            </form>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </c:otherwise>
</c:choose>
</main>

<footer>

</footer>
</body>
</html>