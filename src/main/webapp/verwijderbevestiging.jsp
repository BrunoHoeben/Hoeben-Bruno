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
    <title>zoekConfirmatie</title>
    <link rel="stylesheet" href="bomenStyle.css">
    <link rel="icon" type="image/x-icon" href="fotos/favicon.jpg">
</head>
<body>
<div id="container">
    <header>
        <h1>Bomen</h1>
        <nav>
            <ul>
                <li><a href="BoomServlet?command=index">home</a></li>
                <li><a href="BoomServlet?command=voegToe">voeg toe</a></li>
                <li><a href="BoomServlet?command=overzicht">overzicht</a></li>
                <li><a class="active" href="BoomServlet?command=zoek">zoek</a></li>
            </ul>
        </nav>
    </header>
    <main>
        <p>verwijder ${boom.soortnaam} uit de lijst?</p>
        <a href="BoomServlet?command=verwijder&ID=${boom.ID}">Verwijder</a>
        <a href="BoomServlet?command=overzicht">Annuleer</a>
    </main>
    <footer>
        <p></p>
    </footer>
</div>
</body>
</html>
