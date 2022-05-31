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
    <title>overzicht</title>
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
                <li><a class="active" href="BoomServlet?command=overzicht">overzicht</a></li>
                <li><a href="BoomServlet?command=zoek">zoek</a></li>
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
                    <%--
                    <td><a href="BeerServlet?command=pasAan&id=${bieren.idBier}">Pas aan</a></td>
                    <td><a href="BeerServlet?command=verwijderbevestiging&remove=${bieren.idBier}">Verwijder</a></td>
                </tr>
            </c:forEach>
                String tableData = "";
                ArrayList<Boom> boomList = (ArrayList<Boom>) request.getAttribute("bomen");
                for (Boom boom : boomList){
                    tableData += String.format("<tr><td>%s</td><td>%s</td><td>%d</td><td>%s</td><td>%s</td>"
                            , boom.getSoortnaam(), boom.getFamilienaam(), boom.getAantal(), "pas aan", "verwijder");
                }


            </tbody>
            <tbody>
            <c:forEach var="bieren" items="${bieren}">
                <tr>
                    <td>${bieren.naamBier}</td>
                    <td>${bieren.soortBier}</td>
                    <td>${bieren.alcoholpercentage}</td>
                    <td><a href="BeerServlet?command=pasAan&id=${bieren.idBier}">Pas aan</a></td>
                    <td><a href="BeerServlet?command=verwijderbevestiging&remove=${bieren.idBier}">Verwijder</a></td>
                    --%>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <p>De boomsoort waar je het meeste van hebt ${meesteBomen}</p>
    </main>
</div>
</body>
</html>