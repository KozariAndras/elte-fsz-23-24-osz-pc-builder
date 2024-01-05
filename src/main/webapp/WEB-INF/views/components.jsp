<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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

<div class="side">
    <form:form method="post" action="/searchFilter" modelAttribute="filter">
            <form:label path="brands" class="boldFont">Brands: <br> </form:label>
            <form:checkboxes items="${brands}" path="brands" delimiter="<br>"/> <br>
            <div>
                <form:label path="min" class="boldFont">Min <br> </form:label>
                <form:input path="min" type="number" min="1" placeholder="1"/> <br>
                <form:label path="max" class="boldFont">Max <br> </form:label>
                <form:input path="max" type="number" min="1" placeholder="1000000"/> <br>
            </div>

            <form:button class="button blackButtonHover">Filter</form:button>
    </form:form>
</div>


<div class="main">
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

</div>

<div class="side">
</div>

</body>
<script src="<c:url value="js/index.js"/>"></script>
</html>