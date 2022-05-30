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
        <p>${gevondenSoort}</p>
        <p>${gevondenFamilie}</p>
       <%--
            ArrayList<Boom> gevondenSoort = (ArrayList<Boom>) request.getAttribute("gevondenSoort");
            String inLijst = "";
            if (!gevondenSoort.isEmpty()){
                inLijst = "<p>We hebben bomen met deze soortnaam gevonden</p><a href=\"BoomServlet?command=bekijkSoort\">bekijk</a>";
            }
            else inLijst = "<p>Er zijn geen bomen met deze soortnaam in de lijst</p>";

            ArrayList<Boom> gevondenFamilie = (ArrayList<Boom>) request.getAttribute("gevondenFamilie");
            if (!gevondenFamilie.isEmpty()){
                inLijst += "<p>We hebben bomen met deze familienaam gevonden</p><a href=\"BoomServlet?command=bekijkFamilie\">bekijk</a>";
            }
            else inLijst += "<p>Er zijn geen bomen met deze familienaam in de lijst</p>";
        %>
        <%=inLijst %>--%>
    </main>
    <footer>
        <p></p>
    </footer>
</div>
</body>
</html>
