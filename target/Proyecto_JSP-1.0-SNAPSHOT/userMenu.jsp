<%-- 
    Document   : userMenu
    Created on : 19 feb 2025, 17:09:43
    Author     : alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styleMenu.css">

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String origen = request.getParameter("origen");
            if (origen != null) {
                session.setAttribute("userMenu.jsp", origen);
            }
        %>
        <h1>Bienvenido, Usuario</h1>
        <!-- Menú de usuario -->
        <ul>
            <li><a href="MostrarListaProyectos.jsp?origen=userMenu.jsp">Mostrar Lista de Proyectos</a></li>
            <li><a href="MostrarListaTareasDeProyecto.jsp?origen=userMenu.jsp">Mostrar Lista de Tarea</a></li>
            <li><a href="MostrarFormularioNuevoProyecto.jsp?origen=userMenu.jsp">Añadir Nuevo Proyecto</a></li>
            <li><a href="MostrarFormularioNuevaTareaDeProyecto.jsp?origen=userMenu.jsp">Añadir Nueva Tarea</a></li>
            <li><a href="index.jsp">Cerrar sesión</a></li>
        </ul>

    </body>
</html>
