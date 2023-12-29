<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>PCBuilder - Details</title>
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
<h1 class="detailsh1">${type}</h1>
<table class="detailstable">
  <tr>
    <td>Brand:</td>
    <td>${component.brand}</td>
  </tr>
  <tr>
    <td>Full name:</td>
    <td>${component.name}</td>
  </tr>
  <tr>
    <td>Price:</td>
    <td>${component.price.intValue()}ft</td>
  </tr>
  <c:choose>
      <c:when test = "${type.equals('GPU')}">
        <tr>
          <td>Type:</td>
          <td>${component.gpuType}</td>
        </tr>
        <tr>
          <td>Series:</td>
          <td>${component.gpuSeries}</td>
        </tr>
        <tr>
          <td>Memory size:</td>
          <td>${component.memorySize} GB</td>
        </tr>
        <tr>
          <td>Clock speed:</td>
          <td>${component.clockSpeed} MHz</td>
        </tr>
      </c:when>

      <c:when test = "${type.equals('CPU')}">
        <tr>
          <td>Core count:</td>
          <td>${component.cores}</td>
        </tr>
        <tr>
          <td>Thread count:</td>
          <td>${component.threads}</td>
        </tr>
        <tr>
          <td>Core speed:</td>
          <td>${component.coreSpeed} GHz</td>
        </tr>
        <tr>
          <td>Max core speed:</td>
          <td>${component.maxCoreSpeed} GHz</td>
        </tr>
      </c:when>

      <c:when test = "${type.equals('CPUCooler')}">
        <tr>
          <td>Noise:</td>
          <td>${component.noise} db</td>
        </tr>
        <tr>
          <td>Radius:</td>
          <td>${component.radius} mm</td>
        </tr>
        <tr>
          <td>Speed:</td>
          <td>${component.speed} rpm</td>
        </tr>
      </c:when>

      <c:when test = "${type.equals('Motherboard')}">
        <tr>
          <td>Chipset:</td>
          <td>${component.chipset}</td>
        </tr>
        <tr>
          <td>Size:</td>
          <td>${component.sizeType}</td>
        </tr>
        <tr>
          <td>Ram socket type:</td>
          <td>${component.ramSocketType}</td>
        </tr>
        <tr>
          <td>CPU socket type:</td>
          <td>${component.cpuSocket}</td>
        </tr>
      </c:when>

      <c:when test = "${type.equals('PCCase')}">
        <tr>
          <td>Size type:</td>
          <td>${component.sizeType}</td>
        </tr>
      </c:when>

      <c:when test = "${type.equals('PSU')}">
        <tr>
          <td>Rating:</td>
          <td>${component.rating}</td>
        </tr>
        <tr>
          <td>Performance:</td>
          <td>${component.performance} W</td>
        </tr>
      </c:when>

      <c:when test = "${type.equals('RAM')}">
        <tr>
          <td>Size:</td>
          <td>${component.size} GB</td>
        </tr>
        <tr>
          <td>Speed:</td>
          <td>${component.speed} MHz</td>
        </tr>
        <tr>
          <td>Timings:</td>
          <td>${component.timings}</td>
        </tr>
      </c:when>

      <c:when test = "${type.equals('Storage')}">
        <tr>
          <td>Size:</td>
          <td>${component.size} GB</td>
        </tr>
        <tr>
          <td>Storage type:</td>
          <td>${component.storageType}</td>
        </tr>
        <tr>
          <td>Writing speed:</td>
          <td>${component.writingSpeed} MB/s</td>
        </tr>
        <tr>
          <td>Reading speed:</td>
          <td>${component.readingSpeed} MB/s</td>
        </tr>
      </c:when>

      <c:otherwise>
          No comment sir...
      </c:otherwise>
  </c:choose>
  <tr>
    <td>
      <form action="<c:url value='/addToCart'/>" method="post" class="smallMargin">
            <input type="hidden" name="componentId" value="${component.id}">
            <button class="greenButton" type="submit">Add to Cart</button>
       </form>
    </td>
  </tr>
</table>

</body>
</html>