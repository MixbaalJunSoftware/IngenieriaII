/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapeo;

import java.io.Serializable;
import javax.persistence.JoinColumn;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="cliente")

/**
 *
 * @author Mixbaal Jun Software - Ingenieria de Software, 2016 FCiencias, UNAM
 * @version 1.0
 * Clase que modela a una persona que es cliente
 */
public class Cliente implements Serializable {
    
    @Id
    @OneToOne
    @JoinColumn(name="idPersona")
    //La persona que es cliente
    private Persona persona;
    
    //El area del cliente
    @Column(name = "areaCliente")
    private String areaCliente;

    //El puesto del cliente
    @Column(name = "puestoCliente")
    private String puestoCliente;

    /**
     * Regresa el area del cliente
     * @return el area del cliente
     */
    public String getAreaCliente() {
        return areaCliente;
    }

    /**
     * Modifica el area del cliente
     * @param areaCliente 
     */
    public void setAreaCliente(String areaCliente) {
        this.areaCliente = areaCliente;
    }

    /**
     * Regresa a la persona que es cliente
     * @return la persona
     */
    public Persona getPersona() {
        return persona;
    }
    
    /**
     * Modifica a la persona que es cliente
     * @param persona 
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    /**
     * Regresa el puesto del cliente
     * @return el puesto
     */
    public String getPuestoCliente() {
        return puestoCliente;
    }

    /**
     * Modifica el puesto del cliente
     * @param puestoCliente 
     */
    public void setPuestoCliente(String puestoCliente) {
        this.puestoCliente = puestoCliente;
    }
    
}
