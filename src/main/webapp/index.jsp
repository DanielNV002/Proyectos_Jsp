<%-- 
    Document   : index
    Created on : 19 feb 2025, 16:51:50
    Author     : alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styleIndex.css">

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario de Inicio de Sesión</title>
    </head>
    <body>
        <h1>Iniciar sesión</h1>
        <form action="LoginServlet" method="POST">
            <label for="username">Usuario:</label>
            <input type="text" id="username" name="username" required><br><br>

            <label for="password">Contraseña:</label>
            <input type="password" id="password" name="password" required><br><br>

            <button type="submit">Iniciar sesión</button>
        </form>
    </body>
</html>

