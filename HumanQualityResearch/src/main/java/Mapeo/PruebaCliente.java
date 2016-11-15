/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapeo;

import java.io.Serializable;
import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="pruebacliente")

/**
 *
 * @author Mixbaal
 * @version 1.0
 */
public class PruebaCliente implements Serializable {
    
    @Id
    @OneToOne
    @JoinColumn(name="idCliente")
    private Cliente cliente;
    
    @Id
    @JoinColumn(name="prueba")
    private int prueba;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getPrueba() {
        return prueba;
    }

    public void setPrueba(int prueba) {
        this.prueba = prueba;
    }

    
    
}
