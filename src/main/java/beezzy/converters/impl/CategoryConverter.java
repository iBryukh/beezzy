package beezzy.converters.impl;

import beezzy.converters.BaseConverter;
import static beezzy.converters.Fields.Category.*;
import beezzy.domain.entities.CategoryEntity;
import org.springframework.stereotype.Component;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


/**
 * Created by HP_PRO on 18.04.2016.
 */
@Component
public class CategoryConverter extends BaseConverter <CategoryEntity> {
    public Map<String, Object> convert(CategoryEntity object, Set<String> fields) {
        Map<String, Object> map = new HashMap<String, Object>();

        if (fields.contains(ID))
            map.put(ID, object.getId());
        if (fields.contains(NAME))
            map.put(NAME, object.getName());
        if (fields.contains(PARENT))
            map.put(PARENT, object.getParent().getId());
        if (fields.contains(CHILDREN))
            map.put(CHILDREN, convert(object.getChildren(), new HashSet<String>(){{add("id");}}));
        if (fields.contains(SHOP))
            map.put(SHOP, object.getShop().getId());

        return map;
    }
}
