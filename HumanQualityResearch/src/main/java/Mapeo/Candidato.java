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
@Table(name="candidato")

/**
 *
 * @author Mixbaal Jun Software - Ingenieria de Software, 2016 FCiencias, UNAM
 * @version 1.0
 * clase que modela a una persona que es candidato
 * Los atributos estan reflejados en las columnas en la base de datos
 */
public class Candidato implements Serializable {
    
    @Id
    @OneToOne
    @JoinColumn(name="idPersona")
    //Es la persona que es candidato
    private Persona persona;
    
    //RFC del candidato
    @Column(name = "RFC")
    private String rfc;
    
    /**
     * Regresa la persona que es candidato
     * @return la persona que es candidato
     */
    public Persona getPersona() {
        return persona;
    }
    
    /**
     * Modifica a la persona que es candidato 
     * @param persona 
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    /**
     * Regresa el RFC del candidato
     * @return el rfc del cliente
     */
    public String getRfc() {
        return rfc;
    }

    /**
     * Modifica el RFC del candidato
     * @param rfc 
     */
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }
    
}
