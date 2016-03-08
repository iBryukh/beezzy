package beezzy.domain.entities;

import javax.persistence.*;

/**
 * Created by oleh on 08.03.2016.
 */
@Entity
public class VarietyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "AMOUNT")
    private int amount;

    @ManyToOne
    @JoinColumn(name = "GOODS_ID")
    private GoodsEntity goods;

    @Column(name = "PURCHASE_PRICE")
    private double purchasePrice;

    @Column(name = "SELLING_PRICE")
    private double sellingPrice;

    @Column(name = "CODE")
    private String code;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public GoodsEntity getGoods() {
        return goods;
    }

    public void setGoods(GoodsEntity goods) {
        this.goods = goods;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
