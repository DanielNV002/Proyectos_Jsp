/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecto_jsp.DAO;

import com.mycompany.projecto_jsp.entities.Tarea;
import java.util.List;

/**
 *
 * @author alumno
 */
public interface TareaDAO {
    
    List<Tarea> obtenerTareasPorProyecto(int idProyecto);
    
    void eliminarTarea(int idTarea);
    
}
