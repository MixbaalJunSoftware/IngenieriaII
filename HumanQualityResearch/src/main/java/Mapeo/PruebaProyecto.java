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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="pruebaproyecto")

/**
 *
 * @author Mixbaal
 */

public class PruebaProyecto implements Serializable{
  
    @Id
    @ManyToOne
    @JoinColumn(name="idproyecto")
    private Proyecto proyecto;
    
    @Id
    @Column(name="idprueba")
    private int prueba;

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public int getPrueba() {
        return prueba;
    }

    public void setPrueba(int prueba) {
        this.prueba = prueba;
    }
    
}
