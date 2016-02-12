package beezyy.dao;

/**
 * Created by oleh on 12.02.2016.
 */
public interface Dao {

    <T> T merge(T object);

    <T> T get(Class tClass, int offset, int limit);

}
