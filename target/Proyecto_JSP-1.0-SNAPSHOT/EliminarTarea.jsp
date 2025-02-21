<%-- 
    Document   : EliminarTarea
    Created on : 19 feb 2025, 17:31:06
    Author     : alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styleEliminar.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eliminar Tarea</title>
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
        <h1>Eliminar una Tarea</h1>
        <form action="EliminarTarea" method="POST">
            <label for="tareaId">Ingrese el ID de la Tarea</label>
            <input type="number" id="tareaId" name="tareaId" required>
            <br><br>
            <label for="proyectoId">Ingrese el ID del Proyecto</label>
            <input type="number" id="proyectoId" name="idProject" required>
            <br><br>
            <button type="submit">Eliminar</button>
        </form>

        <br>
        <button onclick="window.location.href = '<%= pagina_origen%>'">Volver</button>


        <%-- Mensaje de respuesta del servlet --%>
        <%
            String mensaje = request.getParameter("mensaje");
            if (mensaje != null) {
        %>
        <p class="message"><%= mensaje%></p>
        <% }%>
    </body>
</html>
