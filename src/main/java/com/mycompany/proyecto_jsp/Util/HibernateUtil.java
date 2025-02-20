package com.mycompany.proyecto_jsp.Util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    /**
     * Obtiene una instancia de {@link SessionFactory} configurada con los parámetros
     * definidos en el archivo de configuración de Hibernate (hibernate.cfg.xml).
     *
     * @return una instancia de {@link SessionFactory} configurada
     */
    public static SessionFactory getSessionFactory(){
        // Crea una instancia de la configuración de Hibernate
        Configuration configuration = new Configuration();

        // Configura Hibernate con el archivo de configuración predeterminado (hibernate.cfg.xml)
        configuration.configure();

        // Devuelve la fábrica de sesiones construida a partir de la configuración
        return configuration.buildSessionFactory();
    }
}
