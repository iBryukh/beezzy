package beezzy.services.impl;

import beezzy.auth.jwt.JwtUtil;
import beezzy.converters.BaseConverter;
import beezzy.dao.UserDao;
import beezzy.domain.entities.ShopEntity;
import beezzy.domain.entities.UserEntity;
import beezzy.domain.request.user.UserAuth;
import beezzy.exceptions.*;
import beezzy.exceptions.WrongEmailException;
import beezzy.exceptions.WrongPasswordException;
import beezzy.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by oleh on 12.02.2016.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private BaseConverter<UserEntity> userConverter;

    @Autowired
    private BaseConverter<ShopEntity> shopConverter;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public UserEntity merge(UserEntity user) {
        if(user == null)
            return null;
        return userDao.merge(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Map<String, Object>> get(Set<String> fields, int offset, int limit) {
        return userConverter.convert(userDao.get(offset, limit), fields);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Map<String, Object>> getUserShops(int id, Set<String> fields) throws NoSuchUserException {
        UserEntity userEntity =  userDao.getById(id);
        if (userEntity == null)
            throw new NoSuchUserException();
        return shopConverter.convert(userEntity.getShops(), fields);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public UserEntity getByEmail(String email) {
        if (email == null || email.isEmpty())
            return null;
        return userDao.getByEmail(email);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Map<String, Object> getById(int id, Set<String> fields) throws NoSuchUserException{
        UserEntity userEntity = userDao.getById(id);
        if (userEntity==null)
            throw new NoSuchUserException();
        return userConverter.convert(userEntity, fields);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Map<String, Object> putUser(UserEntity userEntity) throws UserAlreadyExistException {
        if (null == userDao.getByEmail(userEntity.getEmail())) {
            return userConverter.convert(userDao.merge(userEntity), new HashSet<String>(){{add("id");}});
        } else {
            throw new UserAlreadyExistException();
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean postUser(UserEntity userEntity, String oldPass) throws NoSuchUserException, PasswordsDoNotMatchException {
        if (!userEntity.getPassword().equals(oldPass)) {
            throw new PasswordsDoNotMatchException();
        }
        if (userDao.getById(userEntity.getId()) != null) {
            userDao.merge(userEntity);
            return true;
        } else {
            throw new NoSuchUserException();
        }
    }

    @Override
    public Map<String, Object> signin(UserAuth userAuth) throws WrongPasswordException, WrongEmailException {
        UserEntity user = userDao.getByEmail(userAuth.getEmail());
        if(user == null){
            throw new WrongEmailException();
        }
        if(!user.getPassword().equals(userAuth.getPassword())) {
            throw new WrongPasswordException();
        }
        Map<String, Object> map = new HashMap<>();
        map.put(JwtUtil.ACCESS_TOKEN, jwtUtil.generate(user));
        return map;
    }
}
