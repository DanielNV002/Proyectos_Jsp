<%-- 
    Document   : userMenu
    Created on : 19 feb 2025, 17:09:43
    Author     : alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Bienvenido, Usuario</h1>
        <!-- Menú de usuario -->
        <ul>
            <li><a href="MostrarListaProyectos.jsp">Mostrar Lista de Proyectos</a></li>
            <li><a href="MostrarListaTareasDeProyecto.jsp">Mostrar Lista de Tarea</a></li>
            <li><a href="MostrarFormularioNuevoProyecto.jsp">Añadir Nuevo Proyecto</a></li>
            <li><a href="MostrarFormularioNuevaTareaDeProyecto.jsp">Añadir Nueva Tarea</a></li>
            <li><a href="index.jsp">Cerrar sesión</a></li>
        </ul>
    </body>
</html>
