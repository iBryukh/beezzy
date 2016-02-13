package beezzy.domain.entities;

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
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "ROLE_TO_PERMISSION", joinColumns = @JoinColumn(name = "ROLE_ID"), inverseJoinColumns = @JoinColumn(name = "PERMISSION_ID"))
    private List<PermissionEntity> permissions;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PermissionEntity> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<PermissionEntity> permissions) {
        this.permissions = permissions;
    }
}
