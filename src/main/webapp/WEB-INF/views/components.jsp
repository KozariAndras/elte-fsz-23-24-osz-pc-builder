<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>PCBuilder - Main Page</title>
    <link href="<c:url value="css/styles.css" />" rel="stylesheet" >
    <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
</head>
<body>
<header>
    <jsp:include page="fragments/NavbarWithSearchFragment.jsp"></jsp:include>
</header>
<main>
<c:choose>
    <c:when test = "${components.isEmpty()}">
        <div class="textcenter"><a>Nothing was found</a></div>
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
                                                  <button class="button greenButtonHover" type="submit">Add to Cart</button>
                                             </form>
                                        </td>
                                 </tr>
                            </c:forEach>
                    </tbody>
                </table>
            </div>
    </c:otherwise>
</c:choose>
</main>
<footer>

</footer>
</body>
<script src="<c:url value="js/index.js"/>"></script>
</html>