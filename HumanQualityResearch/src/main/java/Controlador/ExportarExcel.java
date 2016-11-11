/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Excel.EmpleadosProyectoExcel;
import Mapeo.Empleado;
import Modelo.EmpleadoDAO;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
/**
 *
 * @author Mixbaal
 */
public class ExportarExcel {
    
    @Autowired
    EmpleadoDAO empleado_bd;
    
    @RequestMapping(value="/cliente/EmpleadosProyectoExcel")
    public EmpleadosProyectoExcel ExportarEPE(Model model, HttpServletRequest
                                              request,@RequestParam(name = "p")long idproyecto){
        List<Empleado> lp = empleado_bd.empleadosProyecto(idproyecto);
        model.addAttribute("listaEmpleados",lp);
        return new EmpleadosProyectoExcel();
    }
    
    @RequestMapping(value = "/pdf",method = RequestMethod.POST)
    public ModelAndView renderPDF(ModelMap model,HttpServletRequest request,HttpServletResponse response) throws Exception {
        model.addAttribute("customerName", "XYZ");
        return  new ModelAndView("invoicePDF",model);
    }
    
    @RequestMapping(value = "/error",method = RequestMethod.GET)
    public String render(){
        return "error403";
    }
    
}
