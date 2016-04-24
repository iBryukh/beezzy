package beezzy.domain.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by oleh on 08.03.2016.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = GoodsEntity.GET_ALL, query = "SELECT g FROM GoodsEntity g"),
        @NamedQuery(name = GoodsEntity.GET_BY_ID, query = "SELECT goods FROM GoodsEntity goods WHERE goods.id = :id"),
        @NamedQuery(name = GoodsEntity.DELETE_BY_ID, query = "DELETE FROM GoodsEntity goods WHERE goods.id = :id")
})
@Table(name = "GOODS")
public class GoodsEntity {

    public static final String GET_ALL = "GoodsEntity.GET_ALL";
    public static final String GET_BY_ID = "GoodsEntity.GET_BY_ID";
    public static final String DELETE_BY_ID = "GoodsEntity.DELETE_BY_ID";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CATEGORY_ID")
    private CategoryEntity category;

    @ManyToOne
    @JoinColumn(name = "SHOP_ID")
    private ShopEntity shop;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "goods")
    private List<VarietyEntity> varieties;

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

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) { this.category = category; }

    public ShopEntity getShop() {
        return shop;
    }

    public void setShop(ShopEntity shop) {
        this.shop = shop;
    }

    public List<VarietyEntity> getVarieties() {
        return varieties;
    }

    public void setVarieties(List<VarietyEntity> varieties) {
        this.varieties = varieties;
    }

}
