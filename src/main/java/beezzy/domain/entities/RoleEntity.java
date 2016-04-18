package beezzy.domain.entities;

import beezzy.domain.enums.Roles;

import javax.persistence.*;
import java.util.List;

/**
 * Created by oleh on 13.02.2016.
 */
@NamedQueries({
        @NamedQuery(name = RoleEntity.GET_ALL, query = "SELECT r FROM RoleEntity r"),
        @NamedQuery(name = RoleEntity.GET_BY_ID, query = "SELECT role FROM RoleEntity role WHERE role.id = :id"),
        @NamedQuery(name = RoleEntity.DELETE_BY_ID, query = "DELETE FROM RoleEntity role WHERE role.id = :id")
})
@Entity
@Table(name = "ROLES")
public class RoleEntity {

    public static final String GET_ALL = "RoleEntity.GET_ALL";
    public static final String GET_BY_ID = "RoleEntity.GET_BY_ID";
    public static final String DELETE_BY_ID = "RoleEntity.DELETE_BY_ID";
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
