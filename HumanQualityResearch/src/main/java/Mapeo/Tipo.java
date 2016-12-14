/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapeo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="tipo")

/**
 *
 * @author Mixbaal
 * @version 1.0
 * Clase que modela el tipo del proyecto
 */
public class Tipo {
    
    //El id del tipo
    @Id@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idtipo")
    private long idTipo;
    
    
    //El tipo del proyecto
    @Column(name = "tipo")
    private String tipo;
    
   /**
    * Regresa el id tipo proyecto
    * @return el id
    */
    public long getIdTipo() {
        return idTipo;
    }

    /**
     * Modifica el id tipo del proyecto
     * @param idTipo 
     */
    public void setIdTipo(long idTipo) {
        this.idTipo = idTipo;
    }

    /**
     * Regresa el tipo de proyecto
     * @return el tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Modifica el tipo 
     * @param tipo 
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

      
}
