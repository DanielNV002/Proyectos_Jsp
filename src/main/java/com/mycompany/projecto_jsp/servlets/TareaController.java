/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.projecto_jsp.servlets;

import com.mycompany.projecto_jsp.DAO.TareaDAOImpl;
import com.mycompany.projecto_jsp.entities.Tarea;
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
@WebServlet("/tareas")
public class TareaController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener tareas de un proyecto específico
        int idProyecto = Integer.parseInt(request.getParameter("idProyecto"));
        TareaDAOImpl tDAO = new TareaDAOImpl();
        List<Tarea> tareas = tDAO.obtenerTareasPorProyecto(idProyecto);
        request.setAttribute("tareas", tareas);
        request.getRequestDispatcher("/tareas.jsp").forward(request, response);
    }
}
