<%--
  Created by IntelliJ IDEA.
  User: hoebe
  Date: 26/02/2022
  Time: 20:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="nl">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>overzicht</title>
    <link rel="stylesheet" href="bomenStyle.css">
</head>
<body>
<div id="container">
    <header>
        <h1>Bomen</h1>
        <nav>
            <ul>
                <li><a href="index.jsp">home</a></li>
                <li><a href="voegToe.jsp">voeg toe</a></li>
                <li><a class="active" href="overzicht.jsp">overzicht</a></li>
            </ul>
        </nav>
    </header>
    <main>
        <p>bomen:</p>
        <p><%= request.getAttribute("result")%></p>
    </main>
</div>
</body>
</html>