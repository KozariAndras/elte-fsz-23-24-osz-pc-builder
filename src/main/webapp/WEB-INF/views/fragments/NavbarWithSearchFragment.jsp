<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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