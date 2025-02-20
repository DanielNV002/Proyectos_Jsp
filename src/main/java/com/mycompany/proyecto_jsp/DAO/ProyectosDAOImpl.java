/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_jsp.DAO;

import com.mycompany.proyecto_jsp.Util.HibernateUtil;
import com.mycompany.proyecto_jsp.entidades.EnumEstadoProyecto;
import com.mycompany.proyecto_jsp.entidades.Proyecto;
import java.util.List;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProyectosDAOImpl implements ProyectosDAO {

    @Override
    public List<Proyecto> getProjectListByState(EnumEstadoProyecto estado) {
        // Obtener la sesión actual de Hibernate
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Proyecto> proyectos = null;

        try {
            // Crear la consulta HQL (Hibernate Query Language) para filtrar por el estado
            String hql = "FROM Proyecto p WHERE p.estado = :estado";
            Query<Proyecto> query = session.createQuery(hql, Proyecto.class);
            query.setParameter("estado", estado.name());

            // Ejecutar la consulta y obtener los resultados
            proyectos = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return proyectos;
    }

    @Override
    public void addProject(Proyecto proyecto) {
        // Obtener la sesión actual de Hibernate
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            // Iniciar una transacción
            transaction = session.beginTransaction();

            // Guardar el proyecto en la base de datos
            session.persist(proyecto);

            // Confirmar la transacción
            transaction.commit();
        } catch (Exception e) {
            // En caso de error, revertir la transacción
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public boolean deleteProject(int id) {
        // Obtener la sesión actual de Hibernate
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        boolean respuesta = false;
        try {
            // Iniciar una transacción
            transaction = session.beginTransaction();

            // Buscar el proyecto por su ID
            Proyecto proyecto = session.get(Proyecto.class, id);
                        
            if (proyecto != null) {
                // Eliminar el proyecto
                session.delete(proyecto);
                respuesta = true;
            }

            // Confirmar la transacción
            transaction.commit();
        } catch (Exception e) {
            // En caso de error, revertir la transacción
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return respuesta;
    }

}
