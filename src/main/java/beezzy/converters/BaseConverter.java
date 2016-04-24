package beezzy.converters;


import beezzy.utils.Function;
import beezzy.utils.Lists;

import java.util.*;

/**
 * Created by oleh on 08.03.2016.
 */

public abstract class BaseConverter<T> {

    private Lists lists = new Lists();

    public abstract Map<String, Object> convert(T objects, final Set<String> fields);

    public List<Map<String, Object>> convert(List<T> objects, final Set<String> fields) {
        return lists.transform(objects, new Function<T, Map<String, Object>>(){
            @Override
            public Map<String, Object> apply(T t) {
                return convert(t, fields);
            }
        });
    }

}
