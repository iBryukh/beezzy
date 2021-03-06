package beezzy.domain.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by oleh on 12.02.2016.
 */
@Entity
@Table(name = "USERS")
@NamedQueries({
        @NamedQuery(name = UserEntity.GET_ALL, query = "SELECT u FROM UserEntity u"),
        @NamedQuery(name = UserEntity.GET_BY_EMAIL, query = "SELECT user FROM UserEntity user WHERE user.email = :email"),
        @NamedQuery(name = UserEntity.GET_BY_ID, query = "SELECT user FROM UserEntity user WHERE user.id = :id"),
        @NamedQuery(name = UserEntity.DELETE_BY_ID, query = "DELETE FROM UserEntity user WHERE user.id = :id")
})
public class UserEntity {

    public static final String GET_BY_EMAIL = "UserEntity.GET_BY_EMAIL";
    public static final String GET_ALL = "UserEntity.GET_ALL";
    public static final String GET_BY_ID = "UserEntity.GET_BY_ID";
    public static final String DELETE_BY_ID = "UserEntity.DELETE_BY_ID";

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PASSWORD")
    private String password;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ROLE_ID")
    private RoleEntity role;

    @Column(name = "ACTIVE")
    private boolean active;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "owner")
    private List<ShopEntity> shops;

    public int getId() {
        return id;
    }

    public void setId(int id) { this.id = id; }

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

    public RoleEntity getRole() {
        return role;
    }

    public void setRole(RoleEntity role) {
        this.role = role;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<ShopEntity> getShops() {
        return shops;
    }

    public void setShops(List<ShopEntity> shops) {
        this.shops = shops;
    }
}
