package dao;

import connection.HibernateUtil;
import model.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class ProjectDAO {
    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private static Session session = null;

    private ProjectDAO() {
    }

    public static void create(Project project){

        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(project);
            session.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
    }

    public static void delete(Project project){

        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(project);
            session.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
    }

    public static void update(Project project){

        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(project);
            session.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
    }

    public static Project read(int id){
        Project project = null;

        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            project = (Project) session.get(Project.class, id);
            session.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            session.getTransaction().rollback();
        }finally{
            session.close();
        }

        return project;
    }

    public static List<Project> findAll(){
        List<Project> list = null;

        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            list = session.createQuery("from Project").list();
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
