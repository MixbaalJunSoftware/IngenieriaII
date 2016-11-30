/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Controlador;


import Mapeo.Participante;
import Mapeo.Persona;
import Mapeo.Pertenecer;
import Mapeo.Proyecto;
import Mapeo.Usuario;
import Modelo.ParticipanteDAO;
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
public class CRUDParticipante {
    //Instancia para operaciones con la base relacionadas con el participante
    @Autowired
    private ParticipanteDAO participante_bd;
    
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
    @RequestMapping(value = "/opcionesParticipante")
    public String opcionesParticipante(){
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
    
    @RequestMapping(value= "/cliente/crear-participanteCorreo", method = RequestMethod.POST)
    public String creaParticipanteCorreo(ModelMap model,HttpServletRequest request){
        Persona persona = new Persona();
        Usuario usuario = new Usuario();
        Proyecto proyecto = null;
        Pertenecer pertenecer = new Pertenecer();
        Participante participante = new Participante();
        String correo = request.getParameter("correo");
        System.out.print(correo);
        long id = Long.parseLong(request.getParameter("idproyectoCrea"));
        proyecto = proyecto_bd.getProyecto(id);
        Persona p = persona_bd.getPersona(correo);
        if(p==null){
            persona.setCorreo(correo);
            persona.setActivo(true);
            usuario.setPersona(persona);
            pertenecer.setPersona(persona);
            pertenecer.setProyecto(proyecto);
            participante.setPersona(persona);
            usuario.setRol("ROLE_PARTICIPANTE");
            persona_bd.guardar(persona);
            usuario_bd.guardar(usuario);
            pertenecer_bd.guardar(pertenecer);
            participante_bd.guardar(participante);
            String url = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
            mail_sender.send(construirEmail(url,correo));
            return "CorreoCorrecto";
        }else{
            if (pertenecer_bd.buscaPertenecer(p.getIdPersona(), proyecto.getIdProyecto()))
                return "UsuarioRepetido";
            else{
                try{
                    pertenecer.setPersona(p);
                    pertenecer.setProyecto(proyecto);
                    pertenecer_bd.guardar(pertenecer);
                    return "CorreoCorrecto";
                }catch(Exception e){
                    return "error403";
                }
            }
        }
        
    }
    
    
    @RequestMapping(value= "/admin/crear-participanteCorreo", method = RequestMethod.POST)
    public String creaParticipanteCorreoA(ModelMap model,HttpServletRequest request){
        Persona persona = new Persona();
        Usuario usuario = new Usuario();
        Proyecto proyecto = null;
        Pertenecer pertenecer = new Pertenecer();
        Participante participante = new Participante();
        String correo = request.getParameter("correo");
        System.out.print(correo);
        long id = Long.parseLong(request.getParameter("idproyectoCrea"));
        proyecto = proyecto_bd.getProyecto(id);
        Persona p = persona_bd.getPersona(correo);
        if(p==null){
            persona.setCorreo(correo);
            persona.setActivo(true);
            usuario.setPersona(persona);
            pertenecer.setPersona(persona);
            pertenecer.setProyecto(proyecto);
            participante.setPersona(persona);
            usuario.setRol("ROLE_PARTICIPANTE");
            persona_bd.guardar(persona);
            usuario_bd.guardar(usuario);
            pertenecer_bd.guardar(pertenecer);
            participante_bd.guardar(participante);
            String url = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
            mail_sender.send(construirEmail(url,correo));
            return "CorreoCorrecto";
        }else{
            if (pertenecer_bd.buscaPertenecer(p.getIdPersona(), proyecto.getIdProyecto()))
                return "UsuarioRepetido";
            else{
                try{
                    pertenecer.setPersona(p);
                    pertenecer.setProyecto(proyecto);
                    pertenecer_bd.guardar(pertenecer);
                    return "CorreoCorrecto";
                }catch(Exception e){
                    return "error403";
                }
            }
        }
        
    }
    /**
     * Realiza la funcionalidad para agregar un cliente a la base de datos
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value= "/completarRegistro-participante", method = RequestMethod.POST)
    public String completarRegistroParticipante(ModelMap model,HttpServletRequest request){
        String correo = request.getParameter("correo");
        Persona persona = persona_bd.getPersona(correo);
        Participante participante = new Participante();
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
        String empresa = request.getParameter("empresa");
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
        persona.setEmpresa(empresa);
        participante.setPersona(persona);
        participante.setPuestoParticipante(puesto);
        usuario.setPersona(persona);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hash_password = passwordEncoder.encode(password) ;
        usuario.setContrasenia(hash_password);
        
        usuario.setRol("ROLE_PARTICIPANTE");
        persona_bd.actualizar(persona);
        participante_bd.actualizar(participante);
        usuario_bd.actualizar(usuario);
        return "Ok";
    }
    
    
    /**
     * Metodo Auxiliar para probar el caso de uso Actualizar
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value= "/participante/previoActualizarParticipante", method = RequestMethod.GET)
    public ModelAndView previoActualizarParticipante(ModelMap model,HttpServletRequest request, Principal principal){
        /**
         * Persona persona = persona_bd.getPersona(principal.getName());
         * model.addAttribute("persona", persona);
         * if(persona == null)
         * return new ModelAndView("error403",model);
         */
        return new ModelAndView("EditarParticipante",model);
    }
    
    
    /**
     *
     * @param request
     * @return
     */
    @RequestMapping(value= "/participante/actualizar-participante", method = RequestMethod.POST)
    public String actualizaParticipante(HttpServletRequest request, Principal principal){
        Persona persona = persona_bd.getPersona(principal.getName());
        long id = persona.getIdPersona();
        Participante participante = participante_bd.getParticipante(id);
        Usuario usuario = usuario_bd.getUsuario(id);
        String puesto = request.getParameter("puesto");
        String telefono = request.getParameter("tel");
        String celular = request.getParameter("cel");
        String pasword = request.getParameter("rpass");
        if(!puesto.equals(""))
            participante.setPuestoParticipante(puesto);
        if(!telefono.equals(""))
            persona.setTelefono(telefono);
        if(!celular.equals(""))
            persona.setCelular(celular);
        if(!pasword.equals("")){
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String hash_password = passwordEncoder.encode(pasword) ;
            usuario.setContrasenia(hash_password);
        }
        usuario.setRol("ROLE_PARTICIPANTE");
        persona_bd.actualizar(persona);
        participante_bd.actualizar(participante);
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
    @RequestMapping(value= "/cliente/ver-participantes", method = RequestMethod.GET)
    public ModelAndView verParticipantesCliente(ModelMap model,HttpServletRequest request,Principal principal){  
        long id = Long.parseLong(request.getParameter("idproyecto"));
        Pertenecer pertenecer = proyecto_bd.getPertenecer(id,principal.getName());
        if(pertenecer == null)
            return new ModelAndView("error403",model);
        List<Participante> lp = participante_bd.participantesProyecto(id);
        model.addAttribute("listaParticipantes",lp);
        model.addAttribute("idProyecto",id);
        return new ModelAndView("Participantes",model);
    }
    /**
     * Metodo para mostrar la informacion de los Proyectos
     * Pone los paramentros en el model de la pagina a mostrar
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value= "/admin/ver-participantes", method = RequestMethod.GET)
    public ModelAndView verParticipantesAdmin(ModelMap model,HttpServletRequest request){
        long id = Long.parseLong(request.getParameter("idproyecto"));
        List<Participante> lp = participante_bd.participantesProyecto(id);
        model.addAttribute("listaParticipantes",lp);
        model.addAttribute("idProyecto",id);        
        return new ModelAndView("Participantes",model);
    }
    
    /**
     * Metodo Auxiliar para poder contestar la prueba de adaptabilidad laboral
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value= "/participante/contestarPrueba", method = RequestMethod.GET)
    public ModelAndView contestarPrueba(ModelMap model,HttpServletRequest request, Principal principal){
        return new ModelAndView("PruebaAL",model);
    }
    
    
    /**
     * Metodo Auxiliar para poder contestar la prueba de clima laboral
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value= "/participante/contestarPruebaCL", method = RequestMethod.GET)
    public ModelAndView contestarPruebaCL(ModelMap model,HttpServletRequest request, Principal principal){
        return new ModelAndView("PruebaCL",model);
    }
    
    /**
     * Metodo para eliminar un participante de la base de datos
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value= "/admin/elimina-participante", method = RequestMethod.POST)
    public String eliminaParticipante(ModelMap model,HttpServletRequest request){
        long id = Long.parseLong(request.getParameter("id"));
        Participante participante = participante_bd.getParticipante(id);
        Usuario usuario = usuario_bd.getUsuario(id);
        Persona persona = participante.getPersona();
        Pertenecer pertenecer = pertenecer_bd.getPertenecerP(id);
        pertenecer_bd.eliminar(pertenecer);
        participante_bd.eliminar(participante);
        usuario_bd.eliminar(usuario);
        persona_bd.eliminar(persona);
        return "Ok";
    }
    
    /**
     * Método para hacer el borrado lógico de la base de datos
     * @param model
     * @param request
     * @return
     */
    
    @RequestMapping(value= "/borradol-participante", method = RequestMethod.POST)
    public String borradolParticipanteA(ModelMap model,HttpServletRequest request){
        long id = Long.parseLong(request.getParameter("id"));
        Persona persona = persona_bd.getPersona(id);
        Calendar fecha = Calendar.getInstance();
        Date date = fecha.getTime();
        persona.setFborrado(date);
        persona.setActivo(false);
        persona_bd.actualizar(persona);
        return "Ok";
    }
    
    /**
     * Método para hacer el borrado lógico de la base de datos
     * @param model
     * @param request
     * @return
     */
    
    @RequestMapping(value= "/cliente/borradol-participante", method = RequestMethod.POST)
    public String borradolParticipanteC(ModelMap model,HttpServletRequest request){
        long id = Long.parseLong(request.getParameter("id"));
        Persona persona = persona_bd.getPersona(id);
        Calendar fecha = Calendar.getInstance();
        Date date = fecha.getTime();
        persona.setFborrado(date);
        persona.setActivo(false);
        persona_bd.actualizar(persona);
        return "Ok";
    }
    
    @RequestMapping(value= "/admin/ver-eparticipantes", method = RequestMethod.GET)
    public ModelAndView verParticipantesE(ModelMap model,HttpServletRequest request){
        List<Participante> c = participante_bd.ParticipantesEliminados();
        model.addAttribute("lista",c);
        return new ModelAndView("ParticipantesEliminados",model);
    }
    
    @RequestMapping(value= "/admin/recuperar-participante", method = RequestMethod.POST)
    public String recuperarParticipante(ModelMap model,HttpServletRequest request){
        long id = Long.parseLong(request.getParameter("id"));
        Persona persona = persona_bd.getPersona(id);
        persona.setActivo(true);
        persona_bd.actualizar(persona);
        return "Ok";
    }
    
    @RequestMapping(value= "/muestra-participante", method = RequestMethod.GET)
    public ModelAndView mostrarParticipante(ModelMap model,HttpServletRequest request){
        long id = Long.parseLong(request.getParameter("idparticipante"));
        Participante participante = participante_bd.getParticipante(id);
        boolean existe = participante != null;
        model.addAttribute("existe",existe);
        if(!existe)
            return new ModelAndView("ClienteNoEncontrado",model);
        model.addAttribute("id",id);
        model.addAttribute("nombre",participante.getPersona().getNombre());
        model.addAttribute("app",participante.getPersona().getApp());
        model.addAttribute("apm",participante.getPersona().getApm());
        model.addAttribute("fecha",participante.getPersona().getFecha_nac().toString());
        model.addAttribute("genero",participante.getPersona().getGenero());
        model.addAttribute("correo",participante.getPersona().getCorreo());
        model.addAttribute("telefono",participante.getPersona().getTelefono());
        model.addAttribute("celular",participante.getPersona().getCelular());
        model.addAttribute("puesto", participante.getPuestoParticipante());
        return new ModelAndView("MuestraParticipante",model);
    }
    
    
}
