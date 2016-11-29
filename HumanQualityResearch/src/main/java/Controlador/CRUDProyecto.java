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
import Modelo.PruebaProyectoDAO;
import Mapeo.Persona;
import Mapeo.Proyecto;
import Mapeo.Tipo;
import Mapeo.Cliente;
import Mapeo.Pertenecer;
import Mapeo.PruebaProyecto;
import java.security.Principal;
import java.util.Calendar;
import java.util.Date;
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
    
    @Autowired
    private PruebaProyectoDAO pruebap_db;
    
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
     @RequestMapping(value= "/cliente/crear-proyecto", method = RequestMethod.POST)
     public String creaProyecto(HttpServletRequest request, Principal principal){
         Proyecto proyecto = new Proyecto();
         Pertenecer pertenecer = new Pertenecer();
         //TipoDAO tipo_db = new TipoDAO();
         Tipo dtipo = new Tipo();
         Persona persona = persona_db.getPersona(principal.getName());
         String area = request.getParameter("area");
         String tipop = request.getParameter("tipo");
         String adapt = request.getParameter("adapt");
         String clima =request.getParameter("clima");
         String codigo = creaCodigo(persona,tipop);
         proyecto.setAreaProyecto(area);
         proyecto.setCodigo(codigo);
         proyecto.setActivo(true);
         pertenecer.setPersona(persona);
         pertenecer.setProyecto(proyecto);
         dtipo.setTipo(tipop);
         proyecto.setTipo(dtipo);
         System.out.print(dtipo.getTipo());
         tipo_db.guardar(dtipo);
         proyecto_db.guardar(proyecto);
         int i = 0;
         if(adapt!=null)
             proyecto_db.agregaPrueba(proyecto.getIdProyecto(), 1);
         else
             i=1/0;
         if(clima!=null)
             proyecto_db.agregaPrueba(proyecto.getIdProyecto(), 2);
         pertenecer_db.guardar(pertenecer);
         return "Ok";         
     }
     
     public String creaCodigo(Persona persona, String tipo){
         Cliente cliente = cliente_db.getCliente(persona.getIdPersona());
         String empresa = cliente.getPersona().getEmpresa();
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
         String codigof = codigo.replaceAll("\\s","");
         return codigof;  
     
     }
     
    /**
     * Metodo para mostrar la informacion de los Proyectos
     * Pone los paramentros en el model de la pagina a mostrar
     * @param model
     * @param request
     * @return 
     */
    @RequestMapping(value= "/cliente/ver-proyectos", method = RequestMethod.GET)
    public ModelAndView verProyectos(ModelMap model,HttpServletRequest request, Principal principal){   
        Persona persona = persona_db.getPersona(principal.getName());
        List<Proyecto> lp = proyecto_db.proyectosCliente(persona.getIdPersona());
        model.addAttribute("lista",lp);
        return new ModelAndView("ProyectosCliente",model);
    }
    
    /**
     * Metodo para mostrar la informacion de los Proyectos
     * Pone los paramentros en el model de la pagina a mostrar
     * @param model
     * @param request
     * @return 
     */
    @RequestMapping(value= "/admin/ver-proyectos", method = RequestMethod.GET)
    public ModelAndView verProyectosAdmin(ModelMap model,HttpServletRequest request){  
        long id = Long.parseLong(request.getParameter("idcliente"));
        List<Proyecto> lp = proyecto_db.proyectosCliente(id);
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
    @RequestMapping(value= "/admin/elimina-proyecto", method = RequestMethod.POST)
    public String eliminaProyecto(ModelMap model,HttpServletRequest request){   
        long id = Long.parseLong(request.getParameter("id"));
        System.out.print(id);
        Proyecto proyecto = proyecto_db.getProyecto(id);
        List<Pertenecer> lpertenecer = pertenecer_db.listPertenecer(id);
        List<PruebaProyecto> pruebap = pruebap_db.getPruebasProyecto(id);
        for(Pertenecer p : lpertenecer){
            pertenecer_db.eliminar(p);
        }
        for (PruebaProyecto pp: pruebap){
            pruebap_db.eliminar(pp);
        }
        proyecto_db.eliminar(proyecto);
        return "Ok";
        
        
    }
    
    /**
     * Metodo para hacer el borrado lógico un proyecto de la base de datos
     * @param model
     * @param request
     * @return 
     */
    @RequestMapping(value= "/borradol-proyecto", method = RequestMethod.POST)
     public String borradolProyecto(ModelMap model,HttpServletRequest request){   
        long id = Long.parseLong(request.getParameter("idproyecto"));
        System.out.print(id);
        Calendar fecha = Calendar.getInstance();
        Date date = fecha.getTime();
        Proyecto proyecto = proyecto_db.getProyecto(id);
        proyecto.setFborrado(date);
        proyecto.setActivo(false);
        proyecto_db.actualizar(proyecto);
        return "Ok";
     }
     
     @RequestMapping(value= "/muestra-proyecto", method = RequestMethod.GET)
    public ModelAndView mostrarCliente(ModelMap model,HttpServletRequest request){   
        long id = Long.parseLong(request.getParameter("idproyecto"));
        System.out.print(id);
        Proyecto proyecto = proyecto_db.getProyecto(id);
        boolean existe = proyecto != null;
        model.addAttribute("existe",existe);
        if(!existe)
            return new ModelAndView("error403",model);
        Cliente cliente = proyecto_db.getCliente(id);
        Tipo tipo = proyecto.getTipo();
        model.addAttribute("id",id);
        model.addAttribute("codigo",proyecto.getCodigo());
        model.addAttribute("area", proyecto.getAreaProyecto());
        model.addAttribute("tipo", tipo.getTipo());
        model.addAttribute("nombre",cliente.getPersona().getNombre());
        model.addAttribute("app",cliente.getPersona().getApp());
        model.addAttribute("apm",cliente.getPersona().getApm());
        return new ModelAndView("MuestraProyecto",model);
    }
    
    @RequestMapping(value= "/admin/ver-eproyectos", method = RequestMethod.GET)
    public ModelAndView verProyectosE(ModelMap model,HttpServletRequest request){ 
        List<Proyecto> c = proyecto_db.proyectosEliminados();
        model.addAttribute("lista",c);
        return new ModelAndView("ProyectosEliminados",model);
    }
    
    @RequestMapping(value= "/admin/recuperar-proyecto", method = RequestMethod.POST)
    public String recuperarProyecto(ModelMap model,HttpServletRequest request){   
        long id = Long.parseLong(request.getParameter("id"));
        Proyecto proyecto = proyecto_db.getProyecto(id);
        proyecto.setActivo(true);
        proyecto_db.actualizar(proyecto);        
        return "Ok";
    }
}
