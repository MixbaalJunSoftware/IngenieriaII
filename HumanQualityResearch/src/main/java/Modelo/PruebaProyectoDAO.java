/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Mapeo.Proyecto;
import Mapeo.PruebaProyecto;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * @author Mixbaal Jun Software - Ingenieria de Software, 2016 FCiencias, UNAM
 * @version 1.0
 * Clase que ayuda a comunicarse con la base de datos, especificamente con la 
 * tabla Proyecto y PruebaProyecto
 */
public class PruebaProyectoDAO {
    //Atributo privado que ayuda a conectarse con la base de datos
    private SessionFactory sessionFactory;

    /**
     * Metodo que inicializa la sesion con la base de datos
     * @param sessionFactory 
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * Método que guarda una pruebaproyecto en la base de datos
     * @param pruebaproyecto 
     */
    public void guardar(PruebaProyecto pruebaproyecto) {
    
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
           tx = session.beginTransaction();
         
           session.persist(pruebaproyecto);
           
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
     * Método que actualiza a una pruebaproyecto en la base de datos
     * @param pruebaproyecto 
     */
    public void actualizar(PruebaProyecto pruebaproyecto) {
    
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
           tx = session.beginTransaction();
         
           session.update(pruebaproyecto);
           
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
     * Método que elimina una pruebaproyecto de la base de datos
     * @param pruebaproyecto 
     */
    public void eliminar(PruebaProyecto pruebaproyecto) {
    
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
           tx = session.beginTransaction();
         
           session.delete(pruebaproyecto);
           
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
     * Método que regresa una lista de pruebaproyecto que tienen asociado el 
     * proyecto cuyo id se pasa como parámetro
     * @param idProyecto
     * @return 
     */
    public List<PruebaProyecto> getPruebasProyecto(long idProyecto) {
        List<PruebaProyecto> pproyecto= null;
        //System.out.print(idParticipante);
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String hql = "from PruebaProyecto pp where pp.proyecto.idProyecto = :idproyecto";
            Query query = session.createQuery(hql);
            query.setParameter("idproyecto", idProyecto);
            pproyecto =  (List<PruebaProyecto>)query.list();
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
        return pproyecto;
    }
 
   
}
