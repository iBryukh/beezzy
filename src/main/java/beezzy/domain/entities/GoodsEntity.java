package beezzy.domain.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by oleh on 08.03.2016.
 */
@Entity
public class GoodsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

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
