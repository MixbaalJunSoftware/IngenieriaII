/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Mapeo.Cliente;
import Mapeo.Persona;
import Mapeo.Pertenecer;
import Mapeo.Usuario;
import Mapeo.PruebaCliente;
import Modelo.ClienteDAO;
import Modelo.PersonaDAO;
import Modelo.PertenecerDAO;
import Modelo.UsuarioDAO;
import Modelo.PruebaClienteDAO;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Mixbaal Jun Software - Ingenieria de Software, 2016 FCiencias, UNAM
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
    
    @Autowired
    private PertenecerDAO pertenecer_bd;
    
    @Autowired
    private PruebaClienteDAO pcliente_bd;
    
    
    /**
     * Método para desplegar la vista de opciones
     */
    @RequestMapping(value = "/opciones")
    public String opciones(){
        return "Opciones";
    }
    /**
     * Realiza la funcionalidad para agregar un cliente a la base de datos
     * @param model
     * @param request
     * @return 
     */
    @RequestMapping(value= "/crear-cliente", method = RequestMethod.POST)
    public String creaCliente(ModelMap model,HttpServletRequest request){
        String correo = request.getParameter("correo");
        Persona persona = persona_bd.getPersona(correo);
        Cliente cliente = new Cliente();
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
        String empresa = request.getParameter("empresa");
        String puesto = request.getParameter("puesto");
        String area = request.getParameter("area");
        persona.setNombre(nombre);
        persona.setApp(app);
        persona.setApm(apm);
        persona.setFecha_nac(fecha);
        persona.setGenero(genero);
        persona.setTelefono(telefono);
        persona.setCelular(celular);
        persona.setEmpresa(empresa);
        cliente.setPersona(persona);
        cliente.setPuestoCliente(puesto);
        cliente.setAreaCliente(area);
        usuario.setPersona(persona);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hash_password = passwordEncoder.encode(password) ;
        usuario.setContrasenia(hash_password);
        usuario.setRol("ROLE_CLIENTE");
        persona_bd.actualizar(persona);
        cliente_bd.actualizar(cliente);
        usuario_bd.actualizar(usuario);
        return "Ok";   
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
    
    
    /**
     * Metodo Auxiliar para probar el caso de uso Actualizar
     * @param model
     * @param request
     * @return 
     */
    @RequestMapping(value= "/actualiza-cliente", method = RequestMethod.GET)
    public ModelAndView previoActualizar(ModelMap model,HttpServletRequest request){   
        return new ModelAndView("EditarCliente",model);
    }
    
    /**
     * Realiza las operaciones para modificar la informacion de un cliente en la base de datos
     * @param request
     * @param principal
     * @return 
     */
    @RequestMapping(value= "/actualizar-cliente-accion", method = RequestMethod.POST)
    public String actualizaCliente(HttpServletRequest request,Principal principal){
        Cliente cliente = cliente_bd.getCliente(principal.getName());
        Usuario usuario = usuario_bd.getUsuario(principal.getName());
        String puesto = request.getParameter("puesto");
        String area = request.getParameter("area");
        String telefono = request.getParameter("tel");
        String celular = request.getParameter("cel");
        String pasword = request.getParameter("pass");
        if(!puesto.equals(""))
            cliente.setPuestoCliente(puesto);
        if(!area.equals(""))
            cliente.setAreaCliente(area);
        if(!telefono.equals(""))
            cliente.getPersona().setTelefono(telefono);
        if(!celular.equals(""))
            cliente.getPersona().setCelular(celular);
        if(!pasword.equals("")){
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String hash_password = passwordEncoder.encode(pasword) ;
            usuario.setContrasenia(hash_password);
        }
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
    @RequestMapping(value= "/admin/muestra-cliente", method = RequestMethod.GET)
    public ModelAndView mostrarCliente(ModelMap model,HttpServletRequest request){   
        long id = Long.parseLong(request.getParameter("idcliente"));
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
        model.addAttribute("empresa",cliente.getPersona().getEmpresa());
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
    @RequestMapping(value= "/admin/elimina-cliente", method = RequestMethod.POST)
    public String eliminaCliente(ModelMap model,HttpServletRequest request){   
        long id = Long.parseLong(request.getParameter("id"));
        Cliente cliente = cliente_bd.getCliente(id);
        Usuario usuario = usuario_bd.getUsuario(id);
        Persona persona = cliente.getPersona();
        List<Pertenecer> lpertenecer = pertenecer_bd.listPertenecerPersona(id);
        List<PruebaCliente> pc = pcliente_bd.getPruebasCliente(id);
        try{
            for(Pertenecer p : lpertenecer){
                pertenecer_bd.eliminar(p);
            }
            for(PruebaCliente pcl : pc){
                pcliente_bd.eliminar(pcl);
            }
            cliente_bd.eliminar(cliente);
            usuario_bd.eliminar(usuario);
            persona_bd.eliminar(persona);
            return "Ok";
        }catch(Exception e){
            return "Error403";
        }
        
    }
    
    /**
      * Método para hacer el borrado lógico de la base de datos
      * @param model
      * @param request
      * @return 
      */
    
    @RequestMapping(value= "admin/borradol-cliente", method = RequestMethod.POST)
    public String borradolCliente(ModelMap model,HttpServletRequest request){   
        long id = Long.parseLong(request.getParameter("id"));
        Calendar fecha = Calendar.getInstance();
        Date date = fecha.getTime();
        Persona persona = persona_bd.getPersona(id);
        persona.setActivo(false);
        persona.setFborrado(date);
        persona_bd.actualizar(persona);        
        return "Ok";
    }
      
    /**
     * Metodo para mostrar la informacion de un Cliente
     * Pone los paramentros en el model de la pagina a mostrar
     * @param model
     * @param request
     * @return 
     */
    @RequestMapping(value= "/admin/ver-clientes", method = RequestMethod.GET)
    public ModelAndView verClientes(ModelMap model,HttpServletRequest request){   
        List<Cliente> c = cliente_bd.Clientes();
        model.addAttribute("lista",c);
        return new ModelAndView("Clientes",model);
    }
    
    /**
     * Metodo previo para desplegar la vista de completar registro segun el rol del usuario
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value="/completar-registro")
    public ModelAndView aCompletar(ModelMap model,HttpServletRequest request){
        String correo = request.getParameter("correo");
        System.out.println(correo);
        model.addAttribute("correoRegistrado", correo);
        String role = usuario_bd.getRole(correo);
        System.out.print(role);
        if(role.equals("ROLE_CLIENTE"))
            return new ModelAndView("CrearCliente",model);
        else
            return new ModelAndView("CrearParticipante", model);
    }
    
    /**
     * Metodo para verificar que un correo pertenece a un usario registrado
     * @param correo
     * @return
     */
    @RequestMapping(value="/account-availability", method=RequestMethod.GET)
    public @ResponseBody boolean getAvailability(@RequestParam("correo")String correo) {
        Persona persona = persona_bd.getPersona(correo);
        return persona != null && persona.getNombre()== null;
    }
    
    /**
     * Metodo para realizar la operacion de agregar un cliente a partir de su correo
     * Asigna el correo y rol, el resto de datos del cliente permanecen nulos
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value= "/admin/crear-clienteCorreo", method = RequestMethod.GET)
    public String creaClienteCorreo(ModelMap model,HttpServletRequest request){
        Persona persona = new Persona();
        Cliente cliente = new Cliente();
        Usuario usuario = new Usuario();
        String correo = request.getParameter("correo");
        Persona p = persona_bd.getPersona(correo);
        if(p==null){
            persona.setCorreo(correo);
            persona.setActivo(true);
            cliente.setPersona(persona);
            usuario.setPersona(persona);
            usuario.setRol("ROLE_CLIENTE");
            persona_bd.guardar(persona);
            cliente_bd.guardar(cliente);
            usuario_bd.guardar(usuario);
            String url = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
            mail_sender.send(construirEmail(url,correo));
            return "CorreoCorrecto";
        }else{
            return "CorreoRegistrado";
        }
     
    }
    
    /**
     * Metodo para desplegar la vista que mustra la lista de clientes
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value= "/admin/ver-eclientes", method = RequestMethod.GET)
    public ModelAndView verClientesE(ModelMap model,HttpServletRequest request){ 
        List<Cliente> c = cliente_bd.ClientesEliminados();
        model.addAttribute("lista",c);
        return new ModelAndView("ClientesEliminados",model);
    }
    
    /**
     * Metodo para reactivar un cliente que fue eliminado
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value= "/admin/recuperar-cliente", method = RequestMethod.POST)
    public String recuperarCliente(ModelMap model,HttpServletRequest request){   
        long id = Long.parseLong(request.getParameter("id"));
        Persona persona = persona_bd.getPersona(id);
        persona.setActivo(true);
        persona_bd.actualizar(persona);        
        return "Ok";
    }
    
    
    
}
