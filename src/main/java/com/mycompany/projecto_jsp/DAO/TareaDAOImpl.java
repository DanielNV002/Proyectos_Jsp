/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecto_jsp.DAO;

import com.mycompany.projecto_jsp.Util.HibernateUtil;
import com.mycompany.projecto_jsp.entities.Tarea;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;


public class TareaDAOImpl implements TareaDAO {

    @Override
    public List<Tarea> obtenerTareasPorProyecto(int idProyecto) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("FROM Tarea WHERE proyecto.id = :idProyecto");
        query.setParameter("idProyecto", idProyecto);
        return query.getResultList();
    }
    
    @Override
    public void eliminarTarea(int idTarea) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Tarea tarea = session.get(Tarea.class, idTarea);
        session.delete(tarea);
        session.getTransaction().commit();
    }
    
}
