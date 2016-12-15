/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Mapeo.Cliente;
import Mapeo.Persona;
import Mapeo.Pertenecer;
import Mapeo.Proyecto;
import Mapeo.PruebaCliente;
import Mapeo.PruebaProyecto;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * @author Mixbaal Jun Software - Ingenieria de Software, 2016 FCiencias, UNAM
 * @version 1.0
 * Clase para poder hacer cambios en la base con respecto al proyecto.
 */
public class ProyectoDAO {
    //Atributo privado que sirve para conectarse con la base de datos
    private SessionFactory sessionFactory;

    /**
     * Método que inicializa la sesión con la base de datos
     * @param sessionFactory 
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * Método que guarda a un proyecto en la base de datos.
     * @param proyecto 
     */
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
    
    /**
     * Método que actualiza un proyecto en la base de datos
     * @param proyecto 
     */
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
    
    /**
     * Método que elimina a un proyecto de la base de datos
     * @param proyecto 
     */
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
    
    /**
     * Método que relaciona a un proyecto con una prueba
     * @param idProyecto
     * @param prueba 
     */
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
    
    /**
     * Método que regresa el proyecto asociado con el id que se pasa como 
     * parámetro
     * @param idProyecto
     * @return 
     */
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
    
    /**
     * Método que regresa todos los proyecto en la tabla proyecto
     * @return 
     */
    public List<Proyecto> proyectos() {
        List<Proyecto> result = null;
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String hql = "SELECT proyecto From Proyecto proyecto inner join "
                          + "proyecto.tipo WHERE proyecto.activo = TRUE";
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
    
    /**
     * Método que regresa una lista de proyectos, que estan asociados con la 
     * persona cuyo id se pasa como parámetro
     * @param idPersona
     * @return 
     */
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
    
    /**
     * Método que regresa al cliente asociado con el proyecto, cuyo id se pasa
     * como parámetro
     * @param idProyecto
     * @return 
     */
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
    
    /**
     * Método que regresa todos los proyectos que fueron eliminados logicamente
     * @return 
     */
    public List<Proyecto> proyectosEliminados() {
        List<Proyecto> result = null;
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String hql = "SELECT proyecto From Proyecto proyecto inner join "
                          + "proyecto.tipo WHERE proyecto.activo = FALSE";
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
    
    /**
     * Método que regresa un objeto pertenecer asociado con el proyecto y la 
     * persona cuyo id y correo se pasan como parámetro respectivamente
     * @param idProyecto
     * @param correo
     * @return 
     */
    public Pertenecer getPertenecer(long idProyecto,String correo) {
        Pertenecer result = null;
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String hql = "SELECT p From Pertenecer p WHERE p.persona.correo = :correo "
                       + "AND p.proyecto.idProyecto = :idproyecto ";
            Query query = session.createQuery(hql);
            query.setParameter("correo", correo);
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
}
