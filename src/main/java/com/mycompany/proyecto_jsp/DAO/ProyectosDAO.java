/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_jsp.DAO;

import com.mycompany.proyecto_jsp.entidades.EnumEstadoProyecto;
import com.mycompany.proyecto_jsp.entidades.Proyecto;
import java.util.List;

/**
 *
 * @author alumno
 */
public interface ProyectosDAO {
    
    //Lista de Proyectos por estado
    List<Proyecto> getProjectListByState(EnumEstadoProyecto estado);
    
    //Añadir un Proyecto nuevo
    void addProject(Proyecto proyecto);
    
    //Borrar Proyectos
    boolean deleteProject(int id);
}
