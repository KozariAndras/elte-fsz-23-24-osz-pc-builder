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
  ${component.name}
  ${component.brand}
  ${component.price.intValue()}
  <c:choose>
      <c:when test = "${type.equals('GPU')}">
        ${component.clockSpeed}
        ${component.memorySize}
        ${component.gpuType}
        ${component.gpuSeries}
      </c:when>

      <c:when test = "${type.equals('CPU')}">
        ${component.cores}
        ${component.threads}
        ${component.coreSpeed}
        ${component.maxCoreSpeed}
      </c:when>

      <c:when test = "${type.equals('CPUCooler')}">
        ${component.noise}
        ${component.radius}
        ${component.speed}
      </c:when>

      <c:when test = "${type.equals('Motherboard')}">
        ${component.chipset}
        ${component.sizeType}
        ${component.ramSocketType}
        ${component.cpuSocket}
      </c:when>

      <c:when test = "${type.equals('PCCase')}">
        ${component.sizeType}
      </c:when>

      <c:when test = "${type.equals('PSU')}">
        ${component.rating}
        ${component.performance}
      </c:when>

      <c:when test = "${type.equals('RAM')}">
        ${component.timings}
        ${component.speed}
        ${component.size}
      </c:when>

      <c:when test = "${type.equals('Storage')}">
        ${component.size}
        ${component.writingSpeed}
        ${component.readingSpeed}
        ${component.storageType}
      </c:when>

      <c:otherwise>
          No comment sir...
      </c:otherwise>
  </c:choose>
</body>
</html>