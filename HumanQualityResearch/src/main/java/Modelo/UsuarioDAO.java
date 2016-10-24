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
 *
 * @author Mixbaal
 */
public class UsuarioDAO {

    private SessionFactory sessionFactory;
    private final long idAdmin = 1;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    
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
    
    public boolean admin(Usuario usuario){
        return usuario.getPersona().getIdPersona() == idAdmin;
    }
    
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
