package beezzy.dao.impl;

import beezzy.dao.VarietyDao;
import beezzy.domain.entities.VarietyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * Created by denisweeks on 19.04.16.
 */
@Repository
public class VarietyDaoImpl implements VarietyDao {

    @Autowired
    private DaoImpl dao;


    @Override
    public VarietyEntity merge(VarietyEntity variety) {
        return dao.merge(variety);
    }

    @Override
    public List<VarietyEntity> get(int offset, int limit) {
        return dao.list_executeNamedQueryParams(
                VarietyEntity.GET_ALL,
                null,
                offset,
                limit
        );
    }

    @Override
    public void delete(final int id) {
        dao.executeUpdateNamed(
                VarietyEntity.DELETE_BY_ID,
                new HashMap<String, Object>(){{
                    put("id", id);
                }}
        );
    }


}