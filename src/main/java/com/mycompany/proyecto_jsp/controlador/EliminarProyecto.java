/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.proyecto_jsp.controlador;

import com.mycompany.proyecto_jsp.DAO.ProyectosDAOImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alumno
 */
@WebServlet(name = "EliminarProyecto", urlPatterns = {"/EliminarProyecto"})
public class EliminarProyecto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String mensaje = null;
        
        try {
            int projectId = Integer.parseInt(request.getParameter("projectId"));
            ProyectosDAOImpl proyectosDAO = new ProyectosDAOImpl();

            // Intenta eliminar el proyecto
            if(proyectosDAO.deleteProject(projectId)){
                mensaje = "Proyecto eliminado exitosamente.";
            }else{
                mensaje = "No se encontró un proyecto con el ID proporcionado";
            }

        } catch (NumberFormatException e) {
            mensaje = "ID de proyecto inválido.";
        } catch (Exception e) {
            mensaje = "No se encontró un proyecto con el ID proporcionado o hubo un error.";
        }
        
        // Redirigir de nuevo al JSP con el mensaje
        response.sendRedirect("EliminarProyecto.jsp?mensaje=" + mensaje);
    }
}
