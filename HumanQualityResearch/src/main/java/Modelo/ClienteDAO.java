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
 *
 * @author Mixbaal
 */
public class ClienteDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    
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

    public boolean validaAdaptabilidad(long id) {
        boolean result = false;
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
           tx = session.beginTransaction();
           String hql = "SELECT a FROM PruebaProyecto a WHERE a.prueba = 1 AND a.proyecto.idProyecto = :id";
            Query query = session.createQuery(hql);
            query.setParameter("id", id); 
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
    
    public boolean validaClima(long id) {
        boolean result = false;
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
           tx = session.beginTransaction();
           String hql = "SELECT a FROM PruebaProyecto a WHERE a.prueba = 2 AND a.proyecto.idProyecto = :id";
            Query query = session.createQuery(hql);
            query.setParameter("id", id); 
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
