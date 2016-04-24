package beezzy.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oleh on 24.04.2016.
 */
public class Lists {

    public <T, E> List<E> transform(List<T> objects, Function<T, E> function){
        List<E> list = new ArrayList<>();

        if(objects != null){
            for(T t : objects){
                list.add(function.apply(t));
            }
        }

        return list;
    }

}
