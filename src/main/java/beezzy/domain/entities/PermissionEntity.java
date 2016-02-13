package beezzy.domain.entities;

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

    @Column(name = "PERMISSION_NAME")
    private String name;

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
}
