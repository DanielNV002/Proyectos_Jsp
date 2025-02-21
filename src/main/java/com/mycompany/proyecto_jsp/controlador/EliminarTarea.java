/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.proyecto_jsp.controlador;

import com.mycompany.proyecto_jsp.DAO.TareasDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alumno
 */
@WebServlet(name = "EliminarTarea", urlPatterns = {"/EliminarTarea"})
public class EliminarTarea extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Recuperar los parámetros del formulario
        String tareaIdStr = request.getParameter("tareaId");
        String proyectoIdStr = request.getParameter("idProject");
        String mensaje = null;

        try {
            // Convertir los parámetros a enteros
            int tareaId = Integer.parseInt(tareaIdStr);
            int proyectoId = Integer.parseInt(proyectoIdStr);

            // Llamar al método del servicio para eliminar la tarea
            TareasDAOImpl tDAOI = new TareasDAOImpl();
            tDAOI.deleteTaskFromProject(tareaId, proyectoId);

            // Si la tarea se eliminó correctamente
            mensaje = "Tarea eliminada exitosamente.";

        } catch (NumberFormatException e) {
            mensaje = "Error: Los ID proporcionados no son válidos.";
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            mensaje = "Error: " + e.getMessage();
            e.printStackTrace();
        } catch (Exception e) {
            mensaje = "Error al eliminar la tarea.";
            e.printStackTrace();
        }

        // Pasar el mensaje al JSP para que sea mostrado
        request.setAttribute("mensaje", mensaje);

        // Redirigir al mismo JSP para mostrar el mensaje
        request.getRequestDispatcher("EliminarTarea.jsp").forward(request, response);
    }
}
