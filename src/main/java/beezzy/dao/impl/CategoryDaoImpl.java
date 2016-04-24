package beezzy.dao.impl;

import beezzy.dao.CategoryDao;
import beezzy.domain.entities.CategoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * Created by denisweeks on 19.04.16.
 */
@Repository
public class CategoryDaoImpl implements CategoryDao {

    @Autowired
    private DaoImpl dao;


    @Override
    public CategoryEntity merge(CategoryEntity category) {
        return dao.merge(category);
    }

    @Override
    public List<CategoryEntity> getByShop(final int shopId, boolean root, int offset, int limit) {
        return dao.list_executeNamedQueryParams(
                root ? CategoryEntity.GET_BY_SHOP_ROOT : CategoryEntity.GET_BY_SHOP,
                new HashMap<String, Object>(){{
                    put("id", shopId);
                }},
                offset,
                limit
        );
    }

    @Override
    public List<CategoryEntity> get(int offset, int limit) {
        return dao.list_executeNamedQueryParams(
                CategoryEntity.GET_ALL,
                null,
                offset,
                limit
        );
    }

    @Override
    public CategoryEntity getById(final int id) {
        return dao.single_executeNameQueryParams(
                CategoryEntity.GET_BY_ID,
                new HashMap<String, Object>(){{
                    put("id", id);
                }}
        );
    }

    @Override
    public void delete(final int id) {
        dao.executeUpdateNamed(
                CategoryEntity.DELETE_BY_ID,
                new HashMap<String, Object>(){{
                    put("id", id);
                }}
        );
    }


}