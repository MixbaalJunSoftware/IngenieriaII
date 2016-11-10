/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Mapeo.Persona;
import Mapeo.TokenPassword;
import Mapeo.Usuario;
import Modelo.ClienteDAO;
import Modelo.PersonaDAO;
import Modelo.TokenPasswordDAO;
import Modelo.UsuarioDAO;
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
    
    /**
     * Metodo para desplegar la vista de inicio
     * @return 
     */
    @RequestMapping(value = "/")
    public String inicio(){
        return "indexNew";
    }
    
    @RequestMapping(value = "/coso")
    public String coso(HttpServletRequest request){
        String password = request.getParameter("coso");
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hash_password = passwordEncoder.encode(password) ;
        System.out.println(hash_password);
        return "index";
    }
    
    
    @RequestMapping(value="/home")
    public String home(ModelMap model,HttpServletRequest request){        
        if (request.isUserInRole("ROLE_ADMIN")) {
            return "redirect:/admin/home";
        }else if(request.isUserInRole("ROLE_CLIENTE")) {
            return "redirect:/cliente/home";
        }
        return "redirect:/empleado/home";
    }
    
    @RequestMapping(value="/admin/home")
    public String homeAdmin(){        
        return "home-admin";
    }
    
    @RequestMapping(value="/cliente/home")
    public String homeCliente(){        
        return "home-cliente";
    }
    
    @RequestMapping(value="/empleado/home")
    public String homeEmpleado(){
        return "home-empleado";
    }
    
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
    
    @RequestMapping(value="/account/availabilityRecover", method=RequestMethod.GET)
    public @ResponseBody boolean getAvailability(@RequestParam("correoRecover")String correo) {
        Persona persona = persona_bd.getPersona(correo);
        return persona != null && persona.getNombre()!= null;
    }
    
    @RequestMapping(value = "/redirect-home")
    public String redirectHome(HttpServletRequest request){
        if (request.isUserInRole("ROLE_ADMIN")) {
            return "redirect:/admin/home";
        }else if(request.isUserInRole("ROLE_CLIENTE")){
            return "redirect:/cliente/home";
        }else if(request.isUserInRole("ROLE_EMPLEADO")){
            return "redirect:/empleado/home";
        }
        return "redirect:/";
    
    }
    
}
