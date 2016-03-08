package beezzy.domain.entities;

import beezzy.domain.enums.Roles;

import javax.persistence.*;
import java.util.List;

/**
 * Created by oleh on 13.02.2016.
 */
@Entity
@Table(name = "ROLES")
public class RoleEntity {

    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "ROLE_NAME")
    @Enumerated(EnumType.STRING)
    private Roles name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "ROLE_TO_PERMISSION", joinColumns = @JoinColumn(name = "ROLE_ID"), inverseJoinColumns = @JoinColumn(name = "PERMISSION_ID"))
    private List<PermissionEntity> permissions;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Roles getName() {
        return name;
    }

    public void setName(Roles name) {
        this.name = name;
    }

    public List<PermissionEntity> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<PermissionEntity> permissions) {
        this.permissions = permissions;
    }
}
