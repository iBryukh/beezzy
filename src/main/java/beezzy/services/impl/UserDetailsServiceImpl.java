package beezzy.services.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import beezzy.dao.impl.UserDaoImpl;
import beezzy.domain.entities.PermissionEntity;
import beezzy.domain.entities.RoleEntity;
import beezzy.domain.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Polomani on 13.02.2016.
 */

@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDaoImpl userDao;

    @Override
    public UserDetails loadUserByUsername(final String email)
            throws UsernameNotFoundException {

        UserEntity user = userDao.getByEmail(email);
        List<GrantedAuthority> authorities = buildUserAuthority(user.getRole().getPermissions());

        return buildUserForAuthentication(user, authorities);
    }

    // UserEntity user to org.springframework.security.core.userdetails.User
    private User buildUserForAuthentication(UserEntity user,
                                            List<GrantedAuthority> authorities) {
        return new User(user.getEmail(),
                user.getPassword(), user.isActive(),
                true, true, true, authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(List<PermissionEntity> userRoles) {
        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
        for (PermissionEntity userRole : userRoles) {
            setAuths.add(new SimpleGrantedAuthority(userRole.getName()));
        }
        return new ArrayList<GrantedAuthority>(setAuths);
    }

    public UserDaoImpl getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

}