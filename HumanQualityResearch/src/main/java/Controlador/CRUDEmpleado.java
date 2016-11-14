/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Mapeo.Empleado;
import Mapeo.Persona;
import Mapeo.Pertenecer;
import Mapeo.Proyecto;
import Mapeo.Usuario;
import Modelo.EmpleadoDAO;
import Modelo.PersonaDAO;
import Modelo.PertenecerDAO;
import Modelo.ProyectoDAO;
import Modelo.UsuarioDAO;
import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
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
    
    //Instancia para operaciones con la base relacionadas con un proyecto
    @Autowired
    private ProyectoDAO proyecto_bd;
    
     //Instancia para operaciones con la base relacionadas con pertenecer
    @Autowired
    private PertenecerDAO pertenecer_bd;
    
    /**
     * Método para desplegar la vista de opciones
     */
    @RequestMapping(value = "/opcionesEmpleado")
    public String opcionesEmpleado(){
        return "Opciones";
    }
    
    @Autowired
    JavaMailSender mail_sender;
    
    private MimeMessagePreparator construirEmail(String contextPath, final String correo) {
        
        final String texto = "Tu correo ha sido dado de alta en HumanQualityResearch\n"
                           + "Ingresa al sitio par terminar tu registro y\n"
                           + "empezar a usar el sitio";
        final String url = contextPath;// + "/crear-cliente/correo?id=" +correo;
        
        MimeMessagePreparator message_preparator = new MimeMessagePreparator() {
 
            @Override
            public void prepare(MimeMessage mime_message) throws Exception {
                mime_message.setFrom("");
                mime_message.setRecipient(Message.RecipientType.TO,
                        new InternetAddress(correo));
                mime_message.setText(texto + "\n" + url);
                mime_message.setSubject("Temina tu registro");
            }
        };
        
        return message_preparator;        
    }
    
    @RequestMapping(value= "/cliente/crear-empleadoCorreo", method = RequestMethod.POST)
    public String creaEmpleadoCorreo(ModelMap model,HttpServletRequest request){
        Persona persona = new Persona();
        Usuario usuario = new Usuario();
        Proyecto proyecto = null;
        Pertenecer pertenecer = new Pertenecer();
        Empleado empleado = new Empleado();
        String correo = request.getParameter("correo");
        System.out.print(correo);
        long id = Long.parseLong(request.getParameter("idproyectoCrea"));
        proyecto = proyecto_bd.getProyecto(id);
        Persona p = persona_bd.getPersona(correo);
        if(p==null){
            persona.setCorreo(correo);
            usuario.setPersona(persona);
            pertenecer.setPersona(persona);
            pertenecer.setProyecto(proyecto);
            empleado.setPersona(persona);
            usuario.setRol("ROLE_EMPLEADO");
            persona_bd.guardar(persona);
            usuario_bd.guardar(usuario);
            pertenecer_bd.guardar(pertenecer);
            empleado_bd.guardar(empleado);
            String url = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
            mail_sender.send(construirEmail(url,correo));
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
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-mm-dd"); 
        Date fecha = null;
        String f = request.getParameter("fecha3") +"-"+request.getParameter("fecha2")+"-"+request.getParameter("fecha1"); 
        System.out.println(f);
        try {
            fecha = ft.parse(f);    
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
        usuario.setRol("ROLE_EMPLEADO");
        persona_bd.actualizar(persona);
        empleado_bd.actualizar(empleado);
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
        String pasword = request.getParameter("rpass");
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
        usuario.setRol("ROLE_EMPLEADO");
        persona_bd.actualizar(persona);
        empleado_bd.actualizar(empleado);
        usuario_bd.actualizar(usuario);
        return "Ok";   
    }
    
    
    /**
     * Metodo para mostrar la informacion de los Proyectos
     * Pone los paramentros en el model de la pagina a mostrar
     * @param model
     * @param request
     * @return 
     */
    @RequestMapping(value= "/cliente/ver-empleados", method = RequestMethod.POST)
    public ModelAndView verEmpleadosCliente(ModelMap model,HttpServletRequest request){ 
        long id = Long.parseLong(request.getParameter("idproyecto"));
        List<Empleado> lp = empleado_bd.empleadosProyecto(id);
        model.addAttribute("lista",lp);
        System.out.println(lp+"hola");
        return new ModelAndView("cEmpleados",model);
    }
    
    /**
     * Metodo para mostrar la informacion de los Proyectos
     * Pone los paramentros en el model de la pagina a mostrar
     * @param model
     * @param request
     * @return 
     */
    @RequestMapping(value= "/ver-empleados", method = RequestMethod.POST)
    public ModelAndView verEmpleadosAdmin(ModelMap model,HttpServletRequest request){  
        long id = Long.parseLong(request.getParameter("idproyecto"));
        List<Empleado> lp = empleado_bd.empleadosProyecto(id);
        model.addAttribute("listaEmpleados",lp);
        model.addAttribute("idProyecto",id);
        return new ModelAndView("Empleados",model);
    }
    
    /**
     * Metodo Auxiliar para poder contestar la prueba
     * @param model
     * @param request
     * @return 
     */
    @RequestMapping(value= "/empleado/contestarPrueba", method = RequestMethod.GET)
    public ModelAndView contestarPrueba(ModelMap model,HttpServletRequest request, Principal principal){   
        return new ModelAndView("PruebaAL",model);
    }
    
    
    /**
     * Metodo para eliminar un empleado de la base de datos
     * @param model
     * @param request
     * @return 
     */
    @RequestMapping(value= "/elimina-participante", method = RequestMethod.POST)
    public String eliminaParticipante(ModelMap model,HttpServletRequest request){   
        long id = Long.parseLong(request.getParameter("id"));
        Empleado empleado = empleado_bd.getEmpleado(id);
        Usuario usuario = usuario_bd.getUsuario(id);
        Persona persona = empleado.getPersona();
        empleado_bd.eliminar(empleado);
        persona_bd.eliminar(persona);
        usuario_bd.eliminar(usuario);
        return "Ok";
    }
    
    /**
      * Método para hacer el borrado lógico de la base de datos
      * @param model
      * @param request
      * @return 
      */
    
    @RequestMapping(value= "admin/borradol-participante", method = RequestMethod.POST)
    public String borradolParticipante(ModelMap model,HttpServletRequest request){   
        long id = Long.parseLong(request.getParameter("id"));
        Persona persona = persona_bd.getPersona(id);
        Calendar fecha = Calendar.getInstance();
        Date date = fecha.getTime();
        persona.setFborrado(date);
        persona.setActivo(false);
        persona_bd.actualizar(persona);        
        return "Ok";
    }
    
    
    
    
    
}
