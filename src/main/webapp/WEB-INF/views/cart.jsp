<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>PCBuilder - Cart</title>
    <link href="<c:url value="/resources/css/styles.css"/>" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
</head>
<body>
<nav>
    <ul class="navbar">
        <li><a href="/">Home</a></li>
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
          <li class="floatright"><a href="/login">Login</a></li>
          <li class="floatright"><a href="/cart">Cart</a></li>
    </ul>
</nav>
</body>
</html>