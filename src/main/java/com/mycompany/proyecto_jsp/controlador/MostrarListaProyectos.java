/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.proyecto_jsp.controlador;

import com.mycompany.proyecto_jsp.DAO.ProyectosDAOImpl;
import com.mycompany.proyecto_jsp.entidades.EnumEstadoProyecto;
import com.mycompany.proyecto_jsp.entidades.Proyecto;
import java.io.IOException;
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
@WebServlet(name = "MostrarListaProyectos", urlPatterns = {"/MostrarListaProyectos"})
public class MostrarListaProyectos extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProyectosDAOImpl pDAOI = new ProyectosDAOImpl();

        // Obtener el parámetro "estado" enviado desde el JSP
        String estadoStr = request.getParameter("estado");

        // Verificar si el parámetro "estado" no es nulo y es un valor válido
        if (estadoStr != null && !estadoStr.isEmpty()) {
            try {
                // Convertir el parámetro "estado" a EnumEstadoProyecto
                EnumEstadoProyecto estado = EnumEstadoProyecto.valueOf(estadoStr);

                // Llamar al método getProjectListByState para obtener los proyectos filtrados
                List<Proyecto> proyectos = pDAOI.getProjectListByState(estado);

                // Pasar la lista de proyectos a la JSP
                request.setAttribute("proyectos", proyectos);
               // System.out.println(proyectos);

                // Redirigir a la página JSP que muestra la lista de proyectos
                request.getRequestDispatcher("/MostrarListaProyectos.jsp").forward(request, response);
            } catch (IllegalArgumentException e) {
                // En caso de que el valor de "estado" no sea válido
                e.printStackTrace();
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Estado no válido.");
            }
        } else {
            // Si no se recibió el parámetro "estado", redirigir a una página con todos los proyectos (opcional)
            List<Proyecto> proyectos = pDAOI.getProjectListByState(EnumEstadoProyecto.EN_CURSO); // O cualquier otro valor por defecto
            request.setAttribute("proyectos", proyectos);
            //request.getRequestDispatcher("/ListaDeProyectos.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
