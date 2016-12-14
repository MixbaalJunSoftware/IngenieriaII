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
@Table(name="participante")

/**
 *
 * @author Mixbaal
 * @version 1.0
 * clase que modela a un participante que es persona
 */
public class Participante implements Serializable {
    
    @Id
    @OneToOne
    @JoinColumn(name="idPersona")
    //La persona que es participante
    private Persona persona;
    
    @Column(name = "puestoparticipante")
    //El puesto del participante
    private String puestoParticipante;
    
    /**
     * Regresa a la persona que es participante
     * @return la persona
     */
    public Persona getPersona() {
        return persona;
    }
    
    /**
     * Modifica a la persona que es participante
     * @param persona 
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    /**
     * Regresa el puesto del participante
     * @return el puesto
     */
    public String getPuestoParticipante() {
        return puestoParticipante;
    }
    
    /**
     * Modifica el puesto del participante
     * @param puestoParticipante 
     */
    public void setPuestoParticipante(String puestoParticipante) {
        this.puestoParticipante = puestoParticipante;
    }
    
}
