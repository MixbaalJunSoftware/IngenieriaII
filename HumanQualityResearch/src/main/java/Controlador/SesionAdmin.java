/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Mapeo.Persona;
import Mapeo.PruebaCliente;
import Mapeo.TokenPassword;
import Mapeo.Usuario;
import Modelo.ClienteDAO;
import Modelo.PersonaDAO;
import Modelo.PruebaClienteDAO;
import Modelo.TokenPasswordDAO;
import Modelo.UsuarioDAO;
import Modelo.RespuestaDAO;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
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
 * @author Mixbaal
 */
@Controller
public class SesionAdmin {
    
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
    private RespuestaDAO respuesta_bd;
    
    @Autowired
    private PruebaClienteDAO pc_bd;
    
    /**
     * Metodo para desplegar la vista de inicio
     * @return 
     */
    @RequestMapping(value = "/")
    public ModelAndView inicio(ModelMap model,HttpServletRequest request){
        String s = request.getParameter("login_error");
        if (s != null)
            model.addAttribute("login_error",s);
        return new ModelAndView("index",model);
    }
    
    @RequestMapping(value = "/coso")
    public String coso(HttpServletRequest request){
        String password = request.getParameter("coso");
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hash_password = passwordEncoder.encode(password) ;
        System.out.println(hash_password);
        return "index";
    }
    
    /**
     * Metodo para redirigir su pagina principal a un usuario segun su rol
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value="/home")
    public String home(ModelMap model,HttpServletRequest request){        
        if (request.isUserInRole("ROLE_ADMIN")) {
            return "redirect:/admin/home";
        }else if(request.isUserInRole("ROLE_CLIENTE")) {
            return "redirect:/cliente/home";
        }
        return "redirect:/participante/home";
    }
    
    /**
     * Metodo para desplegar a la pagina principal de un admimistrador
     * @return
     */
    @RequestMapping(value="/admin/home")
    public String homeAdmin(){        
        return "home-admin";
    }
    
    /**
     * Metodo para desplegar las vista principal de un cliente
     * @param model
     * @param request
     * @param principal
     * @return
     */
    @RequestMapping(value="/cliente/home")
    public ModelAndView homeCliente(ModelMap model,HttpServletRequest request, Principal principal){        
        String s = principal.getName();
        List<PruebaCliente> lpc = pc_bd.getPruebasCliente(s);
        boolean a = false;
        boolean c = false;
        for(PruebaCliente x : lpc){
            if(x.getPrueba()== 1)
                a = true;
            else if(x.getPrueba() == 2)
                c = true;
        }
        System.out.println(c);
        model.addAttribute("al", a);
        model.addAttribute("cl", c);
        return new ModelAndView("home-cliente",model);
    }
    
    /**
     * Metodo para desplegar la vista principal de un participante
     * @param model
     * @param request
     * @param principal
     * @return
     */
    @RequestMapping(value="/participante/home")
    public ModelAndView homeParticipante(ModelMap model,HttpServletRequest request, Principal principal){
        String s = principal.getName();
        int proyecto =(int)cliente_bd.getProyecto(s);
        boolean a = cliente_bd.validaAdaptabilidad(proyecto);
        boolean c = cliente_bd.validaClima(proyecto);
        a = a & respuesta_bd.rAdaptabilidadCandidato(s);
        c = c & respuesta_bd.rClimaCandidato(s);
        model.addAttribute("adaptab", a);
        model.addAttribute("climab", c);
        return new ModelAndView("home-participante",model);
    }
    
    /**
     * Metodo que despliega la vista de error del sistema
     * @return
     */
    @RequestMapping(value="/error403")
    public String error403(){
        return "error403";
    }
    
    /**
     * Método para desplegar la prueba de adaptabilidad laboral
     */
    @RequestMapping(value = "/verPrueba")
    public String opciones(){
        return "PruebaAL";
    }
    
    @Autowired
    TokenPasswordDAO TokenPassword_bd;
    
    @Autowired
    JavaMailSender mail_sender;
    
    /**
     * Metodo para crear el token necesario para restaurar la contraseña y enviar el correo
     * con el enlace para continuar el proceso de restauracion
     * @param request
     * @param correo
     * @return
     */
    @RequestMapping(value="/restablecerPassword", method = RequestMethod.POST)
    public String restablecerPassword(HttpServletRequest request, @RequestParam("correoRecover") String correo){
    
        Persona usuario = persona_bd.getPersona(correo);
        String token = UUID.randomUUID().toString();
        TokenPassword_bd.guardar(usuario, token);
        String url = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
        mail_sender.send(construirResetTokenEmail(url,token,correo,usuario));
        
        return "Ok";
        
    }
    
    private MimeMessagePreparator construirResetTokenEmail(String contextPath, String token, final String correo ,Persona usuario) {
        
        final String texto = "Utiliza la siguiente URL para cambiar tu password";
        final String url = contextPath + "/cambioPassword?id=" + usuario.getIdPersona()+ "&token=" + token;
        
        MimeMessagePreparator message_preparator = new MimeMessagePreparator() {
 
            @Override
            public void prepare(MimeMessage mime_message) throws Exception {
                mime_message.setFrom("");
                mime_message.setRecipient(Message.RecipientType.TO,
                        new InternetAddress(correo));
                mime_message.setText(texto + "\n" + url);
                mime_message.setSubject("Reset Password");
            }
        };
        
        return message_preparator;        
    }
    
    /**
     * Metdodo para desplegar la vista de restauracion de contraseña
     * En caso de que no se cuente con un token para restablecer contraseña manda
     * a la pagina de error
     * @param model
     * @param id_usuario
     * @param token
     * @return
     */
    @RequestMapping(value = "/cambioPassword", method = RequestMethod.GET)
    public String cambioPassword(ModelMap model, @RequestParam("id") long id_usuario, @RequestParam("token") String token) {

        TokenPassword tokenpassword = TokenPassword_bd.getTokenPersona(id_usuario, token);
        if(tokenpassword == null){
            return "redirect:/error403";    
        }
//        Calendar cal = Calendar.getInstance();
//        if((tokenpassword.getFechaToken().getTime() - cal.getTime().getTime()) <= 0){
//            return "redirect:/errorToken?mensaje_error=El periodo para renovar tu password ha vencido, solicita un nuevo correo";  
//        }
    
        List<GrantedAuthority> grantedAuths = new ArrayList();
        grantedAuths.add(new SimpleGrantedAuthority("ROLE_PASSWORD")); 
        Authentication auth = new UsernamePasswordAuthenticationToken(id_usuario,null, grantedAuths); 
        SecurityContextHolder.getContext().setAuthentication(auth);
        TokenPassword_bd.eliminar(tokenpassword);
        return "nuevoPassword";
        
    }

    /**
     * Metodo para guardar el cambio de contraseña del usuario
     * @param password
     * @param confirmacion_password
     * @param principal
     * @return
     */
    @RequestMapping(value = "/cambiarPassword")
    public String cambiarPassword(@RequestParam("newPass1") String password , @RequestParam("newPass2") String confirmacion_password, Principal principal){
    
        String hash_password;
        
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        hash_password = passwordEncoder.encode(password) ;
        System.out.println(principal.getName());
        usuario_bd.cambiarPassword(Long.parseLong(principal.getName()), hash_password);
        
        SecurityContextHolder.getContext().setAuthentication(null);
        
        return "Ok";
    
    }
    
    /**
     * Metodo para verificar que un correo pertenece a un usario registrado y activo
     * @param correo
     * @return
     */
    @RequestMapping(value="/account/availabilityRecover", method=RequestMethod.GET)
    public @ResponseBody boolean getAvailability(@RequestParam("correoRecover")String correo) {
        Persona persona = persona_bd.getPersona(correo);
        return persona != null && persona.getNombre()!= null && persona.getActivo();
    }
    
    /**
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/redirect-home")
    public String redirectHome(HttpServletRequest request){
        if (request.isUserInRole("ROLE_ADMIN")) {
            return "redirect:/admin/home";
        }else if(request.isUserInRole("ROLE_CLIENTE")){
            return "redirect:/cliente/home";
        }else if(request.isUserInRole("ROLE_PARTICIPANTE")){
            return "redirect:/participante/home";
        }
        return "redirect:/";
    
    }
    
}
