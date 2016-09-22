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
import javax.persistence.Table;


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
    
}
