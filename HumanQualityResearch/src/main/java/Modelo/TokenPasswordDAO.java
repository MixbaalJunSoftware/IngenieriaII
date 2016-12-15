/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Mapeo.Persona;
import Mapeo.TokenPassword;
import Mapeo.Usuario;
import java.util.Calendar;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * @author Mixbaal Jun Software - Ingenieria de Software, 2016 FCiencias, UNAM
 * @version 1.0
 * Clase que sirve para interactuar con la base de datos con la tabla Persona,
 * TokenPassword y Usuario
 */
public class TokenPasswordDAO {
    //Atributo privado para conectarse con la base de datos
    private SessionFactory sessionFactory;
    /**
     * Método que inicializa la sesión con la base de datos
     * @param sessionFactory 
     */
     public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
     
    
     /**
      * Método que guarda un objeto TokenPassword en la base de datos
      * @param persona
      * @param token 
      */
    public void guardar(Persona persona, String token) {
        Session session = sessionFactory.openSession();
        Calendar fecha = Calendar.getInstance();
        TokenPassword tokenPassword = new TokenPassword();
        fecha.add(Calendar.HOUR , 1);
        Transaction tx = null;
        try {
            tokenPassword.setPersona(persona);
            tokenPassword.setToken(token);
            tokenPassword.setFechaToken(fecha.getTime());
            tx = session.beginTransaction();
            session.save(tokenPassword);
            tx.commit();
        }
        catch (Exception e) {
           if (tx!=null){ 
               tx.rollback();
           }
           e.printStackTrace(); 
        }finally {
           session.close();
        }
    
    }
    
    /**
     * Método que regresa un TokenPassword que esta relacionado con la persona y
     * el token que se pasan como parámetro
     * @param id_persona
     * @param token
     * @return 
     */
    public TokenPassword getTokenPersona(long id_persona, String token){
        
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        TokenPassword tokenpassword = null;
        
        try {
           tx = session.beginTransaction();
    
            String hql = "FROM TokenPassword T "
                    +    "WHERE T.persona.idPersona = :id_persona AND "
                    +    "T.token = :token ";
           
            Query query = session.createQuery(hql);
            query.setParameter("id_persona", id_persona);
            query.setParameter("token", token);
            tokenpassword = (TokenPassword)query.uniqueResult(); 
            tx.commit();
             
        }
        catch (HibernateException e) {
           if (tx!=null) tx.rollback();
           e.printStackTrace(); 
        }finally {
           session.close();
        }
        
        return tokenpassword;
    }
    /**
     * Método que elimina a un TokenPassword de la base de datos
     * @param tp 
     */
    public void eliminar(TokenPassword tp) {
    
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
           tx = session.beginTransaction();
         
           session.delete(tp);
           
           tx.commit();
        }
        catch (Exception e) {
           if (tx!=null){ 
               tx.rollback();
           }
           e.printStackTrace(); 
        }finally {
           session.close();
        }
    
    }
    
}
