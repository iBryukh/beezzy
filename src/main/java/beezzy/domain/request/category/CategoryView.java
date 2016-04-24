package beezzy.domain.request.category;

public class CategoryView {

    private int id;
    private String name;
    private int parent_id;

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

    public int getParentId() { return parent_id; }

    public void setParentId(int parent_id) { this.parent_id = parent_id; }

}