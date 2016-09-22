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
 * @author Mixbaal
 * @version 1.0
 */
public class Pertenecer implements Serializable {
    
    @Id
    @OneToOne
    @JoinColumn(name="idPersona")
    private Persona persona;
    
    @Id
    @OneToOne
    @JoinColumn(name="idproyecto")
    private Proyecto proyecto;

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }
    
}
