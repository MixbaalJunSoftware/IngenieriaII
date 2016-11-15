/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Mapeo.Cliente;
import Mapeo.Persona;
import Mapeo.Proyecto;
import Mapeo.PruebaCliente;
import Mapeo.PruebaProyecto;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Mixbaal
 * @version 1.0
 * Clase para poder hacer cambios en la base con respecto al proyecto.
 */
public class ProyectoDAO {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    
    public void guardar(Proyecto proyecto) {
    
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
           tx = session.beginTransaction();
         
           session.persist(proyecto);
           
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
    
    
    public void actualizar(Proyecto proyecto) {
    
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
           tx = session.beginTransaction();
         
           session.update(proyecto);
           
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
    
    
    public void eliminar(Proyecto proyecto) {
    
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
           tx = session.beginTransaction();
         
           session.delete(proyecto);
           
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
    
    public void agregaPrueba(long idProyecto, int prueba) {
    
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
           tx = session.beginTransaction();
           PruebaProyecto pp = new PruebaProyecto();
           Proyecto proyecto = (Proyecto) session.get(Proyecto.class, idProyecto);
           pp.setProyecto(proyecto);
           pp.setPrueba(prueba);
           session.persist(pp);
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
    
    public Proyecto getProyecto(long idProyecto) {
        Proyecto proyecto = null;
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
           tx = session.beginTransaction();
           proyecto = (Proyecto)session.get(Proyecto.class, idProyecto);
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
        return proyecto;
    }
    
    public List<Proyecto> proyectos() {
        List<Proyecto> result = null;
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String hql = "SELECT proyecto From Proyecto proyecto inner join "
                          + "proyecto.tipo";
            Query query = session.createQuery(hql);
            result = (List<Proyecto>)query.list();
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
    
    
    public List<Proyecto> proyectosCliente(Long idPersona) {
        List<Proyecto> result = null;
        Persona persona = null;
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String hql = "SELECT proyecto From Pertenecer pertenecer inner join "
                     + "pertenecer.proyecto proyecto inner join proyecto.tipo "
                    + "where pertenecer.persona = :persona AND "
                    + "proyecto.activo = TRUE";
            Query query = session.createQuery(hql);
            persona = (Persona)session.get(Persona.class, idPersona);
            query.setParameter("persona", persona);
            result = (List<Proyecto>)query.list();
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
    
    public Cliente getCliente(long idProyecto){
        Cliente  cliente = null;
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String hql = "SELECT cliente FROM Cliente cliente INNER JOIN "
                          + "cliente.persona persona "
                    + "WHERE persona.activo = TRUE AND persona.idPersona IN "
                    + "(SELECT p.persona.idPersona FROM Pertenecer p "
                       + " WHERE p.proyecto.idProyecto = :idproyecto)";
            Query query = session.createQuery(hql);
            query.setParameter("idproyecto", idProyecto);
            cliente = (Cliente)query.uniqueResult();
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
        return cliente;        
    }
}
