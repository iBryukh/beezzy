package beezzy.domain.entities;

import beezzy.domain.enums.Permissions;

import javax.persistence.*;

/**
 * Created by oleh on 13.02.2016.
 */
@Entity
@Table(name = "PERMISSIONS")
public class PermissionEntity {

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
