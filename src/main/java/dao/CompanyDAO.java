package dao;

import connection.HibernateUtil;
import model.Company;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class CompanyDAO {
    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private static Session session = null;

    private CompanyDAO() {
    }

    public static void create(Company company){

        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(company);
            session.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
    }

    public static void delete(Company company){
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(company);
            session.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            session.getTransaction().rollback();
        }finally{
            session.close();
        }

    }

    public static void update(Company company){
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(company);
            session.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            session.getTransaction().rollback();
        }finally{
            session.close();
        }

    }

    public static Company read(int id){
        Company company = null;

        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            company = (Company) session.get(Company.class, id);
            session.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            session.getTransaction().rollback();
        }finally{
            session.close();
        }

        return company;
    }

    public static List<Company> findAll(){
        List<Company> list = null;

        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            list = session.createQuery("from Company").list();
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
