package connection;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

//    public HibernateUtil() {
//        sessionFactory = new Configuration().configure().buildSessionFactory();
//    }

    static {

        sessionFactory = new Configuration().configure().buildSessionFactory();
//        Configuration configuration = new Configuration().configure();
//        sessionFactory = configuration
////                .addAnnotatedClass(Skill.class)
////                .addAnnotatedClass(Company.class)
////                .addAnnotatedClass(Customer.class)
////                .addAnnotatedClass(Developer.class)
////                .addAnnotatedClass(Project.class)
//                .buildSessionFactory();
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    public static void close(){
        sessionFactory.close();
    }
}
