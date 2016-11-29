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
 */
public class Participante implements Serializable {
    
    @Id
    @OneToOne
    @JoinColumn(name="idPersona")
    private Persona persona;
    
    @Column(name = "puestoparticipante")
    private String puestoParticipante;
    
    
    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getPuestoParticipante() {
        return puestoParticipante;
    }

    public void setPuestoParticipante(String puestoParticipante) {
        this.puestoParticipante = puestoParticipante;
    }
    
}
