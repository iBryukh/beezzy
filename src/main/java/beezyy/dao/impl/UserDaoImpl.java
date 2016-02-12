package beezyy.dao.impl;

import beezyy.dao.UserDao;
import beezyy.domain.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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


}
