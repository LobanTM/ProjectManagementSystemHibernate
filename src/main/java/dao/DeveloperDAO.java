package dao;

import connection.HibernateUtil;
import model.Developer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class DeveloperDAO {

    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private static Session session = null;

    private DeveloperDAO() {
    }

    public static void create(Developer developer){

        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(developer);
            session.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
    }

    public static void delete(Developer developer){

        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(developer);
            session.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
    }

    public static void update(Developer developer){

        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(developer);
            session.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
    }

    public static Developer read(int id){
        Developer developer = null;

        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            developer = (Developer) session.get(Developer.class, id);
            session.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            session.getTransaction().rollback();
        }finally{
            session.close();
        }

        return developer;
    }

    public static List<Developer> findAll(){
        List<Developer> list = null;

        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            list = session.createQuery("from Developer").list();
            session.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            session.getTransaction().rollback();
        }finally{
            session.close();
        }

        return list;
    }
}
