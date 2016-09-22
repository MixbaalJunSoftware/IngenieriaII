/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapeo;

import javax.persistence.JoinColumn;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="empleado")

/**
 *
 * @author Mixbaal
 * @version 1.0
 */
public class Empleado {
    
    @Id
    @OneToOne
    @JoinColumn(name="idPersona")
    private Persona persona;
    
    @Column(name = "puestoEmpleado")
    private String puestoempleado;

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getPuestoempleado() {
        return puestoempleado;
    }

    public void setPuestoempleado(String puestoempleado) {
        this.puestoempleado = puestoempleado;
    }
    
}
