package beezzy.dao;

import java.util.List;
import java.util.Map;

/**
 * Created by oleh on 12.02.2016.
 */
public interface Dao {

    <T> T merge(T object);

    <T> List<T> list_executeNamedQueryParams(String nameQuery, Map<String, Object> params, int offset, int limit);
    <T> List<T> list_executeNativeQueryParams(String nativeQuery, Map<String, Object> params, int offset, int limit);

    <T> T single_executeNameQueryParams(String nameQuery, Map<String, Object> params);
    <T> T single_executeNativeQueryParams(String nativeQuery, Map<String, Object> params, Class tClass);

    void executeUpdateNamed(String nameQuery, Map<String, Object> params);
    void executeUpdateNative(String nameQuery, Map<String, Object> params);

}
