/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapeo;

import java.util.Date;
import javax.persistence.JoinColumn;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;


@Entity
@Table(name="rclimalaboral")

/**
 *
 * @author Mixbaal Jun Software - Ingenieria de Software, 2016 FCiencias, UNAM
 * @version 1.0
 * Clase que modela la prueba de Clima laboral
 */
public class RClimaLaboral {
    
    //id de la prueba
    @Id@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idrclimalaboral")
    private long idRClimaLaboral;
    
    //Fecha en que se contesto la prueba
    @Column(name = "fecharespuesta")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRespuesta;
    
    //Persona que contesto la prueba
    @OneToOne
    @JoinColumn(name="idPersona")
    private Persona persona;
    
    //respuesta 1-20
    @Column(name = "respuesta1")
    private int respuesta1;
    
    @Column(name = "respuesta2")
    private int respuesta2;
    
    @Column(name = "respuesta3")
    private int respuesta3;
    
    @Column(name = "respuesta4")
    private int respuesta4;
    
    @Column(name = "respuesta5")
    private int respuesta5;
    
    @Column(name = "respuesta6")
    private int respuesta6;
    
    @Column(name = "respuesta7")
    private int respuesta7;
    
    @Column(name = "respuesta8")
    private int respuesta8;
    
    @Column(name = "respuesta9")
    private int respuesta9;
    
    @Column(name = "respuesta10")
    private int respuesta10;
    
    @Column(name = "respuesta11")
    private int respuesta11;
    
    @Column(name = "respuesta12")
    private int respuesta12;
    
    @Column(name = "respuesta13")
    private int respuesta13;
    
    @Column(name = "respuesta14")
    private int respuesta14;
    
    @Column(name = "respuesta15")
    private int respuesta15;
    
    @Column(name = "respuesta16")
    private int respuesta16;
    
    @Column(name = "respuesta17")
    private int respuesta17;
    
    @Column(name = "respuesta18")
    private int respuesta18;
    
    @Column(name = "respuesta19")
    private int respuesta19;
    
    @Column(name = "respuesta20")
    private int respuesta20;

    /**
     * Regresa el id de la prueba
     * @return el id
     */
    public long getIdRClimaLaboral() {
        return idRClimaLaboral;
    }

    /**
     * Modifica el id de la prueba
     * @param idRClimaLaboral 
     */
    public void setIdRClimaLaboral(long idRClimaLaboral) {
        this.idRClimaLaboral = idRClimaLaboral;
    }

    /**
     * Regresa la fecha en que se contesto la prueba
     * @return la fecha
     */
    public Date getFechaRespuesta() {
        return fechaRespuesta;
    }
    
    /**
     * Modifica la fecha en que se contesto la prueba
     * @param fechaRespuesta 
     */
    public void setFechaRespuesta(Date fechaRespuesta) {
        this.fechaRespuesta = fechaRespuesta;
    }

    /**
     * Regresa la persona que contesto la prueba
     * @return la persona
     */
    public Persona getPersona() {
        return persona;
    }

    /**
     * Modifica a la persona que contesto la prueba
     * @param persona 
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public int getRespuesta1() {
        return respuesta1;
    }

    public void setRespuesta1(int respuesta1) {
        this.respuesta1 = respuesta1;
    }

    public int getRespuesta2() {
        return respuesta2;
    }

    public void setRespuesta2(int respuesta2) {
        this.respuesta2 = respuesta2;
    }

    public int getRespuesta3() {
        return respuesta3;
    }

    public void setRespuesta3(int respuesta3) {
        this.respuesta3 = respuesta3;
    }

    public int getRespuesta4() {
        return respuesta4;
    }

    public void setRespuesta4(int respuesta4) {
        this.respuesta4 = respuesta4;
    }

    public int getRespuesta5() {
        return respuesta5;
    }

    public void setRespuesta5(int respuesta5) {
        this.respuesta5 = respuesta5;
    }

    public int getRespuesta6() {
        return respuesta6;
    }

    public void setRespuesta6(int respuesta6) {
        this.respuesta6 = respuesta6;
    }

    public int getRespuesta7() {
        return respuesta7;
    }

    public void setRespuesta7(int respuesta7) {
        this.respuesta7 = respuesta7;
    }

    public int getRespuesta8() {
        return respuesta8;
    }

    public void setRespuesta8(int respuesta8) {
        this.respuesta8 = respuesta8;
    }

    public int getRespuesta9() {
        return respuesta9;
    }

    public void setRespuesta9(int respuesta9) {
        this.respuesta9 = respuesta9;
    }

    public int getRespuesta10() {
        return respuesta10;
    }

    public void setRespuesta10(int respuesta10) {
        this.respuesta10 = respuesta10;
    }

    public int getRespuesta11() {
        return respuesta11;
    }

    public void setRespuesta11(int respuesta11) {
        this.respuesta11 = respuesta11;
    }

    public int getRespuesta12() {
        return respuesta12;
    }

    public void setRespuesta12(int respuesta12) {
        this.respuesta12 = respuesta12;
    }

    public int getRespuesta13() {
        return respuesta13;
    }

    public void setRespuesta13(int respuesta13) {
        this.respuesta13 = respuesta13;
    }

    public int getRespuesta14() {
        return respuesta14;
    }

    public void setRespuesta14(int respuesta14) {
        this.respuesta14 = respuesta14;
    }

    public int getRespuesta15() {
        return respuesta15;
    }

    public void setRespuesta15(int respuesta15) {
        this.respuesta15 = respuesta15;
    }

    public int getRespuesta16() {
        return respuesta16;
    }

    public void setRespuesta16(int respuesta16) {
        this.respuesta16 = respuesta16;
    }

    public int getRespuesta17() {
        return respuesta17;
    }

    public void setRespuesta17(int respuesta17) {
        this.respuesta17 = respuesta17;
    }

    public int getRespuesta18() {
        return respuesta18;
    }

    public void setRespuesta18(int respuesta18) {
        this.respuesta18 = respuesta18;
    }

    public int getRespuesta19() {
        return respuesta19;
    }

    public void setRespuesta19(int respuesta19) {
        this.respuesta19 = respuesta19;
    }

    public int getRespuesta20() {
        return respuesta20;
    }

    public void setRespuesta20(int respuesta20) {
        this.respuesta20 = respuesta20;
    }
}
