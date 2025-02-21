<%-- 
    Document   : MostrarListaTareasDeProyecto
    Created on : 19 feb 2025, 17:29:03
    Author     : alumno
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.mycompany.proyecto_jsp.entidades.Tarea" %>

<html>
    <head>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styleListas.css">
        <title>Lista de Tareas</title>
    </head>
    <body>
        <%
            // Capturar el parámetro "origen" desde la URL si está presente
            String origen = request.getParameter("origen");
            if (origen != null) {
                session.setAttribute("pagina_origen", origen); // Guardar en sesión
            }

            // Recuperar la página de origen desde la sesión
            String pagina_origen = (String) session.getAttribute("pagina_origen");

            // Si no hay origen, definir un valor por defecto
            if (pagina_origen == null) {
                pagina_origen = "userMenu.jsp"; // O "adminMenu.jsp" si es más probable
            }
        %>

        <h1>Lista de Tareas</h1>

        <!-- Formulario de filtro por ID de proyecto -->
        <form action="MostrarListaTareasDeProyecto" method="GET">
            <label for="id_proyecto">ID del Proyecto:</label>
            <input type="number" name="id_proyecto" id="id_proyecto" required>
            <input type="submit" value="Filtrar Tareas">
        </form>

        <!-- Tabla para mostrar las tareas -->
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Descripción</th>
                    <th>Responsable</th>
                    <th>Fecha Inicio</th>
                    <th>Fecha Fin</th>
                    <th>Estado</th>
                    <th>Proyecto Asociado</th>
                </tr>
            </thead>
            <tbody>
                <%
                    // Obtener la lista de tareas desde el request
                    List<Tarea> tareas = (List<Tarea>) request.getAttribute("tareas");
                    if (tareas != null) {
                        for (Tarea tarea : tareas) {
                %>
                <tr>
                    <td><%= tarea.getId()%></td>
                    <td><%= tarea.getDescripcionTarea()%></td>
                    <td><%= tarea.getResponsable()%></td>
                    <td><%= tarea.getFechaInicio()%></td>
                    <td><%= tarea.getFechaFin()%></td>
                    <td><%= tarea.getEstado()%></td>
                    <td><%= tarea.getIdProyecto().getNombreProyecto()%></td>
                </tr>
                <%
                    }
                } else {
                %>
                <tr>
                    <td colspan="7">No hay tareas disponibles.</td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>

        <button onclick="window.location.href = '<%= pagina_origen%>'">Volver</button>
    </body>
</html>
