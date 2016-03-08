package beezzy.domain.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by oleh on 13.02.2016.
 */
@Entity
@Table(name = "CATEGORY")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
