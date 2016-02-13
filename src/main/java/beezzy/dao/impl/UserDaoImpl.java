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
    private DaoImpl userDao;


    @Override
    public UserEntity merge(UserEntity user) {
        return userDao.merge(user);
    }

    @Override
    public List<UserEntity> get(int offset, int limit) {
        return userDao.get(UserEntity.class, offset, limit);
    }

    @Override
    public UserEntity getByEmail(final String email) {
        List<UserEntity> list = userDao.executeNamedQuery(
                null,
                UserEntity.GET_BY_EMAIL,
                new HashMap<String, Object>(){{
                    put("email", email);
                }}
        );
        return list == null || list.isEmpty() ? null : list.get(0);
    }


}
