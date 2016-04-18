package beezzy.dao.impl;

import beezzy.dao.Dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


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
    public <T> List<T> list_executeNamedQueryParams(String nameQuery, Map<String, Object> params, int offset, int limit){
        Query query = em.createNamedQuery(nameQuery);
        return list_executeListQuery(query, params, limit, offset);
    }

    @Override
    public <T> List<T> list_executeNativeQueryParams(String nativeQuery, Map<String, Object> params, int offset, int limit){
        Query query = em.createNativeQuery(nativeQuery);
        return list_executeListQuery(query, params, limit, offset);
    }

    @Override
    public <T> T single_executeNameQueryParams(String nameQuery, Map<String, Object> params){
        Query query = em.createNamedQuery(nameQuery);
        return single_executeSingleQuery(query, params);
    }

    @Override
    public <T> T single_executeNativeQueryParams(String nativeQuery, Map<String, Object> params, Class tClass){
        Query query = em.createNativeQuery(nativeQuery);
        return single_executeSingleQuery(query, params);
    }

    @Override
    public void executeUpdateNamed(String nameQuery, Map<String, Object> params){
        Query query = em.createNamedQuery(nameQuery);
        executeUpdate(query, params);
    }

    @Override
    public void executeUpdateNative(String nativeQuery, Map<String, Object> params){
        Query query = em.createNativeQuery(nativeQuery);
        executeUpdate(query, params);
    }

    private <T> List<T> list_executeListQuery(Query query, Map<String, Object> params, int limit, int offset){
        if(params != null){
            for(String key : params.keySet())
                query.setParameter(key, params.get(key));
        }
        if(limit > 0)
            query.setMaxResults(limit);
        if(offset > 0)
            query.setFirstResult(offset);
        return query.getResultList();
    }

    private <T> T single_executeSingleQuery(Query query, Map<String, Object> params){
        if(params != null){
            for(String key : params.keySet())
                query.setParameter(key, params.get(key));
        }
        List<T> list = query.getResultList();
        if(list.size() == 0)
            return null;
        return list.get(0);
    }

    private void executeUpdate(Query query, Map<String, Object> params){
        if(params != null){
            for(String key : params.keySet()){
                query.setParameter(key, params.get(key));
            }
        }
        query.executeUpdate();
    }

}
