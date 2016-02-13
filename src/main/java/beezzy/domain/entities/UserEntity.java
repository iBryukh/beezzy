package beezzy.domain.entities;

import javax.persistence.*;

/**
 * Created by oleh on 12.02.2016.
 */
@Entity
@Table(name = "USERS")
@NamedQueries({
        @NamedQuery(name = UserEntity.GET_BY_EMAIL, query = "SELECT user FROM UserEntity user WHERE user.email = :email")
})
public class UserEntity {

    public static final String GET_BY_EMAIL = "UserEntity.GET_BY_EMAIL";

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int id;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "ROLE_ID")
    private int roleId;

    @Column(name = "ACTIVE")
    private boolean active;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
