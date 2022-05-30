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
                <li><a href="BoomServlet?command=zoek">zoek</a></li>
            </ul>
        </nav>
    </header>
    <main>
        <h3>pas hier de boom aan</h3>
        <form method="post" action="BoomServlet" novalidate>
            <input type="hidden" name="ID" value=${boom.ID}>
            <ul>
                <li>
                    <label for="soort boom">soort boom:</label>
                    <p></p>
                    <input type="text" id="soort boom" name="soort boom" value="${boom.soortnaam}" required>
                    <p></p>
                </li>
                <li>
                    <label for="familie boom">familie boom:</label>
                    <p></p>
                    <input type="text" id="familie boom" name="familie boom" value="${boom.familienaam}" required>
                    <p></p>
                </li>
                <li>
                    <label for="aantal">aantal:</label>
                    <p></p>
                    <input type="number" id="aantal" name="aantal" min="0" value="${boom.aantal}" required>
                    <p></p>
                </li>
                <li>
                    <input type="hidden" name="command" value="formPasAan">
                    <button type="submit">pas aan</button>
                </li>
            </ul>
        </form>
    </main>
    <footer>
        <p></p>
    </footer>
</div>
</body>
</html>