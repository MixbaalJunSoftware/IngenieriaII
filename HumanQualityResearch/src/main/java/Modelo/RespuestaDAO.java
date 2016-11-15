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
 *
 * @author jonathan
 */
public class RespuestaDAO {
    
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
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
    
}
