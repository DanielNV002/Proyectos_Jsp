/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.proyecto_jsp.controlador;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class HibernateListener implements ServletContextListener {

    private SessionFactory sessionFactory;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // Inicializa Hibernate al arrancar la aplicación
        try {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml"); // Usamos el archivo de configuración de Hibernate
            sessionFactory = configuration.buildSessionFactory();
            sce.getServletContext().setAttribute("SessionFactory", sessionFactory);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al inicializar Hibernate", e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // Cierra la SessionFactory cuando la aplicación se apaga
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}
