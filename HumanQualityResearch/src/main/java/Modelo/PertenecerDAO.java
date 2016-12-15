/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Mapeo.Cliente;
import Mapeo.Participante;
import Mapeo.Pertenecer;
import Mapeo.Usuario;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * @author Mixbaal Jun Software - Ingenieria de Software, 2016 FCiencias, UNAM
 * @version 1.0
 * Clase que sirve para interactuar con la base de datos, especificamente con las 
 * tablas Cliente, Participante, Pertenecer y Usuario.
 */
public class PertenecerDAO {
    //Atributo privado que sirve para conectarse con la base de datos
    private SessionFactory sessionFactory;
    /**
     * Método que inicializa la sesión para conectarse con la base de datos.
     * @param sessionFactory 
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * Método que guarda un objeto pertenecer en la base de datos
     * @param pertenecer 
     */
    public void guardar(Pertenecer pertenecer) {
    
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
           tx = session.beginTransaction();
         
           session.persist(pertenecer);
           
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
     * Método que actualiza un objeto pertenecer en la base de datos
     * @param pertenecer 
     */
    public void actualizar(Pertenecer pertenecer) {
    
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
           tx = session.beginTransaction();
         
           session.update(pertenecer);
           
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
     * Método que elimina un objeto pertenecer de la base de datos
     * @param pertenecer 
     */
    public void eliminar(Pertenecer pertenecer) {
    
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
           tx = session.beginTransaction();
         
           session.delete(pertenecer);
           
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
     * Método que regresa un objeto peternecer cuyo proyecto asociado tiene el
     * id que se pasa como parámetro
     * @param idProyecto
     * @return 
     */
    public Pertenecer getPertenecer(long idProyecto) {
        Pertenecer result = null;
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String hql = "from Pertenecer p where p.proyecto.idProyecto = :idproyecto";
            Query query = session.createQuery(hql);
            query.setParameter("idproyecto", idProyecto);
            result = (Pertenecer)query.uniqueResult();
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
     * Método que regresa un objeto pertenecer cuya persona asociada tiene el 
     * id que se pasa como parámetro
     * @param idPersona
     * @return 
     */
    public Pertenecer getPertenecerP(long idPersona) {
        Pertenecer result = null;
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String hql = "from Pertenecer p where p.persona.idPersona = :idpersona";
            Query query = session.createQuery(hql);
            query.setParameter("idpersona", idPersona);
            result = (Pertenecer)query.uniqueResult();
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
     * Método que regresa una lista de participantes, los cuales estan asociados
     * a un proyecto cuyo id se pasa como parámetro
     * @param idProyecto
     * @return 
     */
    public List<Participante> lPertenecerE(long idProyecto) {
        List<Participante> result = null;
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String hql = "SELECT participante From Participante participante inner join participante.persona "
                    + "WHERE participante.persona.idPersona IN "
                    + "(SELECT p.persona.idPersona FROM Pertenecer p "
                    + " WHERE p.proyecto.idProyecto = :idproyecto)";
            Query query = session.createQuery(hql);
            query.setParameter("idproyecto", idProyecto);
            result = (List<Participante>)query.list();
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
     * Método que regresa una lista de objetos pertenecer que estan asociados con
     * el proyecto cuyo id se pasa como parámetro.
     * @param idProyecto
     * @return 
     */
    public List<Pertenecer> listPertenecer(long idProyecto) {
        List<Pertenecer> result = null;
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String hql = "SELECT pertenecer From Pertenecer pertenecer "
                    + "WHERE pertenecer.proyecto.idProyecto = :idproyecto";
            Query query = session.createQuery(hql);
            query.setParameter("idproyecto", idProyecto);
            result = (List<Pertenecer>)query.list();
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
     * Método que regresa una lista de objetos pertenecer cuya persona es la
     * que tiene el id que se pasa como parámetro.
     * @param idPersona
     * @return 
     */
    public List<Pertenecer> listPertenecerPersona(long idPersona) {
        List<Pertenecer> result = null;
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String hql = "SELECT pertenecer From Pertenecer pertenecer "
                    + "WHERE pertenecer.persona.idPersona = :idpersona";
            Query query = session.createQuery(hql);
            query.setParameter("idpersona", idPersona);
            result = (List<Pertenecer>)query.list();
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
     * Método que nos dice si una persona y un proyecto estan relacionados
     * @param idPersona
     * @param idProyecto
     * @return 
     */
    public boolean buscaPertenecer (long idPersona, long idProyecto){
        Pertenecer result = null;
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String hql = "from Pertenecer p where p.persona.idPersona = :idpersona "
                    + "AND p.proyecto.idProyecto = :idproyecto";
            Query query = session.createQuery(hql);
            query.setParameter("idpersona", idPersona);
            query.setParameter("idproyecto", idProyecto);
            result = (Pertenecer)query.uniqueResult();
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
        if (result != null)
            return true;
        return false;
    
    
    }
    
    /**
     * Método que regresa al cliente asociado con el proyecto cuyo id se pasa
     * como parámetro
     * @param idProyecto
     * @return 
     */
    public Cliente getClienteProyecto(long idProyecto) {
        Cliente result = null;
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String hql = "SELECT cliente FROM Cliente cliente WHERE "
                    + "cliente.persona.idPersona in ("
                    + " SELECT p.persona.idPersona FROM Pertenecer p "
                    + "WHERE p.proyecto.idProyecto = :idproyecto )";
            Query query = session.createQuery(hql);
            query.setParameter("idproyecto", idProyecto);
            result = (Cliente)query.uniqueResult();
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
