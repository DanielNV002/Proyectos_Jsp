/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.projecto_jsp.servlets;

import com.mycompany.projecto_jsp.DAO.ProyectoDAOImpl;
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
@WebServlet("/eliminarProyecto")
public class EliminarProyectoController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Eliminar proyecto si el usuario es admin
        if (esUsuarioAdmin(request)) {
            int idProyecto = Integer.parseInt(request.getParameter("idProyecto"));
            ProyectoDAOImpl pDAO = new ProyectoDAOImpl();
            pDAO.eliminarProyecto(idProyecto);
        }
        response.sendRedirect("/proyectos");
    }
    
    private boolean esUsuarioAdmin(HttpServletRequest request) {
        // Verificar si el usuario es admin
        return request.getSession().getAttribute("role").equals("admin");
    }
}

