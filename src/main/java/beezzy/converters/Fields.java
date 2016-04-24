package beezzy.converters;

/**
 * Created by oleh on 08.03.2016.
 */
public class Fields {

    public static final class User {
        public static final String ID = "id";
        public static final String EMAIL = "email";
        public static final String ROLE = "role";
        public static final String ACTIVE = "active";
        public static final String SHOPS = "shops";
    }
    public static final class Category{
        public static final String ID = "id";
        public static final String NAME = "name";
        public static final String PARENT = "parent";
        public static final String CHILDREN = "children";
        public static final String SHOP = "shop";
    }
    public static final class Goods{
        public static final String ID = "id";
        public static final String NAME = "name";
        public static final String DESCRIPTION = "description";
        public static final String CATEGORY = "category";
        public static final String SHOP = "shop";
        public static final String VARIETIES = "varieties";

    }
    public static final class Permission{
        public static final String ID = "id";
        public static final String NAME = "name";
    }
    public static final class Role{
        public static final String ID = "id";
        public static final String NAME = "name";
        public static final String PERMISSIONS = "permissions";

    }
    public static final class Shop{
        public static final String ID = "id";
        public static final String NAME = "name";
        public static final String DESCRIPTION = "description";
        public static final String OWNER = "owner";
        public static final String GOODS = "goods";
    }
    public static final class Variety{
        public static final String ID = "id";
        public static final String DESCRIPTION = "description";
        public static final String AMOUNT = "amount";
        public static final String GOODS = "goods";
        public static final String PURCHASE_PRICE = "purchasePrice";
        public static final String SELLING_PRICE = "sellingPrice";
        public static final String CODE = "code";
    }



}
