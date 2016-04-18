package beezzy.dao.impl;

import beezzy.dao.ShopDao;
import beezzy.domain.entities.ShopEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * Created by denisweeks on 19.04.16.
 */
@Repository
public class ShopDaoImpl implements ShopDao {

    @Autowired
    private DaoImpl dao;


    @Override
    public ShopEntity merge(ShopEntity shop) {
        return dao.merge(shop);
    }

    @Override
    public List<ShopEntity> get(int offset, int limit) {
        return dao.list_executeNamedQueryParams(
                ShopEntity.GET_ALL,
                null,
                offset,
                limit
        );
    }

    @Override
    public void delete(final int id) {
        dao.executeUpdateNamed(
                ShopEntity.DELETE_BY_ID,
                new HashMap<String, Object>(){{
                    put("id", id);
                }}
        );
    }


}