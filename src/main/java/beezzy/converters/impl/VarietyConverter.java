package beezzy.converters.impl;


import beezzy.converters.BaseConverter;
import static beezzy.converters.Fields.Variety.*;
import beezzy.domain.entities.VarietyEntity;
import org.springframework.stereotype.Component;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by HP_PRO on 18.04.2016.
 */
@Component
public class VarietyConverter extends BaseConverter<VarietyEntity> {
    @Override
    public Map<String, Object> convert(VarietyEntity object, Set<String> fields) {
        Map<String, Object> map = new HashMap<String, Object>();

        if (fields.contains(ID))
            map.put(ID, object.getId());
        if (fields.contains(DESCRIPTION))
            map.put(DESCRIPTION, object.getDescription());
        if (fields.contains(AMOUNT))
            map.put(AMOUNT, object.getAmount());
        if (fields.contains(GOODS))
            map.put(GOODS, object.getId());
        if (fields.contains(PURCHASE_PRICE))
            map.put(PURCHASE_PRICE, object.getPurchasePrice());
        if (fields.contains(SELLING_PRICE))
            map.put(SELLING_PRICE, object.getSellingPrice());
        if (fields.contains(CODE))
            map.put(CODE, object.getCode());



        return map;
    }
}
