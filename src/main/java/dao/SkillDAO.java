package dao;

import connection.HibernateUtil;
import model.Skill;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import java.util.List;

public class SkillDAO {
    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private static Session session = null;

    private SkillDAO() {
    }

    public static void create(Skill skill){

        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(skill);
            session.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
    }

    public static void delete(Skill skill){
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(skill);
            session.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            session.getTransaction().rollback();
        }finally{
            session.close();
        }

    }

    public static void update(Skill skill){
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(skill);
            session.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            session.getTransaction().rollback();
        }finally{
            session.close();
        }

    }

    public static Skill read(int id){
        Skill skill = null;

        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            skill = (Skill) session.get(Skill.class, id);
            session.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            session.getTransaction().rollback();
        }finally{
            session.close();
        }

        return skill;
    }

    public static List<Skill> findAll(){
        List<Skill> list = null;
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            list = session.createQuery("from Skill").list();
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
