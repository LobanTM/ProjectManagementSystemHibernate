package dao;

import connection.HibernateUtil;
import model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {

    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private static Session session = null;

    private CustomerDAO() {
    }

    public static void create(Customer customer){

        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(customer);
            session.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
    }

    public static void delete(Customer customer){

        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(customer);
            session.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
    }

    public static void update(Customer customer){

        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(customer);
            session.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
    }

    public static Customer read(int id){
        Customer customer = null;

        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            customer = (Customer) session.get(Customer.class, id);
            session.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            session.getTransaction().rollback();
        }finally{
            session.close();
        }

        return customer;
    }

    public static List<Customer> findAll(){
        List<Customer> list =null;

        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            list = session.createQuery("from Customer").list();
            session.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            session.getTransaction().rollback();
        }finally{
            session.close();
        }

        return  list;
    }
}
