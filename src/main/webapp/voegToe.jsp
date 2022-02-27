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
    <title>voegToe</title>
    <link rel="stylesheet" href="bomenStyle.css">
</head>
<body>
<div id="container">
    <header>
        <h1>Bomen</h1>
        <nav>
            <ul>
                <li><a href="index.jsp">home</a></li>
                <li><a class="active" href="voegToe.jsp">voeg toe</a></li>
                <li><a href="overzicht.jsp">overzicht</a></li>
            </ul>
        </nav>
    </header>
    <main>
        <h3>voeg hier een boom toe</h3>
        <form action="BoomServlet" method="get">
            <ul>
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
                    <input type="number" id="aantal" name="aantal" required>
                    <p></p>
                </li>
                <li>
                    <button type="submit">voeg toe</button>
                </li>
            </ul>
        </form>
    </main>
</div>
</body>
</html>