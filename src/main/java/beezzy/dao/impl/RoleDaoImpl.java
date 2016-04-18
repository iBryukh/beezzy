package beezzy.dao.impl;

import beezzy.dao.RoleDao;
import beezzy.domain.entities.RoleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * Created by denisweeks on 19.04.16.
 */
@Repository
public class RoleDaoImpl implements RoleDao {

    @Autowired
    private DaoImpl dao;


    @Override
    public RoleEntity merge(RoleEntity role) {
        return dao.merge(role);
    }

    @Override
    public List<RoleEntity> get(int offset, int limit) {
        return dao.list_executeNamedQueryParams(
                RoleEntity.GET_ALL,
                null,
                offset,
                limit
        );
    }

    @Override
    public void delete(final int id) {
        dao.executeUpdateNamed(
                RoleEntity.DELETE_BY_ID,
                new HashMap<String, Object>(){{
                    put("id", id);
                }}
        );
    }


}