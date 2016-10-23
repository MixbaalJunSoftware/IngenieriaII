/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Mapeo.Empleado;
import Mapeo.Persona;
import Mapeo.Usuario;
import Modelo.EmpleadoDAO;
import Modelo.PersonaDAO;
import Modelo.UsuarioDAO;
import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Mixbaal
 */
@Controller
public class CRUDEmpleado {
    //Instancia para operaciones con la base relacionadas con el empleado
    @Autowired
    private EmpleadoDAO empleado_bd;
    
    //Instancia para operaciones con la base relacionadas con una persona
    @Autowired
    private PersonaDAO persona_bd;
    
    //Instancia para operaciones con la base relacionadas con un Usuario
    @Autowired
    private UsuarioDAO usuario_bd;
    
    /**
     * Método para desplegar la vista de opciones
     */
    @RequestMapping(value = "/opcionesEmpleado")
    public String opcionesEmpleado(){
        return "Opciones";
    }
    
    @RequestMapping(value= "/cliente/crear-empleadoCorreo", method = RequestMethod.POST)
    public String creaEmpleadoCorreo(ModelMap model,HttpServletRequest request){
        Persona persona = new Persona();
        Usuario usuario = new Usuario();
        String correo = request.getParameter("correo");
        Persona p = persona_bd.getPersona(correo);
        if(p==null){
            persona.setCorreo(correo);
            usuario.setPersona(persona);
            usuario.setRol("ROLE_EMPLEADO");
            persona_bd.guardar(persona);
            usuario_bd.guardar(usuario);
            return "CorreoCorrecto";
        }else{
            return "CorreoRegistrado";
        }
    }
    
    /**
     * Realiza la funcionalidad para agregar un cliente a la base de datos
     * @param model
     * @param request
     * @return 
     */
    @RequestMapping(value= "/completarRegistro-empleado", method = RequestMethod.POST)
    public String completarRegistroEmpleado(ModelMap model,HttpServletRequest request){
        String correo = request.getParameter("correo");
        Persona persona = persona_bd.getPersona(correo);
        Empleado empleado = new Empleado();
        Usuario usuario = new Usuario();
        String password = request.getParameter("pass");
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
        String puesto = request.getParameter("puesto");
      
        persona.setNombre(nombre);
        persona.setApp(app);
        persona.setApm(apm);
        persona.setFecha_nac(fecha);
        persona.setGenero(genero);
        persona.setTelefono(telefono);
        persona.setCelular(celular);
        empleado.setPersona(persona);
        empleado.setPuestoempleado(puesto);
        usuario.setPersona(persona);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hash_password = passwordEncoder.encode(password) ;
        usuario.setContrasenia(hash_password);
        //usuario.setRol("ROLE_EMPLEADO");
        persona_bd.actualizar(persona);
        empleado_bd.guardar(empleado);
        usuario_bd.actualizar(usuario);
        return "Ok";   
    }
    
    
    /**
     * Metodo Auxiliar para probar el caso de uso Actualizar
     * @param model
     * @param request
     * @return 
     */
    @RequestMapping(value= "/empleado/previoActualizarEmpleado", method = RequestMethod.GET)
    public ModelAndView previoActualizarEmpleado(ModelMap model,HttpServletRequest request, Principal principal){ 
        /**
        Persona persona = persona_bd.getPersona(principal.getName());
        model.addAttribute("persona", persona);
        if(persona == null)
            return new ModelAndView("error403",model);
        */
        return new ModelAndView("EditarEmpleado",model);
    }
    
    
    /**
     * 
     * @param request
     * @return 
     */
    @RequestMapping(value= "/empleado/actualizar-empleado", method = RequestMethod.POST)
    public String actualizaEmpleado(HttpServletRequest request, Principal principal){
        Persona persona = persona_bd.getPersona(principal.getName());
        long id = persona.getIdPersona();
        Empleado empleado = empleado_bd.getEmpleado(id);
        Usuario usuario = usuario_bd.getUsuario(id);
        String puesto = request.getParameter("puesto");
        String telefono = request.getParameter("tel");
        String celular = request.getParameter("cel");
        String pasword = request.getParameter("newpass");
        if(!puesto.equals(""))
            empleado.setPuestoempleado(puesto);
        if(!telefono.equals(""))
            persona.setTelefono(telefono);
        if(!celular.equals(""))
            persona.setCelular(celular);
        if(!pasword.equals("")){
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String hash_password = passwordEncoder.encode(pasword) ;
            usuario.setContrasenia(hash_password);
        }
        persona_bd.actualizar(persona);
        empleado_bd.actualizar(empleado);
        usuario_bd.actualizar(usuario);
        return "Ok";   
    }
    
    /**
     * Metodo Auxiliar para poder contestar la prueba
     * @param model
     * @param request
     * @return 
     */
    @RequestMapping(value= "/empleado/contestarPrueba", method = RequestMethod.POST)
    public ModelAndView contestarPrueba(ModelMap model,HttpServletRequest request, Principal principal){   
        Persona persona = persona_bd.getPersona(principal.getName());
        model.addAttribute(persona);
        return new ModelAndView("PruebaAL",model);
    }
    
    
    
    
    
    
}
