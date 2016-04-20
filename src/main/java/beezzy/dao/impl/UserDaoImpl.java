package beezzy.dao.impl;

import beezzy.dao.UserDao;
import beezzy.domain.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * Created by oleh on 12.02.2016.
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private DaoImpl dao;


    @Override
    public UserEntity merge(UserEntity user) {
        return dao.merge(user);
    }

    @Override
    public List<UserEntity> get(int offset, int limit) {
        return dao.list_executeNamedQueryParams(
                UserEntity.GET_ALL,
                null,
                offset,
                limit
        );
    }

    @Override
    public UserEntity getByEmail(final String email) {
        return dao.single_executeNameQueryParams(
                UserEntity.GET_BY_EMAIL,
                new HashMap<String, Object>(){{
                    put("email", email);
                }}
        );
    }

    @Override
    public UserEntity getById(final int id) {
        return dao.single_executeNameQueryParams(
                UserEntity.GET_BY_ID,
                new HashMap<String, Object>(){{
                    put("id", id);
                }}
        );
    }

    @Override
    public void delete(final int id) {
        dao.executeUpdateNamed(
                UserEntity.DELETE_BY_ID,
                new HashMap<String, Object>(){{
                    put("id", id);
                }}
        );
    }


}
