<%-- 
    Document   : MostrarListaProyectos
    Created on : 19 feb 2025, 17:28:11
    Author     : alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.mycompany.proyecto_jsp.entidades.Proyecto" %>

<html>
    <head>
        <title>Lista de Proyectos</title>
    </head>
    <body>
        <h1>Lista de Proyectos</h1>
        <form action="MostrarListaProyectos" method="GET">
            <label for="estado">Estado del Proyecto:</label>
            <select name="estado" id="estado">
                <option value="EN_CURSO">En Curso</option>
                <option value="COMPLETADO">Completado</option>
            </select>
            <input type="submit" value="Filtrar Proyectos">
        </form>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombre Proyecto</th>
                    <th>Descripción</th>
                    <th>Fecha Inicio</th>
                    <th>Fecha Fin</th>
                    <th>Estado</th>
                </tr>
            </thead>
            <tbody>
                <%
                    // Obtener la lista de proyectos desde el request
                    List<Proyecto> proyectos = (List<Proyecto>) request.getAttribute("proyectos");
                    if (proyectos != null) {
                        for (Proyecto proyecto : proyectos) {
                %>
                <tr>
                    <td><%= proyecto.getId()%></td>
                    <td><%= proyecto.getNombreProyecto()%></td>
                    <td><%= proyecto.getDescripcion()%></td>
                    <td><%= proyecto.getFechaInicio()%></td>
                    <td><%= proyecto.getFechaFin()%></td>
                    <td><%= proyecto.getEstado()%></td>
                </tr>
                <%
                    }
                } else {
                %>
                <tr>
                    <td colspan="6">No hay proyectos disponibles.</td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </body>
</html>

