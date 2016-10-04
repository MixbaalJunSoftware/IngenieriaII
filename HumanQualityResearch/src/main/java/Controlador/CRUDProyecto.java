/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ProyectoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Mixbaal
 * @version 1.0
 * Clase para el controlador de las operaciones relacionadas con el CRUD
 * del proyecto
 * 
 */
@Controller
public class CRUDProyecto {
    //Instancia para operaciones con la base relacionadas con el proyecto
    @Autowired
    private ProyectoDAO proyecto_db;
    
    
    /**
     * Metodo para desplegar la vista de CrearCliente
     */
    @RequestMapping(value = "/creaProyecto")
    public String muestraCreaProyecto(){
        return "CrearProyecto";
    }
    
}
