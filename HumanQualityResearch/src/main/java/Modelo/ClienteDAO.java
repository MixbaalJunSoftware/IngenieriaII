/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Mapeo.Cliente;
import Mapeo.PruebaCliente;
import Mapeo.PruebaProyecto;
import java.security.Principal;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


/**
 * @author Mixbaal Jun Software - Ingenieria de Software, 2016 FCiencias, UNAM
 * Clase para interactuar con la base de datos, especificamente con la tabla 
 * Cliente, PruebaCliente y PruebaProyecto.
 */
public class ClienteDAO {
    //Atributo privado para conectarse con la base de datos.
    private SessionFactory sessionFactory;
    /**
     * Inicializa la sesión con la que se conectara la base.
     * @param sessionFactory 
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * Guarda a un cliente en la base de datos.
     * @param cliente 
     */
    public void guardar(Cliente cliente) {
    
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
           tx = session.beginTransaction();
         
           session.persist(cliente);
           
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
     * Agrega una PruebaCliente en la base de datos
     * @param idCliente
     * @param prueba 
     */
    public void agregaPrueba(long idCliente, int prueba) {
    
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
           tx = session.beginTransaction();
           PruebaCliente pc = new PruebaCliente();
           Cliente cliente = (Cliente) session.get(Cliente.class, idCliente);
           pc.setCliente(cliente);
           pc.setPrueba(prueba);
           session.persist(pc);
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
     * Actualiza a un cliente de la base de datos.
     * @param cliente 
     */
    public void actualizar(Cliente cliente) {
    
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
           tx = session.beginTransaction();
         
           session.update(cliente);
           
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
     * Elimina a un cliente de la base de datos.
     * @param cliente 
     */
    public void eliminar(Cliente cliente) {
    
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
           tx = session.beginTransaction();
         
           session.delete(cliente);
           
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
     * Regresa a un cliente guardado en la base de datos, cuyo id corresponda con el 
     * parametro.
     * @param idCliente
     * @return 
     */
    public Cliente getCliente(long idCliente) {
        Cliente cliente = null;
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
           tx = session.beginTransaction();
           cliente = (Cliente)session.get(Cliente.class, idCliente);
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
     * Regresa una lista con todos los clientes que estan activos en la base de datos.
     * @return 
     */
    public List<Cliente> Clientes() {
        List<Cliente> result = null;
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String hql = "SELECT cliente From Cliente cliente inner join cliente.persona "
                    + "WHERE cliente.persona.activo = TRUE";
            Query query = session.createQuery(hql);
            result = (List<Cliente>)query.list();
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
     * Regresa a un cliente, cuyo correo se pasa como parámetro.
     * @param correo
     * @return 
     */
    public Cliente getCliente(String correo){
        Cliente result = null;
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String hql = "SELECT c From Cliente c where c.persona.correo = :correo";
            Query query = session.createQuery(hql);
            query.setParameter("correo", correo);             
            List<Cliente> l = query.list();
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
    
    /**
     * Regresa una lista de todos los clientes que fueron eliminados logicamente.
     * @return 
     */
    public List<Cliente> ClientesEliminados() {
        List<Cliente> result = null;
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String hql = "SELECT cliente From Cliente cliente inner join cliente.persona "
                    + "WHERE cliente.persona.activo = FALSE "
                    + "ORDER BY to_char(cliente.persona.fborrado,'YYYY/MM/DD')";
            Query query = session.createQuery(hql);
            result = (List<Cliente>)query.list();
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
     * Regresa True en caso de que el proyecto con el id que se pase como parámetro
     * tenga asociada la prueba de Adaptabilidad, False en otro caso
     * @param idProyecto
     * @return 
     */
    public boolean validaAdaptabilidad(long idProyecto) {
        boolean result = false;
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
           tx = session.beginTransaction();
           String hql = "SELECT a FROM PruebaProyecto a WHERE a.prueba = 1 AND a.proyecto.idProyecto = :id";
            Query query = session.createQuery(hql);
            query.setParameter("id", idProyecto); 
            Object o = query.uniqueResult();
           result = o != null;
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
     * Regresa True en caso de que el proyecto con el id que se pase como parámetro
     * tenga asociada la prueba de Clima, False en otro caso
     * @param id
     * @return 
     */
    public boolean validaClima(long idProyecto) {
        boolean result = false;
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
           tx = session.beginTransaction();
           String hql = "SELECT a FROM PruebaProyecto a WHERE a.prueba = 2 AND a.proyecto.idProyecto = :id";
            Query query = session.createQuery(hql);
            query.setParameter("id", idProyecto); 
            Object o = query.uniqueResult();
           result = o != null;
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
     * Regresa el id del proyecto que esta relacionado con el correo que se pasa 
     * de parámetro.
     * @param correo
     * @return 
     */
    public long getProyecto(String correo) {
       long result = -1;
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
           tx = session.beginTransaction();
           String hql = "SELECT p.proyecto.idProyecto FROM Pertenecer p WHERE p.persona.correo = :correo";
            Query query = session.createQuery(hql);
            query.setParameter("correo", correo); 
            result = (long)query.uniqueResult();
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
