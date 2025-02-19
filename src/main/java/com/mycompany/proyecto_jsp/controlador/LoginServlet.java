/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.proyecto_jsp.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Aquí puedes validar las credenciales (por ejemplo, consultar una base de datos o un archivo)
        if (username.equals("admin") && password.equals("admin")) {
            // Redirigir a la página del administrador
            response.sendRedirect("adminMenu.jsp");
        } else {
            // Redirigir a la página del usuario normal
            response.sendRedirect("userMenu.jsp");
        }
    }
}

