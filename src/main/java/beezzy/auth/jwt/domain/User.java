package beezzy.auth.jwt.domain;

import beezzy.domain.entities.PermissionEntity;
import beezzy.domain.entities.RoleEntity;
import beezzy.domain.entities.UserEntity;
import beezzy.domain.enums.Permissions;
import beezzy.domain.enums.Roles;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oleh on 06.04.2016.
 */
public class User {

    private int id;

    private String email;

    private Roles role;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }
}
