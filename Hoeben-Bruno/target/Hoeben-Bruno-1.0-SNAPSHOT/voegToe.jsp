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
    <title>VoegToe</title>
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
                <li><a class="active" href="BoomServlet?command=voegToe" id="voeg toe">voeg toe</a></li>
                <li><a href="BoomServlet?command=overzicht" id="overzicht">overzicht</a></li>
                <li><a href="BoomServlet?command=zoek" id="zoek">zoek</a></li>
            </ul>
        </nav>
    </header>
    <main>
        <h3>voeg hier een boom toe</h3>
        <form method="post" action="BoomServlet" novalidate>
            <ul>
                <li>
                    <p>${foutmelding}</p>
                </li>
                <li>
                    <label for="soort boom">soort boom:</label>
                    <p></p>
                    <input type="text" id="soort boom" name="soort boom" required>
                    <p></p>
                </li>
                <li>
                    <label for="familie boom">familie boom:</label>
                    <p></p>
                    <input type="text" id="familie boom" name="familie boom" required>
                    <p></p>
                </li>
                <li>
                    <label for="aantal">aantal:</label>
                    <p></p>
                    <input type="number" id="aantal" name="aantal" min="1" value="0" required>
                    <p></p>
                </li>
                <li>
                    <input type="hidden" name="command" value="formVoegToe">
                    <button type="submit" id="voeg toe form">voeg toe</button>
                </li>
            </ul>
        </form>
    </main>
    <footer>
        <p>Gemaakt door Bruno Hoeben</p>
    </footer>
</div>
</body>
</html>