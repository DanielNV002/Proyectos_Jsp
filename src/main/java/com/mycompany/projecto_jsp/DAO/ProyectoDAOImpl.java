/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecto_jsp.DAO;

import com.mycompany.projecto_jsp.Util.HibernateUtil;
import com.mycompany.projecto_jsp.entities.Proyecto;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;


public class ProyectoDAOImpl implements ProyectoDAO {

    @Override
    public List<Proyecto> obtenerProyectosPorEstado(String estado) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("FROM Proyecto WHERE estado = :estado");
        query.setParameter("estado", estado);
        return query.getResultList();
    }
    
    @Override
    public void eliminarProyecto(int idProyecto) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Proyecto proyecto = session.get(Proyecto.class, idProyecto);
        session.delete(proyecto);
        session.getTransaction().commit();
    }
    
}
