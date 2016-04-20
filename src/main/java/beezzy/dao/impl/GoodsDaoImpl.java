package beezzy.dao.impl;

import beezzy.dao.GoodsDao;
import beezzy.domain.entities.GoodsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * Created by denisweeks on 19.04.16.
 */
@Repository
public class GoodsDaoImpl implements GoodsDao {

    @Autowired
    private DaoImpl dao;


    @Override
    public GoodsEntity merge(GoodsEntity goods) {
        return dao.merge(goods);
    }

    @Override
    public List<GoodsEntity> get(int offset, int limit) {
        return dao.list_executeNamedQueryParams(
                GoodsEntity.GET_ALL,
                null,
                offset,
                limit
        );
    }

    @Override
    public GoodsEntity getById(final int id) {
        return dao.single_executeNameQueryParams(
                GoodsEntity.GET_BY_ID,
                new HashMap<String, Object>(){{
                    put("id", id);
                }}
        );
    }

    @Override
    public void delete(final int id) {
        dao.executeUpdateNamed(
                GoodsEntity.DELETE_BY_ID,
                new HashMap<String, Object>(){{
                    put("id", id);
                }}
        );
    }


}