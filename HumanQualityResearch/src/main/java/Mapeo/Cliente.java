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
 * @author Mixbaal
 * @version 1.0
 */
public class Cliente implements Serializable {
    
    @Id
    @OneToOne
    @JoinColumn(name="idPersona")
    private Persona persona;
    
    @Column(name = "areaCliente")
    private String areaCliente;

    @Column(name = "empresa")
    private String empresa;
    
    @Column(name = "puestoCliente")
    private String puestoCliente;

    public String getAreaCliente() {
        return areaCliente;
    }

    public void setAreaCliente(String areaCliente) {
        this.areaCliente = areaCliente;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getPuestoCliente() {
        return puestoCliente;
    }

    public void setPuestoCliente(String puestoCliente) {
        this.puestoCliente = puestoCliente;
    }
    
}
