/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapeo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name="tokenPassword")

/**
 *
 * @author Mixbaal
 */
public class TokenPassword implements Serializable {
    
    @Id@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idTokenPassword")
    private long idTokenPassword;
    
    @ManyToOne
    @JoinColumn(name = "idPersona")
    private Persona persona;
    
    @Column(name = "fechaToken")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaToken;
    
    @Column(name = "token")
    private String token;

    public long getIdTokenPassword() {
        return idTokenPassword;
    }

    public void setIdTokenPassword(long idTokenPassword) {
        this.idTokenPassword = idTokenPassword;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Date getFechaToken() {
        return fechaToken;
    }

    public void setFechaToken(Date fechaToken) {
        this.fechaToken = fechaToken;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    
}
