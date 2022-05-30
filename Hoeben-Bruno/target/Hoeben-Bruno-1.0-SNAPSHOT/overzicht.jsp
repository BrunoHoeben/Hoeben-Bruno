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
    <title>Overzicht</title>
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
                <li><a class="active" href="BoomServlet?command=overzicht" id="overzicht">overzicht</a></li>
                <li><a href="BoomServlet?command=zoek" id="zoek">zoek</a></li>
            </ul>
        </nav>
    </header>
    <main>
        <table>
            <thead>
            <tr>
                <th>naam boom</th>
                <th>familie boom</th>
                <th>aantal</th>
                <th>pas aan</th>
                <th>verwijder</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="boom" items="${bomen}">
                <tr>
                    <td>${boom.soortnaam}</td>
                    <td>${boom.familienaam}</td>
                    <td>${boom.aantal}</td>
                    <td><a href="BoomServlet?command=pasAan&ID=${boom.ID}" id="pasAan${boom.ID}">Pas aan</a></td>
                    <td><a href="BoomServlet?command=verwijderbevestiging&verwijderID=${boom.ID}" id="verwijder${boom.ID}">Verwijder</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <p>De boomsoort waar je het meeste van hebt ${meesteBomen}</p>
    </main>
    <footer>
        <p>Gemaakt door Bruno Hoeben</p>
    </footer>
</div>
</body>
</html>