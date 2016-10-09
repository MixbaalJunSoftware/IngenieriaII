/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ProyectoDAO;
import Modelo.PertenecerDAO;
import Modelo.PersonaDAO;
import Modelo.TipoDAO;
import Modelo.ClienteDAO;
import Mapeo.Persona;
import Mapeo.Proyecto;
import Mapeo.Tipo;
import Mapeo.Cliente;
import Mapeo.Pertenecer;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Mixbaal
 * @version 1.0
 * Clase para el controlador de las operaciones relacionadas con el CRUD
 * del proyecto
 * 
 */
@Controller
public class CRUDProyecto {
    //Instancia para operaciones con la base relacionadas con el proyecto
    @Autowired
    private ProyectoDAO proyecto_db;
    
    @Autowired
    private PertenecerDAO pertenecer_db;
    
    @Autowired
    private PersonaDAO persona_db;
            
    @Autowired
    private ClienteDAO cliente_db;
    
    @Autowired
    private TipoDAO tipo_db;
    
    /**
     * Metodo para desplegar la vista de CrearCliente
     */
    @RequestMapping(value = "/creaProyecto")
    public String muestraCreaProyecto(){
        return "CrearProyecto";
    }
    
    /**
     * Realiza la funcionalidad para agregar un proyecto a la base de datos
     * @param request
     * @return 
     */
     @RequestMapping(value= "/crear-proyecto", method = RequestMethod.POST)
     public String creaProyecto(HttpServletRequest request){
         Proyecto proyecto = new Proyecto();
         Pertenecer pertenecer = new Pertenecer();
         //TipoDAO tipo_db = new TipoDAO();
         Tipo dtipo = new Tipo();
         String correo = request.getParameter("correo");
         Persona persona = persona_db.getPersona(correo);
         if(persona==null)
             return "ClienteNoEncontrado";
         String area = request.getParameter("area");
         String tipop = request.getParameter("tipo");
         String codigo = creaCodigo(persona,tipop);
         proyecto.setAreaProyecto(area);
         proyecto.setCodigo(codigo);
         pertenecer.setPersona(persona);
         pertenecer.setProyecto(proyecto);
         dtipo.setTipo(tipop);
         proyecto.setTipo(dtipo);
         System.out.print(dtipo.getTipo());
         tipo_db.guardar(dtipo);
         proyecto_db.guardar(proyecto);
         pertenecer_db.guardar(pertenecer);         
         return "Ok";         
     }
     
     public String creaCodigo(Persona persona, String tipo){
         Cliente cliente = cliente_db.getCliente(persona.getIdPersona());
         String empresa = cliente.getEmpresa();
         StringBuilder sb = new StringBuilder();
         sb.append(empresa.charAt(0));
         sb.append(empresa.charAt(1));
         sb.append(empresa.charAt(2));
         sb.append(persona.getNombre().charAt(0));
         sb.append(persona.getApp().charAt(0));
         sb.append(persona.getApm().charAt(0));
         String codigo = sb.toString();
         codigo+=tipo;
         codigo.toUpperCase();
         Calendar fecha = new GregorianCalendar();
         int anio = fecha.get(Calendar.YEAR);
         int mes = fecha.get(Calendar.MONTH);
         int dia = fecha.get(Calendar.DAY_OF_MONTH);
         codigo+=String.valueOf(dia)+String.valueOf(mes)+String.valueOf(anio);
         return codigo;  
     
     }
     
      /**
     * Metodo para mostrar la informacion de los Proyectos
     * Pone los paramentros en el model de la pagina a mostrar
     * @param model
     * @param request
     * @return 
     */
    @RequestMapping(value= "/ver-proyectos", method = RequestMethod.POST)
    public ModelAndView verProyectos(ModelMap model,HttpServletRequest request){   
        List<Proyecto> lp = proyecto_db.proyectos();
        model.addAttribute("lista",lp);
        return new ModelAndView("Proyectos",model);
    }
    
    /**
     * Metodo Auxiliar para probar el caso de uso Actualizar
     * @param model
     * @param request
     * @return 
     */
    @RequestMapping(value= "/jactualizar-proyecto", method = RequestMethod.POST)
    public ModelAndView previoActualizar(ModelMap model,HttpServletRequest request){ 
        System.out.print(request.getParameter("idproyecto"));
        long id = Long.parseLong(request.getParameter("idproyecto"));
        Proyecto proyecto = proyecto_db.getProyecto(id);
        model.addAttribute("proyecto", proyecto);
        if(proyecto == null)
            return new ModelAndView("ClienteNoEncontrado",model);
        return new ModelAndView("EditarProyecto",model);
    }
    
    /**
     * Metodo que realiza la actualizacion de un Proyecto
     * @param request
     * @return 
     */
    @RequestMapping(value= "/editar-proyecto", method = RequestMethod.POST)
    public String editarProyecto(HttpServletRequest request){
        long id = Long.parseLong(request.getParameter("idproyecto"));
        Proyecto proyecto = proyecto_db.getProyecto(id);
        Tipo tipo = proyecto.getTipo();
        Pertenecer pertenecer = pertenecer_db.getPertenecer(id);
        String correo = request.getParameter("correo");
        String area = request.getParameter("area");
        String stipo = request.getParameter("tipo");
        if(!correo.equals("")){
            Persona persona = persona_db.getPersona(correo);
            if(persona == null)
                return "ClienteNoEncontrado";
            pertenecer.setPersona(persona);
            String codigo = creaCodigo(persona, tipo.getTipo());
            proyecto.setCodigo(codigo);
        }    
        if(!area.equals(""))
            proyecto.setAreaProyecto(area);
        if(!stipo.equals("")){
            tipo.setTipo(stipo);
            String codigo2 = creaCodigo(pertenecer.getPersona(), tipo.getTipo());
            proyecto.setCodigo(codigo2);
        }
        proyecto_db.actualizar(proyecto);
        pertenecer_db.actualizar(pertenecer);
        tipo_db.actualizar(tipo);
        return "Ok";   
    }
    
    /**
     * Metodo para eliminar un proyecto de la base de datos
     * @param model
     * @param request
     * @return 
     */
    @RequestMapping(value= "/elimina-proyecto", method = RequestMethod.POST)
    public String eliminaProyecto(ModelMap model,HttpServletRequest request){   
        long id = Long.parseLong(request.getParameter("idproyecto"));
        Proyecto proyecto = proyecto_db.getProyecto(id);
        Pertenecer pertenecer = pertenecer_db.getPertenecer(id);
        Tipo tipo = proyecto.getTipo();
        tipo_db.eliminar(tipo);
        pertenecer_db.eliminar(pertenecer);
        proyecto_db.eliminar(proyecto);
        return "Ok";
    }
    
}