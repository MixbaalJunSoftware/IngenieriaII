/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapeo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="usuario")

/**
 *
 * @author Mixbaal
 * @version 1.0
 * Clase que modela un Usuario
 */
public class Usuario implements Serializable {
    
    //La contrasenia de usuario
    @Column(name = "contrasenia")
    private String contrasenia;
    
    //La persona que tiene el Usuario
    @Id@OneToOne
    @JoinColumn(name="idpersona")
    private Persona persona;
    
    //El roll de el usuario
    @Column(name = "rol")
    private String rol;

    /**
     * Regresa la contrasenia del usuario
     * @return la contrasenia
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * Modifica la contrasenia de usuario
     * @param contrasenia 
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    /**
     * La persona que tiene un usuario
     * @return la persona 
     */
    public Persona getPersona() {
        return persona;
    }

    /**
     * Modifica la persona que tiene un usuario
     * @param persona 
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    /**
     * Regresa el rol del ususario
     * @return el usuario
     */
    public String getRol() {
        return rol;
    }

    /**
     * Modifica el del usuario
     * @param rol
     */
    public void setRol(String rol) {
        this.rol = rol;
    }
    
}
