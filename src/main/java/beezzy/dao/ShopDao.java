package beezzy.dao;

import beezzy.domain.entities.ShopEntity;

import java.util.List;

/**
 * Created by denisweeks on 19.04.16.
 */
public interface ShopDao {

    ShopEntity merge(ShopEntity user);

    List<ShopEntity> get(int offset, int limit);

    public void delete(final int id);

}
