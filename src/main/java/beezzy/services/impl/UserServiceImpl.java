package beezzy.services.impl;

import beezzy.auth.jwt.JwtUtil;
import beezzy.converters.BaseConverter;
import beezzy.dao.UserDao;
import beezzy.domain.entities.UserEntity;
import beezzy.domain.request.user.UserAuth;
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

    @Override
    public Map<String, Object> signin(UserAuth userAuth) {
        UserEntity user = userDao.getByEmail(userAuth.getEmail());
        if(user == null){
            return null;
        }
        Map<String, Object> map = new HashMap<>();
        map.put(JwtUtil.ACCESS_TOKEN, jwtUtil.generate(user));
        return map;
    }
}
