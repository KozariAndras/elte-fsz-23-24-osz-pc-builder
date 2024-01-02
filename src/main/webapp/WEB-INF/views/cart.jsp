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
<nav>
    <ul class="navbar">
        <li><a href="/">Home</a></li>
        <li class="searchbar-form">
            <a class="dropbtn">Categories</a>
            <div class="dropdown-content">
              <a href="/CPU">Cpu</a>
              <a href="/GPU">Gpu</a>
              <a href="/CPUCooler">CPU Cooler</a>
              <a href="/Motherboard">Motherboard</a>
              <a href="/PCCase">Case</a>
              <a href="/PSU">Psu</a>
              <a href="/RAM">Ram</a>
              <a href="/Storage">Storage</a>
            </div>
          </li>
          <li class="floatright"><a href="/login">Login</a></li>
          <li class="floatright"><a href="/cart">Cart</a></li>
    </ul>
</nav>
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

</body>
</html>