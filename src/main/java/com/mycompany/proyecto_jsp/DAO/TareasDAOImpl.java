/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_jsp.DAO;

import com.mycompany.proyecto_jsp.Util.HibernateUtil;
import com.mycompany.proyecto_jsp.entidades.Tarea;
import java.util.List;
import com.mycompany.proyecto_jsp.entidades.Proyecto;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TareasDAOImpl implements TareasDAO {

    @Override
    public List<Tarea> getTaskByProjectId(int idProject) {
        // Obtener una sesión de Hibernate
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            // Crear la consulta HQL para obtener las tareas por el id del proyecto
            Query<Tarea> query = session.createQuery("FROM Tarea t WHERE t.proyecto.id = :idProject", Tarea.class);
            query.setParameter("idProject", idProject); // Establecer el parámetro de la consulta
            return query.list(); // Ejecutar la consulta y devolver la lista de tareas
        } finally {
            session.close(); // Asegurarse de cerrar la sesión
        }
    }

    @Override
    public void addTaskToProject(Tarea tarea, int idProject) {
        // Obtener una sesión de Hibernate
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction(); // Iniciar la transacción

            // Obtener el proyecto con el id proporcionado
            Proyecto proyecto = session.get(Proyecto.class, idProject);
            if (proyecto != null) {
                tarea.setIdProyecto(proyecto); // Asignar el proyecto a la tarea
                session.save(tarea); // Guardar la tarea en la base de datos
                transaction.commit(); // Confirmar los cambios en la base de datos
            } else {
                // Si el proyecto no existe, lanzar una excepción
                throw new IllegalArgumentException("El proyecto con el id " + idProject + " no existe.");
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback(); // Revertir los cambios en caso de error
            }
            e.printStackTrace();
        } finally {
            session.close(); // Asegurarse de cerrar la sesión
        }
    }

    @Override
    public void deleteTaskFromProject(int idTarea, int idProject) {
        // Obtener una sesión de Hibernate
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction(); // Iniciar la transacción

            // Obtener la tarea por su id
            Tarea tarea = session.get(Tarea.class, idTarea);
            if (tarea != null && tarea.getIdProyecto().getId() == idProject) {
                session.delete(tarea); // Eliminar la tarea de la base de datos
                transaction.commit(); // Confirmar los cambios en la base de datos
            } else {
                // Si la tarea no existe o no pertenece al proyecto especificado
                throw new IllegalArgumentException("La tarea no existe o no pertenece al proyecto con id " + idProject);
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback(); // Revertir los cambios en caso de error
            }
            e.printStackTrace();
        } finally {
            session.close(); // Asegurarse de cerrar la sesión
        }
    }

}
