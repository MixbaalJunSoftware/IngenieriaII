/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Mapeo.Participante;
import Mapeo.Persona;
import Mapeo.Proyecto;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *@author Mixbaal Jun Software - Ingenieria de Software, 2016 FCiencias, UNAM
 *@version 1.0
 * Clase para interactuar con la base de datos, especificamente con las tablas,
 * participante, persona y proyecto.
 */
public class ParticipanteDAO {
    //Atributo privado para conectarse con la base de datos.
    private SessionFactory sessionFactory;
    
    /**
     * Inicializa la sesión con la que se conectará a la base
     * @param sessionFactory 
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * Método que guarda a un participante en la base de datos
     * @param participante 
     */
    public void guardar(Participante participante) {
    
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
           tx = session.beginTransaction();
         
           session.persist(participante);
           
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
     * Método que actualiza la información de un participante en la base de datos
     * @param participante 
     */
    public void actualizar(Participante participante) {
    
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
           tx = session.beginTransaction();
         
           session.update(participante);
           
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
     * Método que elimina un participante de la base de datos
     * @param participante 
     */
    public void eliminar(Participante participante) {
    
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
           tx = session.beginTransaction();
         
           session.delete(participante);
           
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
     * Método que regreda el participante asociado con el id que se pasa como parámetro
     * @param idParticipante
     * @return 
     */
    public Participante getParticipante(long idParticipante) {
        Participante participante = null;
        System.out.print(idParticipante);
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String hql = "from Participante e where e.persona.idPersona = :idpersona";
            Query query = session.createQuery(hql);
            query.setParameter("idpersona", idParticipante);
            participante = (Participante)query.uniqueResult();
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
        System.out.print(participante.getPersona().getIdPersona());
        return participante;
    }
    
    /**
     * Método que regresa todos los participantes que estan en la tabla y estan activos
     * @return 
     */
    public List<Participante> Participantes() {
        List<Participante> result = null;
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String hql = "SELECT participante From Participante participante inner join participante.persona "
                    + "WHERE participante.persona.activo = TRUE";
            Query query = session.createQuery(hql);
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
     * Métodos que regresa a todos los participantes de un proyecto
     * @param idProyecto
     * @return 
     */
    public List<Participante> participantesProyecto(Long idProyecto){
        Proyecto proyecto = null;
        List<Participante> result = null;
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String hql = "SELECT r FROM Participante r WHERE r.persona.activo = TRUE AND "
                       + "r.persona.idPersona IN "
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
     * Método que regresa todos los participantes que fueron eliminados logicamente
     * @return 
     */
    public List<Participante> ParticipantesEliminados() {
        List<Participante> result = null;
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String hql = "SELECT participante From Participante participante inner join participante.persona"
                    + " WHERE participante.persona.activo = FALSE "
                    + "ORDER BY to_char(participante.persona.fborrado,'YYYY/MM/DD')";
            Query query = session.createQuery(hql);
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
    
    
}
