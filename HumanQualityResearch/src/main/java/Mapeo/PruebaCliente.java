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
 * @author Mixbaal Jun Software - Ingenieria de Software, 2016 FCiencias, UNAM
 * @version 1.0
 * Clase que modela la prueba que contesto el cliente.
 */
public class PruebaCliente implements Serializable {
    
    //El cliente que responde el cliente
    @Id
    @OneToOne
    @JoinColumn(name="idCliente")
    private Cliente cliente;
    
    //La preuba que contesto el cleinte
    @Id
    @JoinColumn(name="prueba")
    private int prueba;

    /**
     * Regresa el cliente que contesto la prueba
     * @return el cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Modifica el cliente que contesto la prueba
     * @param cliente 
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Regresa la prueba que contesto el cliente
     * @return la prueba
     */
    public int getPrueba() {
        return prueba;
    }

    
    /**
     * Modifica la prueba que contesto el cliente
     * @param prueba 
     */
    public void setPrueba(int prueba) {
        this.prueba = prueba;
    }

    
    
}
