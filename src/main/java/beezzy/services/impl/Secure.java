package beezzy.services.impl;

import beezzy.domain.entities.PermissionEntity;
import beezzy.domain.entities.UserEntity;
import beezzy.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Polomani on 14.02.2016.
 */
@Service(value = "Secure")
public class Secure{
    public static final String ROLE_ADMIN = "ROLE_ADMIN";
    public static final String ROLE_OWNER = "ROLE_OWNER";
    public static final String ROLE_CONSULTANT = "ROLE_CONSULTANT";
    @Autowired
    private UserService userService;

    private boolean hasRole (String role) {
        UserEntity userEntity = userService.getAuthorised();
        if (userEntity!=null)
            for (PermissionEntity permissionEntity : userEntity.getRole().getPermissions())
                if (role.equals(permissionEntity.getName()))
                    return true;
        return false;
    }

    public boolean isAdmin() {
        return hasRole(ROLE_ADMIN);
    }

    public boolean isOwner() {
        return hasRole(ROLE_OWNER);
    }

    public boolean isConsultant() {
        return hasRole(ROLE_CONSULTANT);
    }
}
