package beezzy.converters.impl;
import beezzy.converters.BaseConverter;
import static beezzy.converters.Fields.Role.*;

import beezzy.domain.entities.PermissionEntity;
import beezzy.domain.entities.RoleEntity;
import beezzy.domain.enums.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.*;

/**
 * Created by HP_PRO on 18.04.2016.
 */
@Component
public class RoleConverter extends BaseConverter<RoleEntity> {
    @Autowired
    private  BaseConverter<PermissionEntity> permissionConverter ;
    public Map<String, Object> convert(RoleEntity object, Set<String> fields){
        Map<String, Object>map=new HashMap<String, Object>();

        if(fields.contains(ID))
            map.put(ID,object.getId());
        if(fields.contains(NAME))
            map.put(NAME,object.getName());
        if(fields.contains(PERMISSIONS))
            map.put(PERMISSIONS,permissionConverter.convert(object.getPermissions(), new HashSet<String>(){{add("id");}}));


            return map;
        }
}
