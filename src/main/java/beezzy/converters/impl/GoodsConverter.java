package beezzy.converters.impl;


        import beezzy.converters.BaseConverter;
        import beezzy.domain.entities.GoodsEntity;
        import beezzy.domain.entities.VarietyEntity;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Component;

        import static beezzy.converters.Fields.Goods.*;

        import java.util.HashMap;
        import java.util.HashSet;
        import java.util.Map;
        import java.util.Set;


/**
 * Created by HP_PRO on 18.04.2016.
 */
@Component
public class GoodsConverter extends BaseConverter<GoodsEntity> {
    @Autowired
    private  BaseConverter<VarietyEntity> varietyConverter ;
    public Map<String, Object> convert(GoodsEntity object, Set<String> fields) {
        Map<String, Object> map = new HashMap<String, Object>();

        if (fields.contains(ID))
            map.put(ID, object.getId());
        if (fields.contains(NAME))
            map.put(NAME, object.getName());
        if (fields.contains(DESCRIPTION))
            map.put(DESCRIPTION, object.getDescription());
        if (fields.contains(CATEGORY))
            map.put(CATEGORY, object.getCategory());
        if (fields.contains(SHOP))
            map.put(SHOP, object.getShop());
        if (fields.contains(DESCRIPTION))
            map.put(DESCRIPTION, object.getDescription());
        if (fields.contains(VARIETIES))
            map.put(VARIETIES, varietyConverter.convert(object.getVarieties(), new HashSet<String>(){{add("id");}}));


        return map;
    }
}
