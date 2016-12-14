/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapeo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;


@Entity
@Table(name="proyecto")

/**
 *
 * @author Mixbaal
 * @version 1.0
 * Clase que modele un proyecto.
 */
public class Proyecto {
    
    //El id del proyecto
    @Id@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idproyecto")
    private long idProyecto;
    
    //El area del poryecto
    @Column(name = "areaproyecto")
    private String areaProyecto;
    
    //El codigo del proyecto
    @Column(name = "codigo")
    private String codigo;
    
    //El tipo  del proyecto
    @OneToOne
    @JoinColumn(name="idtipo")
    private Tipo tipo;
    
    //Estado del proyecto
    @Column (name = "activo")
    private boolean activo;
    
    //El borrado logico del proyecto
    @Column(name = "fborrado")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fborrado;

    /**
     * Regresa el id del proyecto
     * @return el id
     */
    public long getIdProyecto() {
        return idProyecto;
    }

    /**
     * Modifica el id del proyecto
     * @param idProyecto 
     */
    public void setIdProyecto(long idProyecto) {
        this.idProyecto = idProyecto;
    }

    /**
     * Regresa el area del proyecto
     * @return el area
     */
    public String getAreaProyecto() {
        return areaProyecto;
    }

    /**
     * Modifica el area del proyecto
     * @param areaProyecto 
     */
    public void setAreaProyecto(String areaProyecto) {
        this.areaProyecto = areaProyecto;
    }

    /**
     * Regresa el codigo del proyecto
     * @return el codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Modifica el codigo del proyecto
     * @param codigo 
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Regresa el tipo del proyecto
     * @return el tipo
     */
    public Tipo getTipo() {
        return tipo;
    }

    /**
     * Modifica el tipo del proyecto
     * @param tipo 
     */
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    
    /**
     * Regresa el estado del proyecto
     * @return el estado
     */
    public boolean getActivo() {
        return activo;
    }

    /**
     * Modifica el esto del proyecto
     * @param activo 
     */
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    /**
     * Regresa el esto del borrado logico del proyecto
     * @return el estado logico del proyecto
     */
    public Date getFborrado() {
        return fborrado;
    }

    /**
     * Modifica el borrado logico del proyecto
     * @param fborrado 
     */
    public void setFborrado(Date fborrado) {
        this.fborrado = fborrado;
    }
    
     
    
}
