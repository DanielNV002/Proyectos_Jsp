/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.proyecto_jsp.controlador;

import com.mycompany.proyecto_jsp.DAO.TareasDAOImpl;
import com.mycompany.proyecto_jsp.entidades.Tarea;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alumno
 */
@WebServlet(name = "MostrarFormularioNuevasTareasDeProyecto", urlPatterns = {"/MostrarFormularioNuevasTareasDeProyecto"})
public class MostrarFormularioNuevasTareasDeProyecto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Obtener el ID del proyecto desde el formulario
            int idProyecto = Integer.parseInt(request.getParameter("id_proyecto"));

            // Obtener otros datos del formulario
            String descripcion = request.getParameter("descripcion_tarea");
            String responsable = request.getParameter("responsable");
            Date fechaInicio = Date.valueOf(request.getParameter("fecha_inicio"));
            Date fechaFin = Date.valueOf(request.getParameter("fecha_fin"));
            String estado = request.getParameter("estado");

            // Crear la tarea
            Tarea tarea = new Tarea(descripcion, responsable, fechaInicio, fechaFin, estado);

            // Llamar al método de TareasDAOImpl para agregar la tarea
            TareasDAOImpl tareasDAO = new TareasDAOImpl();
            tareasDAO.addTaskToProject(tarea, idProyecto);
            
            // Redirigir con mensaje de éxito
            response.sendRedirect("MostrarFormularioNuevaTareaDeProyecto.jsp?mensaje=La tarea se agrego con exito");

        } catch (IllegalArgumentException e) {
            // En caso de que el proyecto no exista
            response.sendRedirect("MostrarFormularioNuevaTareaDeProyecto.jsp?mensaje=" + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("MostrarFormularioNuevaTareaDeProyecto.jsp?mensaje=No se pudo agregar la tarea");
        }
    }

}
