/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Mapeo.Persona;
import Mapeo.Respuesta;
import Modelo.PersonaDAO;
import Modelo.RespuestaDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author jonathan
 */
@Controller
public class CRespuesta {
    
    @Autowired
    private RespuestaDAO respuesta_db;
    
    @Autowired
    private PersonaDAO persona_bd;
    
    @RequestMapping(value = "/guardaPrueba")
    public String guardaPrueba(){
        Persona persona = persona_bd.getPersona(8);
        Respuesta r = new Respuesta();
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-mm-dd"); 
        String f = "1995-03-16";
        Date fecha = null;
        try{
        fecha = ft.parse(f);
        }
        catch(ParseException e){
            System.out.println("hola");
        }
        r.setFechaRespuesta(fecha);
        r.setPersona(persona);
        r.setRespuesta1(1);
        r.setRespuesta2(1);
        r.setRespuesta3(1);
        r.setRespuesta4(1);
        r.setRespuesta5(1);
        r.setRespuesta6(1);
        r.setRespuesta7(1);
        r.setRespuesta8(1);
        r.setRespuesta9(1);
        r.setRespuesta10(1);
        r.setRespuesta11(1);
        r.setRespuesta12(1);
        r.setRespuesta13(1);
        r.setRespuesta14(1);
        r.setRespuesta15(1);
        r.setRespuesta16(1);
        r.setRespuesta17(1);
        r.setRespuesta18(1);
        r.setRespuesta19(1);
        r.setRespuesta20(1);
        r.setRespuesta21(1);
        r.setRespuesta22(1);
        r.setRespuesta23(1);
        r.setRespuesta24(1);
        r.setRespuesta25(1);
        r.setRespuesta26(1);
        r.setRespuesta27(1);
        r.setRespuesta28(1);
        r.setRespuesta29(1);
        r.setRespuesta30(1);
        respuesta_db.guardar(r);
        return "Ok";
    }
    
}
