package beezzy.services.impl;

import beezzy.converters.BaseConverter;
import beezzy.converters.Converter;
import beezzy.dao.UserDao;
import beezzy.domain.entities.UserEntity;
import beezzy.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by oleh on 12.02.2016.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Autowired
    private BaseConverter<UserEntity> userConverter;

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
    public UserEntity getByEmail(String email) {
        if(email == null || email.isEmpty())
            return null;
        return userDao.getByEmail(email);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public UserEntity getAuthorised() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetails = (UserDetails) auth.getPrincipal();
            return userDao.getByEmail(userDetails.getUsername());
        }
        return null;
    }
}
