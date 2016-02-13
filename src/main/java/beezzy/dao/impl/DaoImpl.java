package beezzy.dao.impl;

import beezzy.dao.Dao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * Created by oleh on 12.02.2016.
 */
@Repository
public class DaoImpl implements Dao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public <T> T merge(T object){
        Session session = sessionFactory.getCurrentSession();
        return (T)session.merge(object);
    }

    @Override
    public <T> T get(final Class tClass, final int offset, final int limit) {
        Session session = sessionFactory.getCurrentSession();
        String q = "SELECT o FROM " + tClass.getName() + " o";
        Query query = session.createQuery(q);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return (T) query.list();
    }

}
