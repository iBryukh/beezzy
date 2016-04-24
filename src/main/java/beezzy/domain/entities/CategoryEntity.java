package beezzy.domain.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by oleh on 13.02.2016.
 */
@Entity
@Table(name = "CATEGORY")
@NamedQueries({
        @NamedQuery(name = CategoryEntity.GET_BY_SHOP, query = "SELECT category FROM CategoryEntity category WHERE category.shop.id = :id"),
        @NamedQuery(name = CategoryEntity.GET_ALL, query = "SELECT c FROM CategoryEntity c"),
        @NamedQuery(name = CategoryEntity.GET_BY_ID, query = "SELECT category FROM CategoryEntity category WHERE category.id = :id"),
        @NamedQuery(name = CategoryEntity.DELETE_BY_ID, query = "DELETE FROM CategoryEntity category WHERE category.id = :id")
})
public class CategoryEntity {
    public static final String GET_BY_SHOP = "CategoryEntity.GET_BY_SHOP";
    public static final String GET_ALL = "CategoryEntity.GET_ALL";
    public static final String GET_BY_ID = "CategoryEntity.GET_BY_ID";
    public static final String DELETE_BY_ID = "CategoryEntity.DELETE_BY_ID";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "NAME")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_ID")
    private CategoryEntity parent;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parent")
    private List<CategoryEntity> children;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SHOP_ID")
    private ShopEntity shop;

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

    public CategoryEntity getParent() {
        return parent;
    }

    public void setParent(CategoryEntity parent) {
        this.parent = parent;
    }

    public List<CategoryEntity> getChildren() {
        return children;
    }

    public void setChildren(List<CategoryEntity> children) {
        this.children = children;
    }

    public ShopEntity getShop() {
        return shop;
    }

    public void setShop(ShopEntity shop) {
        this.shop = shop;
    }
}
