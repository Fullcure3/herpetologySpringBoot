package org.portfolio;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.portfolio.views.Herp;

public class HibernateUtli {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if(sessionFactory == null) {
            var configuration = new Configuration().configure()
                    .addAnnotatedClass(Herp.class);
            return configuration.buildSessionFactory();
        }
        return sessionFactory;
    }
    public static void shutdown(){
        sessionFactory.close();
    }
}
