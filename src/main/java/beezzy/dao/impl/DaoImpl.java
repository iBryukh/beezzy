package beezzy.dao.impl;

import beezzy.dao.Dao;

import java.util.List;
import java.util.Map;

import beezzy.domain.entities.ShopEntity;
import beezzy.domain.entities.UserEntity;
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
        return (T)sessionFactory.getCurrentSession().merge(object);
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

    @Override
    public <T> T executeNamedQuery(Class tClass, String queryName, Map<String, Object> params) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.getNamedQuery(queryName);
        for(String key : params.keySet()){
            query.setParameter(key, params.get(key));
        }
        return (T) query.list();
    }

}
