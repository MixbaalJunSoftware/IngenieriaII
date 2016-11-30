/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Mapeo.Persona;
import Mapeo.RAdaptabilidad;
import Mapeo.RClimaLaboral;
import Modelo.PersonaDAO;
import Modelo.RespuestaDAO;
import java.security.Principal;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author jonathan
 */
@Controller
public class CRespuesta {
    
    @Autowired
    private RespuestaDAO respuesta_db;
    
    @Autowired
    private PersonaDAO persona_db;
    
    
    @RequestMapping(value = "/participante/guardaPruebaAdapt", method = RequestMethod.POST)
    public String guardaAdaptabilidad(HttpServletRequest request,Principal principal){
        int i  =  Integer.parseInt(request.getParameter("r1"));
        Persona persona = persona_db.getPersona(principal.getName());
        RAdaptabilidad r = new RAdaptabilidad();
        Calendar fecha = Calendar.getInstance();
        Date date = fecha.getTime();
        r.setFechaRespuesta(date);
        r.setPersona(persona);
        r.setRespuesta1(Integer.parseInt(request.getParameter("r1")));
        r.setRespuesta2(Integer.parseInt(request.getParameter("r2")));
        r.setRespuesta3(Integer.parseInt(request.getParameter("r3")));
        r.setRespuesta4(Integer.parseInt(request.getParameter("r4")));
        r.setRespuesta5(Integer.parseInt(request.getParameter("r5")));
        r.setRespuesta6(Integer.parseInt(request.getParameter("r6")));
        r.setRespuesta7(Integer.parseInt(request.getParameter("r7")));
        r.setRespuesta8(Integer.parseInt(request.getParameter("r8")));
        r.setRespuesta9(Integer.parseInt(request.getParameter("r9")));
        r.setRespuesta10(Integer.parseInt(request.getParameter("r10")));
        r.setRespuesta11(Integer.parseInt(request.getParameter("r11")));
        r.setRespuesta12(Integer.parseInt(request.getParameter("r12")));
        r.setRespuesta13(Integer.parseInt(request.getParameter("r13")));
        r.setRespuesta14(Integer.parseInt(request.getParameter("r14")));
        r.setRespuesta15(Integer.parseInt(request.getParameter("r15")));
        r.setRespuesta16(Integer.parseInt(request.getParameter("r16")));
        r.setRespuesta17(Integer.parseInt(request.getParameter("r17")));
        r.setRespuesta18(Integer.parseInt(request.getParameter("r18")));
        r.setRespuesta19(Integer.parseInt(request.getParameter("r19")));
        r.setRespuesta20(Integer.parseInt(request.getParameter("r20")));
        r.setRespuesta21(Integer.parseInt(request.getParameter("r21")));
        r.setRespuesta22(Integer.parseInt(request.getParameter("r22")));
        r.setRespuesta23(Integer.parseInt(request.getParameter("r23")));
        r.setRespuesta24(Integer.parseInt(request.getParameter("r24")));
        r.setRespuesta25(Integer.parseInt(request.getParameter("r25")));
        r.setRespuesta26(Integer.parseInt(request.getParameter("r26")));
        r.setRespuesta27(Integer.parseInt(request.getParameter("r27")));
        r.setRespuesta28(Integer.parseInt(request.getParameter("r28")));
        r.setRespuesta29(Integer.parseInt(request.getParameter("r29")));
        r.setRespuesta30(Integer.parseInt(request.getParameter("r30")));
        respuesta_db.guardar(r);
        System.out.println(persona.getCorreo());
        System.out.println(i);
        System.out.println(date);
        return "PruebaTerminada";
    }
    
        @RequestMapping(value = "/participante/guardaPruebaClima", method = RequestMethod.POST)
    public String guardaClima(HttpServletRequest request,Principal principal){
        int i  =  Integer.parseInt(request.getParameter("r1"));
        Persona persona = persona_db.getPersona(principal.getName());
        RClimaLaboral r = new RClimaLaboral();
        Calendar fecha = Calendar.getInstance();
        Date date = fecha.getTime();
        r.setFechaRespuesta(date);
        r.setPersona(persona);
        r.setRespuesta1(Integer.parseInt(request.getParameter("r1")));
        r.setRespuesta2(Integer.parseInt(request.getParameter("r2")));
        r.setRespuesta3(Integer.parseInt(request.getParameter("r3")));
        r.setRespuesta4(Integer.parseInt(request.getParameter("r4")));
        r.setRespuesta5(Integer.parseInt(request.getParameter("r5")));
        r.setRespuesta6(Integer.parseInt(request.getParameter("r6")));
        r.setRespuesta7(Integer.parseInt(request.getParameter("r7")));
        r.setRespuesta8(Integer.parseInt(request.getParameter("r8")));
        r.setRespuesta9(Integer.parseInt(request.getParameter("r9")));
        r.setRespuesta10(Integer.parseInt(request.getParameter("r10")));
        r.setRespuesta11(Integer.parseInt(request.getParameter("r11")));
        r.setRespuesta12(Integer.parseInt(request.getParameter("r12")));
        r.setRespuesta13(Integer.parseInt(request.getParameter("r13")));
        r.setRespuesta14(Integer.parseInt(request.getParameter("r14")));
        r.setRespuesta15(Integer.parseInt(request.getParameter("r15")));
        r.setRespuesta16(Integer.parseInt(request.getParameter("r16")));
        r.setRespuesta17(Integer.parseInt(request.getParameter("r17")));
        r.setRespuesta18(Integer.parseInt(request.getParameter("r18")));
        r.setRespuesta19(Integer.parseInt(request.getParameter("r19")));
        r.setRespuesta20(Integer.parseInt(request.getParameter("r20")));
        respuesta_db.guardar(r);
        System.out.println(persona.getCorreo());
        System.out.println(i);
        System.out.println(date);
        return "PruebaTerminada";
    }
    
}