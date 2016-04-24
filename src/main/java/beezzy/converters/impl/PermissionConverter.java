package beezzy.converters.impl;


        import beezzy.converters.BaseConverter;
        import static beezzy.converters.Fields.Permission.*;
        import beezzy.domain.entities.PermissionEntity;
        import org.springframework.stereotype.Component;


        import java.util.HashMap;
        import java.util.Map;
        import java.util.Set;
/**
 * Created by HP_PRO on 18.04.2016.
 */

@Component
public class PermissionConverter extends BaseConverter<PermissionEntity> {
    public Map<String, Object> convert(PermissionEntity object, Set<String> fields) {
        Map<String, Object> map = new HashMap<String, Object>();

        if (fields.contains(ID))
            map.put(ID, object.getId());
        if (fields.contains(NAME))
            map.put(NAME, object.getName());

        return map;
    }
}
