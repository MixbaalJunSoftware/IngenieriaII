/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Mapeo.Usuario;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


/**
 * @author Mixbaal Jun Software - Ingenieria de Software, 2016 FCiencias, UNAM
 * @version 1.0
 * Clase que interactua con la base de datos, especificamente con la tabla
 * Usuario
 */
public class UsuarioDAO {

    //Atributo privado que sirve para conectarse con la base de datos
    private SessionFactory sessionFactory;
    //Atributo privado que especifica el id del administrador
    private final long idAdmin = 1;

    /**
     * Método que inicializa la sesión con la base de datos
     * @param sessionFactory 
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * Método que guarda a un usuario en la base de datos
     * @param usuario 
     */
    public void guardar(Usuario usuario) {
    
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
           tx = session.beginTransaction();
         
           session.persist(usuario);
           
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
     * Método que actualiza a un usuario en la base de datos
     * @param usuario 
     */
    public void actualizar(Usuario usuario) {
    
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
           tx = session.beginTransaction();
         
           session.update(usuario);
           
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
     * Método que elimina a un usuario de la base de datos
     * @param usuario 
     */
    public void eliminar(Usuario usuario) {
    
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
           tx = session.beginTransaction();
         
           session.delete(usuario);
           
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
     * Método que regresa al usuario asociado con el id que se pasa de parámetro
     * @param idPersona
     * @return 
     */
    public Usuario getUsuario(long idPersona) {
        Usuario result = null;
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String hql = "from Usuario u where u.persona.idPersona = :idpersona";
            Query query = session.createQuery(hql);
            query.setParameter("idpersona", idPersona);
            result = (Usuario)query.uniqueResult();
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
        return result;
    }
    /**
     * Método que regresa True si el usuario que se pasa como parámetro es el
     * administrador
     * @param usuario
     * @return 
     */
    public boolean admin(Usuario usuario){
        return usuario.getPersona().getIdPersona() == idAdmin;
    }
    
    /**
     * Método que regresa el role de un usuario, asociado con el correo que se
     * pasa como parámetro
     * @param correo
     * @return 
     */
    public String getRole(String correo){
        String result = null;
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String hql = "SELECT rol From Usuario u where u.persona.correo = :correo";
            Query query = session.createQuery(hql);
            query.setParameter("correo", correo);             
            result = (String)query.uniqueResult();
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
        return result;
    
    }
    /**
     * Método que regresa un usuario cuyo correo se pasa como parámetro
     * @param correo
     * @return 
     */
    public Usuario getUsuario(String correo){
        Usuario result = null;
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String hql = "SELECT u From Usuario u where u.persona.correo = :correo";
            Query query = session.createQuery(hql);
            query.setParameter("correo", correo);             
            List<Usuario> l = query.list();
            result = l.get(0);
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
        return result;
    
    }
    /**
     * Método que actualiza la contraseña de un usuario, regresa True en caso de 
     * éxito
     * @param id_usuario
     * @param password
     * @return 
     */
    public boolean cambiarPassword(long id_usuario, String password){
        
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        boolean exito = false;
        
        try {
           tx = session.beginTransaction();
           String hql = "from Usuario u where u.persona.idPersona = :id_usuario";
           Query query = session.createQuery(hql);
           query.setParameter("id_usuario", id_usuario);
           List<Usuario> l = query.list();
           Usuario usuario = l.get(0);
           usuario.setContrasenia(password);
           session.update(usuario);
           tx.commit();
           exito = true;
           
        }
        catch (Exception e) {
           if (tx!=null) tx.rollback();
           e.printStackTrace(); 
        }finally {
           session.close();
        }
        
        return exito;
    }
    
}
