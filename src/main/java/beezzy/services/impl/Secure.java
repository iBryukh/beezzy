package beezzy.services.impl;

import beezzy.domain.entities.PermissionEntity;
import beezzy.domain.entities.UserEntity;
import beezzy.domain.enums.Roles;
import beezzy.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Polomani on 14.02.2016.
 */
@Service(value = "Secure")
public class Secure{
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
        return hasRole(Roles.admin.toString());
    }

    public boolean isOwner() {
        return hasRole(Roles.owner.toString());
    }

    public boolean isConsultant() {
        return hasRole(Roles.consultant.toString());
    }
}
