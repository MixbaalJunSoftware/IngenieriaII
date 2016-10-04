/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Mapeo.Cliente;
import Mapeo.Persona;
import Mapeo.Usuario;
import Modelo.ClienteDAO;
import Modelo.PersonaDAO;
import Modelo.UsuarioDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    
    //Instancia para operaciones con la base relacionadas con un Usuario
    @Autowired
    private UsuarioDAO usuario_bd;
    
    
    /**
     * Metodo para desplegar la vista de CrearCliente
     */
    @RequestMapping(value = "/creaCliente")
    public String muetraCreaCliente(){
        return "CrearCliente";
    }
    
    /**
     * Método para desplegar la vista de opciones
     */
    @RequestMapping(value = "/opciones")
    public String opciones(){
        return "Opciones";
    }
    /**
     * Realiza la funcionalidad para agregar un cliente a la base de datos
     * @param request
     * @return 
     */
    @RequestMapping(value= "/crear-cliente", method = RequestMethod.POST)
    public String creaCliente(HttpServletRequest request){
        Persona persona = new Persona();
        Cliente cliente = new Cliente();
        Usuario usuario = new Usuario();
        String correo = request.getParameter("correo");
        if(persona_bd.getPersona(correo)!= null){
            return "CorreoRegistrado";
        }
        String pasword = request.getParameter("pass");
        String nombre = request.getParameter("nombre");
        String app = request.getParameter("app");
        String apm = request.getParameter("apm");
        SimpleDateFormat ft = new SimpleDateFormat ("dd-mm-yyyy"); 
        Date fecha = null;
        try {
            fecha = ft.parse(request.getParameter("fecha"));  
        }catch (ParseException e) { 
             System.out.println("Unparseable using " + ft); 
        }
        String genero = request.getParameter("genero");
        String telefono = request.getParameter("telefono");
        String celular = request.getParameter("celular");
        String empresa = request.getParameter("empresa");
        String puesto = request.getParameter("puesto");
        String area = request.getParameter("area");
        persona.setNombre(nombre);
        persona.setApp(app);
        persona.setApm(apm);
        persona.setFecha_nac(fecha);
        persona.setGenero(genero);
        persona.setCorreo(correo);
        persona.setTelefono(telefono);
        persona.setCelular(celular);
        cliente.setEmpresa(empresa);
        cliente.setPuestoCliente(puesto);
        cliente.setAreaCliente(area);
        cliente.setPersona(persona);
        usuario.setContrasenia(pasword);
        usuario.setPersona(persona);
        persona_bd.guardar(persona);
        cliente_bd.guardar(cliente);
        usuario_bd.guardar(usuario);
        return "Ok";   
    }
    
    
    /**
     * Metodo Auxiliar para probar el caso de uso Actualizar
     * @param model
     * @param request
     * @return 
     */
    @RequestMapping(value= "/prueba-actualiza-cliente", method = RequestMethod.POST)
    public ModelAndView previoActualizar(ModelMap model,HttpServletRequest request){   
        long id = Long.parseLong(request.getParameter("id"));
        Usuario usuario = usuario_bd.getUsuario(id);
        model.addAttribute("usuario", usuario);
        if(usuario == null)
            return new ModelAndView("ClienteNoEncontrado",model);
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
        Usuario usuario = usuario_bd.getUsuario(id);
        String puesto = request.getParameter("puesto");
        String area = request.getParameter("area");
        String telefono = request.getParameter("tel");
        String celular = request.getParameter("cel");
        String pasword = request.getParameter("newpass");
        if(!puesto.equals(""))
            cliente.setPuestoCliente(puesto);
        if(!area.equals(""))
            cliente.setAreaCliente(area);
        if(!telefono.equals(""))
            cliente.getPersona().setTelefono(telefono);
        if(!celular.equals(""))
            cliente.getPersona().setCelular(celular);
        if(!pasword.equals(""))
            usuario.setContrasenia(pasword);
        persona_bd.actualizar(cliente.getPersona());
        cliente_bd.actualizar(cliente);
        usuario_bd.actualizar(usuario);
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
        boolean existe = cliente != null;
        model.addAttribute("existe",existe);
        if(!existe)
            return new ModelAndView("ClienteNoEncontrado",model);
        model.addAttribute("id",id);
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
        model.addAttribute("area",cliente.getAreaCliente());
        return new ModelAndView("MostrarCliente",model);
    }
    
    /**
     * Metodo para eliminar un cliente de la base de datos
     * @param model
     * @param request
     * @return 
     */
    @RequestMapping(value= "/elimina-cliente", method = RequestMethod.POST)
    public String eliminaCliente(ModelMap model,HttpServletRequest request){   
        long id = Long.parseLong(request.getParameter("id"));
        Cliente cliente = cliente_bd.getCliente(id);
        Usuario usuario = usuario_bd.getUsuario(id);
        Persona persona = cliente.getPersona();
        cliente_bd.eliminar(cliente);
        persona_bd.eliminar(persona);
        usuario_bd.eliminar(usuario);
        return "Ok";
    }
    
}
