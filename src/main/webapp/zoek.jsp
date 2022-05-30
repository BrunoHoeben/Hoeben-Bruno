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
    <title>Zoek</title>
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
        <h3>zoek</h3>
        <form method="post" action="BoomServlet">
            <ul>
                <li>
                    <label for="zoek">zoek:</label>
                    <p></p>
                    <input type="text" id="zoek" name="zoek" required>
                    <p></p>
                </li>
                <li>
                    <input type="hidden" name="command" value="zoekBoom">
                    <button type="submit">zoek</button>
                </li>
            </ul>
        </form>
    </main>
    <footer>
        <p>U deed al ${cookie["aantalZoekopdrachten"].value} succesvolle zoekopdrachten</p>
        <form method="post" action="BoomServlet">
            <input type="hidden" name="command" value="reset">
            <button type="submit">reset</button>
        </form>
    </footer>
</div>
</body>
</html>