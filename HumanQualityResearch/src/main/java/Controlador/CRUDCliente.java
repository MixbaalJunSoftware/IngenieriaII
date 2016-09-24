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
 * @version 1.0
 * Clase para el controlador de las operaciones relacionadas con el CRUD
 * del cliente
 * 
 */
@Controller
public class CRUDCliente {
    //Instancia para operaciones con la base relacionadas con el cliente
    @Autowired
    private ClienteDAO cliente_bd;
    
    //Instancia para operaciones con la base relacionadas con una persona
    @Autowired
    private PersonaDAO persona_bd;
    
    /**
     * Metodo para desplegar la vista de inicio
     */
    @RequestMapping(value = "/")
    public String login(){
        return "pruebaEdita";
    }
    
    
    /**
     * Metodo Auxiliar para probar el caso de uso Actualizar
     * @param model
     * @param request
     * @return 
     */
    @RequestMapping(value= "/prueba-actualiza-cliente", method = RequestMethod.POST)
    public ModelAndView previoActualizar(ModelMap model,HttpServletRequest request){   
        model.addAttribute("id", Long.parseLong(request.getParameter("id")));
        return new ModelAndView("EditarCliente",model);
    }
    
    /**
     * 
     * @param request
     * @return 
     */
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
    
    /**
     * Metodo para mostrar la informacion de un Cliente
     * Pone los paramentros en el model de la pagina a mostrar
     * @param model
     * @param request
     * @return 
     */
    @RequestMapping(value= "/muestra-cliente", method = RequestMethod.POST)
    public ModelAndView mostrarCliente(ModelMap model,HttpServletRequest request){   
        long id = Long.parseLong(request.getParameter("id"));
        Cliente cliente = cliente_bd.getCliente(id);
        model.addAttribute("nombre",cliente.getPersona().getNombre());
        model.addAttribute("app",cliente.getPersona().getApp());
        model.addAttribute("apm",cliente.getPersona().getApm());
        model.addAttribute("fecha",cliente.getPersona().getFecha_nac().toString());
        model.addAttribute("genero",cliente.getPersona().getGenero());
        model.addAttribute("correo",cliente.getPersona().getCorreo());
        model.addAttribute("telefono",cliente.getPersona().getTelefono());
        model.addAttribute("celular",cliente.getPersona().getCelular());
        model.addAttribute("empresa",cliente.getEmpresa());
        model.addAttribute("puesto",cliente.getPuestoCliente());
        return new ModelAndView("MostrarCliente",model);
    }
    
}
