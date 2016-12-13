/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Excel.ParticipantesProyectoExcel;
import Mapeo.Participante;
import Modelo.ParticipanteDAO;
import Modelo.PruebaProyectoDAO;
import Modelo.RespuestaDAO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
/**
 *
 * @author Mixbaal
 */
public class ExportarExcel {
    
    @Autowired
    ParticipanteDAO participante_bd;
    
    @Autowired
    private RespuestaDAO respuesta_bd;
    
    @Autowired
    private PruebaProyectoDAO proyecto_bd;
    
    @RequestMapping(value="/reportes/ParticipantesProyectoExcel")
    public ParticipantesProyectoExcel ExportarEPE(Model model, HttpServletRequest
                                              request,@RequestParam(name = "p")long idproyecto){
        List<Participante> lp = participante_bd.participantesProyecto(idproyecto);
        model.addAttribute("idproyecto",idproyecto);
        model.addAttribute("listaParticipantes",lp);
        model.addAttribute("respuestabd",respuesta_bd);
        model.addAttribute("proyectobd",proyecto_bd);
        return new ParticipantesProyectoExcel();
    }
    
    @RequestMapping(value = "/error",method = RequestMethod.GET)
    public String render(){
        return "error403";
    }
    
}
