package beezzy.converters;

import java.util.*;

/**
 * Created by oleh on 08.03.2016.
 */
public interface Converter<T> {

    Map<String, Object> convert(T object, Set<String> fields);

}
