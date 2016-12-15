/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapeo;

import java.io.Serializable;
import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="pruebaproyecto")

/**
 *
 * @author Mixbaal Jun Software - Ingenieria de Software, 2016 FCiencias, UNAM
 * @version 1.0
 * Clase que modela la prueba que tiene el proyecto
 */
public class PruebaProyecto implements Serializable {
    
    //El proyecto que tiene la prueba
    @Id
    @OneToOne
    @JoinColumn(name="idProyecto")
    private Proyecto proyecto;
    
    //La Prueba que tiene el proyecto
    @Id
    @JoinColumn(name="prueba")
    private int prueba;

    /**
     * Regresa el proyecto que tiene la prueba
     * @return 
     */
    public Proyecto getProyecto() {
        return proyecto;
    }

    /**
     * Modifica el proyecto que tiene la prueba
     * @param proyecto 
     */
    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    /**
     * Regresa la prueba que tiene le proyecto
     * @return la prueba
     */
    public int getPrueba() {
        return prueba;
    }

    /**
     * Modifica la preba
     * @param prueba 
     */
    public void setPrueba(int prueba) {
        this.prueba = prueba;
    }
    
}
