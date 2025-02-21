/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.proyecto_jsp.controlador;

import com.mycompany.proyecto_jsp.DAO.TareasDAOImpl;
import com.mycompany.proyecto_jsp.entidades.Tarea;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alumno
 */
@WebServlet(name = "MostrarListaTareasDeProyecto", urlPatterns = {"/MostrarListaTareasDeProyecto"})
public class MostrarListaTareasDeProyecto extends HttpServlet {

    @Override

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Obtener el ID del proyecto del formulario (desde el parámetro de la URL)
        String idProyectoParam = request.getParameter("id_proyecto");

        // Verificar si el ID del proyecto es válido
        if (idProyectoParam != null && !idProyectoParam.isEmpty()) {
            try {
                int idProyecto = Integer.parseInt(idProyectoParam);

                // Obtener las tareas asociadas al proyecto desde el DAO
                TareasDAOImpl tareasDAO = new TareasDAOImpl();
                List<Tarea> tareas = tareasDAO.getTaskByProjectId(idProyecto);

                // Pasar las tareas al JSP para su visualización
                request.setAttribute("tareas", tareas);

            } catch (NumberFormatException e) {
                // Si el parámetro id_proyecto no es válido, mostrar un mensaje de error
                request.setAttribute("error", "El ID del proyecto es inválido.");
            }
        } else {
            // Si no se proporciona el ID del proyecto, mostrar un mensaje de error
            request.setAttribute("error", "Por favor, ingrese un ID de proyecto.");
        }

        // Redirigir a la página JSP
        request.getRequestDispatcher("/MostrarListaTareasDeProyecto.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
