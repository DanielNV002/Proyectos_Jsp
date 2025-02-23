<%-- 
    Document   : MostrarFormularioNuevoProyecto
    Created on : 19 feb 2025, 17:29:35
    Author     : alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styleFormularios.css">

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario Nuevo Proyecto</title>
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
        <h1>Añadir un Nuevo Proyecto</h1>
        <form action="MostrarFormularioNuevosProyectos" method="POST">
            <label for="nombreProyecto">Nombre del Proyecto:</label><br>
            <input type="text" id="nombreProyecto" name="nombreProyecto" required><br><br>

            <label for="descripcion">Descripción:</label><br>
            <textarea id="descripcion" name="descripcion" rows="4" cols="50"></textarea><br><br>

            <label for="fechaInicio">Fecha de Inicio:</label><br>
            <input type="date" id="fechaInicio" name="fechaInicio" required><br><br>

            <label for="fechaFin">Fecha de Fin:</label><br>
            <input type="date" id="fechaFin" name="fechaFin" required><br><br>

            <label for="estado">Estado:</label><br>
            <select id="estado" name="estado" required>
                <option value="EN_CURSO">En Curso</option>
                <option value="COMPLETADO">Completado</option>
            </select><br><br>

            <input type="submit" value="Guardar Proyecto">
        </form>
        <button onclick="window.location.href = '<%= pagina_origen%>'">Volver</button>
    </body>
</html>

