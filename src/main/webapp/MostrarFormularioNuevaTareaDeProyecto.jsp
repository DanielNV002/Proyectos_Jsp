<%-- 
    Document   : MostrarFormularioNuevaTareaDeProyecto
    Created on : 19 feb 2025, 17:29:20
    Author     : alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styleFormularios.css">

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Añadir Nueva Tarea</title>

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

        <h1>Añadir una Nueva Tarea a un Proyecto</h1>

        <form action="MostrarFormularioNuevasTareasDeProyecto" method="POST">
            <label for="id_proyecto">ID del Proyecto:</label>
            <input type="number" id="id_proyecto" name="id_proyecto" required>

            <label for="descripcion_tarea">Descripción de la Tarea:</label>
            <textarea id="descripcion_tarea" name="descripcion_tarea" rows="4" required></textarea>

            <label for="responsable">Responsable:</label>
            <input type="text" id="responsable" name="responsable" required>

            <label for="fecha_inicio">Fecha de Inicio:</label>
            <input type="date" id="fecha_inicio" name="fecha_inicio" required>

            <label for="fecha_fin">Fecha de Fin:</label>
            <input type="date" id="fecha_fin" name="fecha_fin" required>

            <label for="estado">Estado:</label>
            <select id="estado" name="estado" required>
                <option value="PENDIENTE">Pendiente</option>
                <option value="EN_PROGRESO">En Progreso</option>
                <option value="COMPLETADA">Completada</option>
            </select>

            <br><br>
            <button type="submit">Guardar Tarea</button>
            <%-- Mensaje de respuesta del servlet --%>
            <%
                String mensaje = request.getParameter("mensaje");
                if (mensaje != null) {
            %>
            <p class="message"><%= mensaje%></p>
            <% }%>
        </form>

        <br><br>
        <button onclick="window.location.href = '<%= pagina_origen%>'">Volver</button>
    </body>
</html>
