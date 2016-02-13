package beezzy.services.impl;

import beezzy.dao.UserDao;
import beezzy.domain.entities.UserEntity;
import beezzy.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by oleh on 12.02.2016.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public UserEntity merge(UserEntity user) {
        if(user == null)
            return null;
        return userDao.merge(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<UserEntity> get(int offset, int limit) {
        return userDao.get(offset, limit);
    }
}
