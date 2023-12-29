<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>PCBuilder - Main Page</title>
    <link href="<c:url value="css/styles.css" />" rel="stylesheet" >
    <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
</head>
<nav>
    <ul class="navbar">
        <li class=""><a href="/">Home</a></li>
        <li class="dropdown">
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
          <li class="">
            <form action="/search" method="get" class="searchbar">
               <input path="search" name="search" value="">
               <input type="submit" value="Search">
            </form>
          </li>

          <li class="floatright"><a href="/login">Login</a></li>
          <li class="floatright"><a href="/cart">Cart</a></li>
    </ul>
</nav>
<body>
<c:choose>
    <c:when test = "${components.isEmpty()}">
        <div><a>Nothing was found</a></div>
    </c:when>
    <c:otherwise>
        <div>
                <table>
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Price</th>
                        </tr>
                    </thead>
                    <tbody>
                            <c:forEach items="${components}" var="component">
                                 <tr>
                                        <td>
                                         <a href="<c:url value='/details${component.id}'/>">${component.name}</a>
                                        </td>
                                        <td>${component.price.intValue()}ft</td>
                                        <td>
                                            <form action="<c:url value='/addToCart'/>" method="post" class="smallMargin">
                                                  <input type="hidden" name="componentId" value="${component.id}">
                                                  <button class="greenButton" type="submit">Add to Cart</button>
                                             </form>
                                        </td>
                                 </tr>
                            </c:forEach>
                    </tbody>
                </table>
            </div>
    </c:otherwise>
</c:choose>
</body>
<script src="<c:url value="js/index.js"/>"></script>
</html>