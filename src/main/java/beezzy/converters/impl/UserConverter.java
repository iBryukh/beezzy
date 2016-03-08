package beezzy.converters.impl;

import beezzy.converters.BaseConverter;
import static beezzy.converters.Fields.User.*;
import beezzy.domain.entities.UserEntity;
import org.springframework.stereotype.Component;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;


/**
 * Created by oleh on 08.03.2016.
 */
@Component
public class UserConverter extends BaseConverter<UserEntity> {

    @Override
    public Map<String, Object> convert(UserEntity object, Set<String> fields) {
        Map<String, Object> map = new HashMap<String, Object>();

        if(fields.contains(ID))
            map.put(ID, object.getId());
        if(fields.contains(EMAIL))
            map.put(EMAIL, object.getEmail());
        if(fields.contains(ROLE))
            map.put(ROLE, object.getRole().getName());
        if(fields.contains(ACTIVE))
            map.put(ACTIVE, object.isActive());
        if(fields.contains(SHOPS)){
            //shops converter here
        }

        return map;
    }

}
