package beezzy.dao;

import java.util.List;
import java.util.Map;

/**
 * Created by oleh on 12.02.2016.
 */
public interface Dao {

    <T> T merge(T object);

    <T> List<T> get(Class tClass, int offset, int limit);

    <T> T executeNamedQuery(Class tClass, String queryName, Map<String, Object> params);

}
