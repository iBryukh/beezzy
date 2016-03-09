package beezzy.dao.impl;

import beezzy.dao.Dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


/**
 * Created by oleh on 12.02.2016.
 */
@Repository
public class DaoImpl implements Dao {

    @PersistenceContext
    EntityManager em;

    @Override
    public <T> T merge(T object){
        return (T)em.merge(object);
    }

    @Override
    public <T> List<T> get(final Class tClass, final int offset, final int limit) {
        String q = "SELECT o FROM " + tClass.getName() + " o";
        Query query = em.createQuery(q);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return (List<T>) query.getResultList();
    }

    @Override
    public <T> T executeNamedQuery(Class tClass, String queryName, Map<String, Object> params) {
        Query query = em.createNamedQuery(queryName);
        for(String key : params.keySet()){
            query.setParameter(key, params.get(key));
        }
        return (T) query.getResultList();
    }

}
