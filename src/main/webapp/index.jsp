<%--
  Created by IntelliJ IDEA.
  User: hoebe
  Date: 26/02/2022
  Time: 20:23
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="nl">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Home</title>
  <link rel="stylesheet" href="bomenStyle.css">
  <link rel="icon" type="image/x-icon" href="fotos/favicon.jpg">
</head>
<body>
<div id="container">
  <header>
    <h1>Bomen</h1>
    <nav>
      <ul>
        <li><a class="active" href="BoomServlet?command=index">home</a></li>
        <li><a href="BoomServlet?command=voegToe">voeg toe</a></li>
        <li><a href="BoomServlet?command=overzicht">overzicht</a></li>
        <li><a href="BoomServlet?command=zoek">zoek</a></li>
      </ul>
    </nav>
  </header>
  <main>
    <img src="fotos/bomen_klein.jpg" alt="bomen">
    <p>De boomsoort waar je het meeste van hebt ${meesteBomen}</p>
    <p>U zocht deze zoektermen al op:</p>
    <c:forEach var="zoekterm" items="${zoektermen}">
      <p>${zoekterm}</p>
    </c:forEach>
  </main>
  <footer>
    <p></p>
  </footer>
</div>
</body>
</html>