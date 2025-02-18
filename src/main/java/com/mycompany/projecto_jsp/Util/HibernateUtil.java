/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecto_jsp.Util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author alumno
 */
public class HibernateUtil {
    public static SessionFactory getSessionFactory(){
        // Crea una instancia de la configuración de Hibernate
        Configuration configuration = new Configuration();

        // Configura Hibernate con el archivo de configuración predeterminado (hibernate.cfg.xml)
        configuration.configure();

        // Devuelve la fábrica de sesiones construida a partir de la configuración
        return configuration.buildSessionFactory();
    }
}
