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
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name="persona")

/**
 *
 * @author Mixbaal
 * @version 1.0
 * Clase que modela a una persona
 */
public class Persona {
    
    @Id@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idPersona")
    //id de la persona
    private long idPersona;
    
    //El nombre de la persona
    @Column(name = "nombre")
    private String nombre;
    
    //El apellido paterno de la persona
    @Column(name = "app")
    private String app;
    
    //El apellido materno de la persona
    @Column(name = "apm")
    private String apm;
    
    //Fecha de nacimiento de la persona
    @Column(name = "fecha_nac")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha_nac;
    
    //El genero de la persona
    @Column(name = "genero")
    private String genero;
    
    //El telefono de la persona
    @Column(name = "telefono")
    private String telefono;
    
    //El celular de la persona
    @Column(name = "celular")
    private String celular;
    
    //El correo de la persona
    @Column(name = "correo")
    private String correo;
    
    //El estado de la persona
    @Column(name = "activo")
    private boolean activo;
   
    //El borrado logico de la persona
    @Column(name = "fborrado")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fborrado;
    
    //La empresa de la persona
    @Column(name = "empresa")
    private String empresa;
    
    /**
     * Regresa el id de la persona
     * @return el id
     */
    public long getIdPersona() {
        return idPersona;
    }

    /**
     * Modifica el id de la persona
     * @param idPersona 
     */
    public void setIdPersona(long idPersona) {
        this.idPersona = idPersona;
    }

    /**
     * Regrea el nombre de la persona
     * @return el nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Modifica en nombre de la persona
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Regresa el Apellido paterno de la persona
     * @return el apellido paterno
     */
    public String getApp() {
        return app;
    }

    /**
     * Modifica el apellido paterno de la persona
     * @param app 
     */
    public void setApp(String app) {
        this.app = app;
    }

    /**
     * Regresa El apellido materno de la persona
     * @return el apellido materno
     */
    public String getApm() {
        return apm;
    }

    /**
     * Modifica el apellido materno de la persona
     * @param apm 
     */
    public void setApm(String apm) {
        this.apm = apm;
    }

    /**
     * Regresa la fecha de nacimiento de la persona
     * @return la fecha de nacimiento
     */
    public Date getFecha_nac() {
        return fecha_nac;
    }

    /**
     * Modifica la fecha de nacimiento de la persona
     * @param fecha_nac 
     */
    public void setFecha_nac(Date fecha_nac) {
        this.fecha_nac = fecha_nac;
    }
    
    /**
     * Regresan el genero de la persona
     * @return el genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Modifica el genero de la persona
     * @param genero 
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * Regresa el telefono de la persona
     * @return el telefono
     */
    public String getTelefono() {
        return telefono;
    }
    
    /**
     * Modifica el telefono de la persona
     * @param telefono 
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Regresa el celullar  de el telefono
     * @return el telefono
     */
    public String getCelular() {
        return celular;
    }

    /**
     * Modifica el celular de la persona
     * @param celular 
     */
    public void setCelular(String celular) {
        this.celular = celular;
    }

    /**
     * Regrea el correo de la persona
     * @return el correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * modifica el correo de la persona
     * @param correo 
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Regresa el estado de la persona
     * @return el estado
     */
    public boolean getActivo() {
        return activo;
    }

     /**
      * Modifica el estado de la persona
      * @param activo 
      */
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    /**
     * Regresa el estado de borrado logico de la persona
     * @return el estado de borrado
     */
    public Date getFborrado() {
        return fborrado;
    }

    /**
     * modifica el estado de borrado logico
     * @param fborrado 
     */
    public void setFborrado(Date fborrado) {
        this.fborrado = fborrado;
    }
    
    /**
     * Regrea la empresa de la persona
     * @return la empresa
     */
    public String getEmpresa() {
        return empresa;
    }
    
    /**
     * Modifica la empresa de la persona
     * @param empresa 
     */
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

        
}
