package beezzy.dao;

import beezzy.domain.entities.GoodsEntity;

import java.util.List;

/**
 * Created by denisweeks on 19.04.16.
 */
public interface GoodsDao {

    GoodsEntity merge(GoodsEntity goods);

    List<GoodsEntity> get(int offset, int limit);

    public void delete(final int id);

}
