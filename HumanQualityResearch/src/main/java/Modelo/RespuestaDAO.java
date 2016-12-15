/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Mapeo.RAdaptabilidad;
import Mapeo.RClimaLaboral;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * @author Mixbaal Jun Software - Ingenieria de Software, 2016 FCiencias, UNAM
 * @version 1.0
 * Clase que interactua con la base de datos, especificamente con la tabla
 * RAdaptabilidad y RClimaLaboral
 */
public class RespuestaDAO {
    //Atributo privado que ayuda a conectarse con la base de datos
    private SessionFactory sessionFactory;

    /**
     * Método que inicializa la sesión con la base de datos
     * @param sessionFactory 
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    /**
     * Método que guarda respuestas en la tabla RAdaptabilidad
     * @param respuesta 
     */
    public void guardar(RAdaptabilidad respuesta) {
    
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
           tx = session.beginTransaction();
         
           session.persist(respuesta);
           
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
     * Método que guarda una respuesta a la tabla RClimaLaboral
     * @param respuesta 
     */
    public void guardar(RClimaLaboral respuesta) {
    
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
           tx = session.beginTransaction();
         
           session.persist(respuesta);
           
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
     * Método que regresa las respuesta de un candidato en la prueba de 
     * Adaptabilidad
     * @param idCandidato
     * @return 
     */
    public RAdaptabilidad rAdaptabilidadCandidato(long idCandidato){
        RAdaptabilidad respuesta=null ;
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            String hql = "SELECT r FROM RAdaptabilidad r WHERE r.persona.idPersona = :idcandidato";
            Query query = session.createQuery(hql);
            query.setParameter("idcandidato", idCandidato);
            respuesta = (RAdaptabilidad) query.uniqueResult();
            tx.commit();
        }catch(HibernateException e) {
           if (tx!=null) tx.rollback();
           e.printStackTrace(); 
        }finally {
           session.close();
        }
        RAdaptabilidad resouesta;
        
        return respuesta;
    }
    
    /**
     * Método que regresa las respuestas de Adaptabilida asociadas al proyecto 
     * cuyo id se pasa como parámetro
     * @param idProyecto
     * @return 
     */
    public List<RAdaptabilidad> rAdaptabilidadProyecto(long idProyecto){
        List<RAdaptabilidad> lresp = null;
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            String hql = "SELECT r FROM RAdaptabilidad WHERE r.persona.idPersona IN("
                        + "SELECT p.idPersona FROM Pertenecer p WHERE "
                        + "p.Proyecto.idProyecto = :idproyecto)";
            Query query = session.createQuery(hql);
            query.setParameter("idproyecto", idProyecto);
            lresp = query.list();
            tx.commit();
        }catch(HibernateException e) {
           if (tx!=null) tx.rollback();
           e.printStackTrace(); 
        }finally {
           session.close();
        }
        return lresp;
    }
    
    /**
     * Método que regresa las respuestas de un candidato en la prueba de Clima
     * Laboral
     * @param idCandidato
     * @return 
     */
    public RClimaLaboral rClimaCandidato(long idCandidato){
        RClimaLaboral respuesta=null ;
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            String hql = "SELECT r FROM RClimaLaboral r WHERE r.persona.idPersona = :idcandidato";
            Query query = session.createQuery(hql);
            query.setParameter("idcandidato", idCandidato);
            respuesta = (RClimaLaboral) query.uniqueResult();
            tx.commit();
        }catch(HibernateException e) {
           if (tx!=null) tx.rollback();
           e.printStackTrace(); 
        }finally {
           session.close();
        }        
        return respuesta;
    }
    /**
     * Método que regresa una lista de respuestas de la prueba Clima, que estan
     * asociadas con el proyecto cuyo id se pasa como parámetro
     * @param idProyecto
     * @return 
     */
    public List<RClimaLaboral> rClimaProyecto(long idProyecto){
        List<RClimaLaboral> lresp = null;
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            String hql = "SELECT r FROM RClimaLaboral r.persona.idPersona IN("
                        + "SELECT p.idPersona FROM Pertenecer p WHERE "
                        + "p.Proyecto.idProyecto = :idproyecto)";
            Query query = session.createQuery(hql);
            query.setParameter("idproyecto", idProyecto);
            lresp = query.list();
            tx.commit();
        }catch(HibernateException e) {
           if (tx!=null) tx.rollback();
           e.printStackTrace(); 
        }finally {
           session.close();
        }
        return lresp;
    }
    
    /**
     * Método que regresa True en caso de que la persona asociada con el correo
     * que se pasa como parámetro ya contesto la prueba de Adaptabilidad 
     * @param correo
     * @return 
     */
    public boolean rAdaptabilidadCandidato(String correo) {
        RAdaptabilidad respuesta=null ;
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            String hql = "SELECT r FROM RAdaptabilidad r WHERE r.persona.correo = :correo";
            Query query = session.createQuery(hql);
            query.setParameter("correo", correo);
            respuesta = (RAdaptabilidad) query.uniqueResult();
            tx.commit();
        }catch(HibernateException e) {
           if (tx!=null) tx.rollback();
           e.printStackTrace(); 
        }finally {
           session.close();
        }
        return respuesta == null;
    }
    
    /**
     * Método que regresa True en caso de que la persona asociada con el correo
     * @param correo
     * @return 
     */
    
    public boolean rClimaCandidato(String correo) {
        RClimaLaboral respuesta=null ;
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            String hql = "SELECT r FROM RClimaLaboral r WHERE r.persona.correo = :correo";
            Query query = session.createQuery(hql);
            query.setParameter("correo", correo);
            respuesta = (RClimaLaboral) query.uniqueResult();
            tx.commit();
        }catch(HibernateException e) {
           if (tx!=null) tx.rollback();
           e.printStackTrace(); 
        }finally {
           session.close();
        }
        
        return respuesta==null;
    }
    
}
