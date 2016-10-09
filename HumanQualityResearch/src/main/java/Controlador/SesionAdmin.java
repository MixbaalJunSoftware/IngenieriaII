/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Mapeo.Persona;
import Mapeo.Usuario;
import Modelo.ClienteDAO;
import Modelo.PersonaDAO;
import Modelo.UsuarioDAO;
import java.security.Principal;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
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
        return "index";
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
        return "Ok";
    }
    
    @RequestMapping(value="/admin/home")
    public String homeAdmin(){        
        return "home-admin";
    }
    
    @RequestMapping(value="/cliente/home")
    public String homeCliente(){        
        return "home-cliente";
    }
    
    @RequestMapping(value="/error403")
    public String error403(){
        return "error403";
    }
    

    
}
