/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.proyecto_jsp.controlador;

import com.mycompany.proyecto_jsp.DAO.ProyectosDAOImpl;
import com.mycompany.proyecto_jsp.entidades.EnumEstadoProyecto;
import com.mycompany.proyecto_jsp.entidades.Proyecto;
import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alumno
 */
@WebServlet(name = "MostrarFormularioNuevosProyectos", urlPatterns = {"/MostrarFormularioNuevosProyectos"})
public class MostrarFormularioNuevosProyectos extends HttpServlet {

    private ProyectosDAOImpl proyectosDAOImpl;

    @Override
    public void init() throws ServletException {
        super.init();
        // Inicializar la clase de acceso a datos (ProyectosDAOImpl)
        proyectosDAOImpl = new ProyectosDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Recoger los datos del formulario
        String nombreProyecto = request.getParameter("nombreProyecto");
        String descripcion = request.getParameter("descripcion");
        String fechaInicioStr = request.getParameter("fechaInicio");
        String fechaFinStr = request.getParameter("fechaFin");
        String estadoStr = request.getParameter("estado");

        // Convertir las fechas de String a Date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaInicioUtil = null;
        Date fechaFinUtil = null;

        try {
            fechaInicioUtil = sdf.parse(fechaInicioStr);  // Devuelve java.util.Date
            fechaFinUtil = sdf.parse(fechaFinStr);        // Devuelve java.util.Date
        } catch (ParseException e) {
            e.printStackTrace();
            // Maneja el error en el formato de fecha si es necesario
        }

        // Convertir java.util.Date a java.sql.Date
        java.sql.Date fechaInicioSQL = new java.sql.Date(fechaInicioUtil.getTime());
        java.sql.Date fechaFinSQL = new java.sql.Date(fechaFinUtil.getTime());

        // Convertir el estado a Enum
        EnumEstadoProyecto estado = EnumEstadoProyecto.valueOf(estadoStr);

        // Crear un nuevo objeto Proyecto con los datos recibidos
        Proyecto proyecto = new Proyecto(nombreProyecto, descripcion, fechaInicioSQL, fechaFinSQL, estado.name(), null);

        // Llamar a ProyectosDAOImpl para guardar el proyecto
        try {
            proyectosDAOImpl.addProject(proyecto);
        } catch (Exception e) {
            e.printStackTrace();
            // En caso de error, puedes manejarlo como una excepción y mostrar un mensaje adecuado
        }

        // Redirigir al usuario a la página de lista de proyectos o página de confirmación
        response.sendRedirect("MostrarListaProyectos.jsp");  // Cambia a la URL donde quieres redirigir
    }

}
