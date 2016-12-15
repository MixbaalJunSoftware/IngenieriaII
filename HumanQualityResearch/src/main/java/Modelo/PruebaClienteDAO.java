/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


import Mapeo.Cliente;
import Mapeo.PruebaCliente;
import java.util.List;
import javax.validation.ConstraintViolationException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * @author Mixbaal Jun Software - Ingenieria de Software, 2016 FCiencias, UNAM
 * @version 1.0
 * Clase que sirve para interactuar con la base de datos, específicamente con 
 * las tablas Cliente y PruebaCliente
 */
public class PruebaClienteDAO {
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
     * Método que guarda un objeto pruebacliente en la base de datos
     * @param pruebacliente 
     */
    public void guardar(PruebaCliente pruebacliente) {
    
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
           tx = session.beginTransaction();
         
           session.persist(pruebacliente);
           
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
     * Método que guarda una prueba cliente con los datos que se 
     * pasan como parámetro
     * @param prueba
     * @param idCliente 
     */
    public void guardar(int prueba,long idCliente) {
    
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
           tx = session.beginTransaction();
           Cliente cliente = (Cliente) session.get(Cliente.class, idCliente);
           PruebaCliente pruebacliente = new PruebaCliente();
           pruebacliente.setCliente(cliente);
           pruebacliente.setPrueba(prueba);
           session.persist(pruebacliente);
           
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
     * Método que actualiza un objeto pruebacliente en la base de datos
     * @param pruebacliente 
     */
    public void actualizar(PruebaCliente pruebacliente) {
    
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
           tx = session.beginTransaction();
         
           session.update(pruebacliente);
           
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
     * Método que elimina un objeto pruebacliente de la base de datos
     * @param pruebacliente 
     */
    public void eliminar(PruebaCliente pruebacliente) {
    
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
           tx = session.beginTransaction();
         
           session.delete(pruebacliente);
           
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
     * Método que regresa una lista de objetos pruebacliente asociados con el 
     * cliente cuyo id se pasa como parámetro
     * @param idCliente
     * @return 
     */
    public List<PruebaCliente> getPruebasCliente(long idCliente) {
        List<PruebaCliente> pcliente= null;
        //System.out.print(idParticipante);
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String hql = "from PruebaCliente pc where pc.cliente.persona.idPersona = :idcliente";
            Query query = session.createQuery(hql);
            query.setParameter("idcliente", idCliente);
            pcliente =  (List<PruebaCliente>)query.list();
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
        return pcliente;
    }
    
    /**
     * Método que regresa una lista de objetos pruebacliente que estan asociados
     * con la persona cuyo correo es el que se pasa como parámetro
     * @param correo
     * @return 
     */
    
    public List<PruebaCliente> getPruebasCliente(String correo) {
        List<PruebaCliente> pcliente= null;
        //System.out.print(idParticipante);
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String hql = "from PruebaCliente pc where pc.cliente.persona.correo = :correo";
            Query query = session.createQuery(hql);
            query.setParameter("correo", correo);
            pcliente =  (List<PruebaCliente>)query.list();
            tx.commit();
        }
        catch(ConstraintViolationException cve){
        }
        catch (Exception e) {
           if (tx!=null){
               tx.rollback();
           }
           e.printStackTrace(); 
        }finally {
           session.close();
        }
        return pcliente;
    }
    
}
