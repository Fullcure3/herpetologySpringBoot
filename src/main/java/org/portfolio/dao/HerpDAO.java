package org.portfolio.dao;

import org.hibernate.SessionFactory;
import org.portfolio.HibernateUtli;
import org.springframework.stereotype.Component;

@Component
public class HerpDAO {

    public SessionFactory connectToDatabase(){
        return HibernateUtli.getSessionFactory();
    }
}
