<%-- 
    Document   : EliminarProyecto
    Created on : 19 feb 2025, 17:31:00
    Author     : alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <h1>Eliminar un Proyecto</h1>
        <form action="EliminarProyecto" method="POST">
            <label for="projectId">Ingrese el ID del Proyecto:</label>
            <input type="number" id="projectId" name="projectId" required>
            <button type="submit">Eliminar</button>
        </form>

        <br>
        <ul>
            <li><a href="adminMenu.jsp">Volver</a></li>
        </ul>

        <%-- Mensaje de respuesta del servlet --%>
        <%
            String mensaje = request.getParameter("mensaje");
            if (mensaje != null) {
        %>
        <p class="message"><%= mensaje%></p>
        <% }%>
    </body>

</html>
