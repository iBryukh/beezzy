package beezzy.converters.impl;

import beezzy.converters.BaseConverter;
import beezzy.domain.entities.GoodsEntity;
import beezzy.domain.entities.ShopEntity;
import org.springframework.beans.factory.annotation.Autowired;

import static beezzy.converters.Fields.Shop.*;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


/**
 * Created by HP_PRO on 18.04.2016.
 */
public class ShopConverter extends BaseConverter<ShopEntity>{

    @Autowired
    private  BaseConverter<GoodsEntity> goodsConverter ;
    public Map<String, Object> convert(ShopEntity object, Set fields) {
        Map<String, Object> map = new HashMap<String, Object>();
        if(fields.contains(ID))
            map.put(ID, object.getId());
        if(fields.contains(NAME))
            map.put(NAME,object.getName());
        if(fields.contains(DESCRIPTION))
            map.put(DESCRIPTION,object.getDescription());
        if(fields.contains(OWNER)){
            map.put(OWNER,object.getOwner().getId());
        }
        if(fields.contains(GOODS)){
              map.put(GOODS,goodsConverter.convert(object.getGoods(), new HashSet<String>(){{add("id");}}));
        }
        return map;
    }
}
