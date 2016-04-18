package beezzy.domain.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by oleh on 13.02.2016.
 */

@NamedQueries({
        @NamedQuery(name = ShopEntity.GET_ALL, query = "SELECT sh FROM ShopEntity sh"),
        @NamedQuery(name = ShopEntity.GET_BY_ID, query = "SELECT role FROM ShopEntity shop WHERE shop.id = :id"),
        @NamedQuery(name = ShopEntity.DELETE_BY_ID, query = "DELETE FROM ShopEntity shop WHERE shop.id = :id")
})
@Entity
@Table(name = "SHOPS")
public class ShopEntity {
    public static final String GET_ALL = "ShopEntity.GET_ALL";
    public static final String GET_BY_ID = "ShopEntity.GET_BY_ID";
    public static final String DELETE_BY_ID = "ShopEntity.DELETE_BY_ID";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OWNER_ID")
    private UserEntity owner;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "shop")
    private List<GoodsEntity> goods;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserEntity getOwner() {
        return owner;
    }

    public void setOwner(UserEntity owner) {
        this.owner = owner;
    }

    public List<GoodsEntity> getGoods() {
        return goods;
    }

    public void setGoods(List<GoodsEntity> goods) {
        this.goods = goods;
    }
}
