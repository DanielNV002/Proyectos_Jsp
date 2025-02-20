/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_jsp.DAO;

import com.mycompany.proyecto_jsp.entidades.Tarea;
import java.util.List;

/**
 *
 * @author alumno
 */
public interface TareasDAO {
    
    //Lista de Tareas según el proyecto
    List<Tarea> getTaskByProjectId(int idProject);
    
    //Añadir nueva tarea a un proyecto
    void addTaskToProject(Tarea tarea, int idProject);
    
    //Borrar Tareas de un Proyecto
    void deleteTaskFromProject(int idTarea, int idProject);
}
