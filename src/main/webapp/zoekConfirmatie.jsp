<%--
  Created by IntelliJ IDEA.
  User: hoebe
  Date: 26/02/2022
  Time: 20:23
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.Boom" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html lang="nl">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>ZoekConfirmatie</title>
    <link rel="stylesheet" href="bomenStyle.css">
    <link rel="icon" type="image/x-icon" href="fotos/favicon.jpg">
</head>
<body>
<div id="container">
    <header>
        <h1>Bomen</h1>
        <nav>
            <ul>
                <li><a href="BoomServlet?command=index" id="home">home</a></li>
                <li><a href="BoomServlet?command=voegToe" id="voeg toe">voeg toe</a></li>
                <li><a href="BoomServlet?command=overzicht" id="overzicht">overzicht</a></li>
                <li><a class="active" href="BoomServlet?command=zoek" id="zoek">zoek</a></li>
            </ul>
        </nav>
    </header>
    <main>
        <c:choose>
            <c:when test="${gevondenSoort > 0}">
                <p>We hebben bomen met deze soortnaam gevonden <a href="BoomServlet?command=bekijkSoort" id="gevondenSoort">bekijk.</a></p>
            </c:when>
            <c:otherwise>
                <p>Er staan geen bomen met deze soortnaam in de lijst.</p>
            </c:otherwise>
        </c:choose>

        <c:choose>
            <c:when test="${gevondenFamilie > 0}">
                <p>We hebben bomen met deze familienaam gevonden <a href="BoomServlet?command=bekijkFamilie" id="gevondenFamilie">bekijk.</a></p>
            </c:when>
            <c:otherwise>
                <p>Er staan geen bomen met deze familienaam in de lijst.</p>
            </c:otherwise>
        </c:choose>
    </main>
    <footer>
        <p>Gemaakt door Bruno Hoeben</p>
    </footer>
</div>
</body>
</html>
