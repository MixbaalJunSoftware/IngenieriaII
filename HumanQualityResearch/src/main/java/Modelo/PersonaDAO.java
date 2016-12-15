/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Mapeo.Persona;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


/**
 * @author Mixbaal Jun Software - Ingenieria de Software, 2016 FCiencias, UNAM
 * @version 1.0
 * Clase que sive para interactuar con la base de datos, especificamente con la
 * tabla Persona
 */
public class PersonaDAO {
    //Atributo privado para conectarse con la base de datos
    private SessionFactory sessionFactory;
    
    /**
     * Inicializa la sesión para conectarse con la base de datos
     * @param sessionFactory 
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * Método que guarda una persona en la base de datos
     * @param persona 
     */
    public void guardar(Persona persona) {
    
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
           tx = session.beginTransaction();
         
           session.persist(persona);
           
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
     * Método que actualiza a una persona en la base de datos
     * @param persona 
     */
    public void actualizar(Persona persona) {
    
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
           tx = session.beginTransaction();
         
           session.update(persona);
           
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
     * Método que elimina a una persona de la base de datos
     * @param persona 
     */
    public void eliminar(Persona persona) {
    
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
           tx = session.beginTransaction();
         
           session.delete(persona);
           
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
     * Método que regresa a una persona, cuyo id es el que se pasa como 
     * parámetro
     * @param idPersona
     * @return 
     */
    public Persona getPersona(long idPersona) {
        Persona persona = null;
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
           tx = session.beginTransaction();
           persona = (Persona)session.get(Persona.class, idPersona);
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
        return persona;
    }
   
    /**
     * Método que regresa una persona, cuyo correo se pasa como parámetro
     * @param correo
     * @return 
     */
    public Persona getPersona(String correo) {
        Persona result = null;
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String hql = " from Persona where correo = :correo";
            Query query = session.createQuery(hql);
            query.setParameter("correo", correo);
            result = (Persona)query.uniqueResult();
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
    
}
