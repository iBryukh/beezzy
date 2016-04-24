package beezzy.domain.request.variety;

public class VarietyView {

    private int id;
    private int goods_id;
    private String description;
    private int amount;
    private double p_price;
    private double s_price;
    private String code;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGoodsId() { return goods_id; }

    public void setGoodsId(int goods_id) { this.goods_id = goods_id; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public int getAmount() { return amount; }

    public void setAmount(int amount) { this.amount = amount; }

    public double getP_price() { return p_price; }

    public void setP_price(double p_price) { this.p_price = p_price; }

    public double getS_price() { return s_price; }

    public void setS_price(double s_price) { this.s_price = s_price; }

    public String getCode() { return code; }

    public void setCode(String code) { this.code = code; }

}