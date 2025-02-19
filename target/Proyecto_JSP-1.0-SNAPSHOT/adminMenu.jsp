<%-- 
    Document   : adminMenu
    Created on : 19 feb 2025, 17:10:18
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
        <h1>Bienvenido, Administrador</h1>
        <!-- Menú de administrador -->
        <ul>
            <li><a href="MostrarListaProyectos.jsp">Mostrar Lista de Proyectos</a></li>
            <li><a href="MostrarListaTareasDeProyecto.jsp">Mostrar Lista de Tarea</a></li>
            <li><a href="MostrarFormularioNuevoProyecto.jsp">Añadir Nuevo Proyecto</a></li>
            <li><a href="MostrarFormularioNuevaTareaDeProyecto.jsp">Añadir Nueva Tarea</a></li>
            <li><a href="EliminarTarea.jsp">Eliminar Tarea</a></li>
            <li><a href="EliminarProyecto.jsp">Eliminar Proyecto</a></li>
            <li><a href="index.jsp">Cerrar sesión</a></li>
        </ul>
    </body>
</html>
