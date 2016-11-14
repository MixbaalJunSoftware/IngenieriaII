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
 */
public class Proyecto {
    
    @Id@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idproyecto")
    private long idProyecto;
    
    @Column(name = "areaproyecto")
    private String areaProyecto;
    
    @Column(name = "codigo")
    private String codigo;
    
    @OneToOne
    @JoinColumn(name="idtipo")
    private Tipo tipo;
    
    @Column (name = "activo")
    private boolean activo;
    
    @Column(name = "fborrado")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fborrado;

    public long getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(long idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getAreaProyecto() {
        return areaProyecto;
    }

    public void setAreaProyecto(String areaProyecto) {
        this.areaProyecto = areaProyecto;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    
    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Date getFborrado() {
        return fborrado;
    }

    public void setFborrado(Date fborrado) {
        this.fborrado = fborrado;
    }
    
     
    
}
