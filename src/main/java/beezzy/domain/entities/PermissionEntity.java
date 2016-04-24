package beezzy.domain.entities;

import beezzy.domain.enums.Permissions;

import javax.persistence.*;

/**
 * Created by oleh on 13.02.2016.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = PermissionEntity.GET_ALL, query = "SELECT p FROM PermissionEntity p"),
        @NamedQuery(name = PermissionEntity.GET_BY_ID, query = "SELECT permission FROM PermissionEntity permission WHERE permission.id = :id"),
        @NamedQuery(name = PermissionEntity.DELETE_BY_ID, query = "DELETE FROM PermissionEntity permission WHERE permission.id = :id")
})
@Table(name = "PERMISSIONS")
public class PermissionEntity {

    public static final String GET_ALL = "PermissionEntity.GET_ALL";
    public static final String GET_BY_ID = "PermissionEntity.GET_BY_ID";
    public static final String DELETE_BY_ID = "PermissionEntity.DELETE_BY_ID";

    @Id
    @Column(name = "ID")
    private int id;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "PERMISSION_NAME")
    private Permissions name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Permissions getName() {
        return name;
    }

    public void setName(Permissions name) {
        this.name = name;
    }
}
