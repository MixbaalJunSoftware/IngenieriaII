/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Mapeo.Cliente;
import Modelo.ClienteDAO;
import Modelo.PersonaDAO;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Mixbaal
 */
@Controller
public class CRUDCliente {
    
    @Autowired
    private ClienteDAO cliente_bd;
    
    @Autowired
    private PersonaDAO persona_bd;
    
    @RequestMapping(value = "/")
    public String login(){
        return "pruebaEdita";
    }
    
    @RequestMapping(value= "/prueba-actualiza-cliente", method = RequestMethod.POST)
    public ModelAndView previoActualizar(ModelMap model,HttpServletRequest request){   
        model.addAttribute("id", Long.parseLong(request.getParameter("id")));
        return new ModelAndView("EditarCliente",model);
    }
    
    @RequestMapping(value= "/actualizar-cliente", method = RequestMethod.POST)
    public String actualizaCliente(HttpServletRequest request){
        long id = Long.parseLong(request.getParameter("idcliente"));
        Cliente cliente = cliente_bd.getCliente(id);
        String puesto = request.getParameter("puesto");
        String telefono = request.getParameter("tel");
        String celular = request.getParameter("cel");
        String correo = request.getParameter("correo");
        if(!puesto.equals(""))
            cliente.setPuestoCliente(puesto);
        if(!telefono.equals(""))
            cliente.getPersona().setTelefono(telefono);
        if(!celular.equals(""))
            cliente.getPersona().setCelular(celular);
        if(!correo.equals(""))
            cliente.getPersona().setCorreo(correo);
        persona_bd.actualizar(cliente.getPersona());
        cliente_bd.actualizar(cliente);
        return "Ok";   
    }
    
}
