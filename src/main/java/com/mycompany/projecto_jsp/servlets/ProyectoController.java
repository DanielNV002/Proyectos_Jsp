/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.projecto_jsp.servlets;

import com.mycompany.projecto_jsp.DAO.ProyectoDAO;
import com.mycompany.projecto_jsp.DAO.ProyectoDAOImpl;
import com.mycompany.projecto_jsp.entities.Proyecto;
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
@WebServlet("/proyectos")
public class ProyectoController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener lista de proyectos desde la base de datos (filtrados por estado, si es necesario)
        ProyectoDAOImpl pDAO = new ProyectoDAOImpl();
        List<Proyecto> proyectos = pDAO.obtenerProyectosPorEstado("en curso");  // Filtrar por estado
        request.setAttribute("proyectos", proyectos);
        request.getRequestDispatcher("/proyectos.jsp").forward(request, response);
    }
}

