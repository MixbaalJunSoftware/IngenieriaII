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
@Table(name="pertenecer")

/**
 *
 * @author Mixbaal Jun Software - Ingenieria de Software, 2016 FCiencias, UNAM
 * @version 1.0
 * La clase que modela a la persona que esta en un poryecto
 */
public class Pertenecer implements Serializable {
    
    //la persona que pertenece a el proyecto
    @Id
    @OneToOne
    @JoinColumn(name="idPersona")
    private Persona persona;
    
    //El proyecto al que la persona pertenece
    @Id
    @OneToOne
    @JoinColumn(name="idproyecto")
    private Proyecto proyecto;

    /**
     * Regresa la persona que pertenece al poryecto
     * @return la persona
     */
    public Persona getPersona() {
        return persona;
    }

    /**
     * Modifica a la persona que pertenece al proyecto
     * @param persona 
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    /**
     * Regresa el poryecto el cual la persona pertenece
     * @return el proyecto
     */
    public Proyecto getProyecto() {
        return proyecto;
    }

    /**
     * Modifica el poryecto al que peertenece la persona
     * @param proyecto 
     */
    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }
    
}
