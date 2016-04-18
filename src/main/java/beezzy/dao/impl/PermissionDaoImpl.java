package beezzy.dao.impl;

import beezzy.dao.PermissionDao;
import beezzy.domain.entities.PermissionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * Created by denisweeks on 19.04.16.
 */
@Repository
public class PermissionDaoImpl implements PermissionDao {

    @Autowired
    private DaoImpl dao;


    @Override
    public PermissionEntity merge(PermissionEntity permission) {
        return dao.merge(permission);
    }

    @Override
    public List<PermissionEntity> get(int offset, int limit) {
        return dao.list_executeNamedQueryParams(
                PermissionEntity.GET_ALL,
                null,
                offset,
                limit
        );
    }

    @Override
    public void delete(final int id) {
        dao.executeUpdateNamed(
                PermissionEntity.DELETE_BY_ID,
                new HashMap<String, Object>(){{
                    put("id", id);
                }}
        );
    }


}