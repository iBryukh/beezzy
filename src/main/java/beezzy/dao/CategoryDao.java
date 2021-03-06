package beezzy.dao;

import beezzy.domain.entities.CategoryEntity;

import java.util.List;

/**
 * Created by denisweeks on 19.04.16.
 */
public interface CategoryDao {

    CategoryEntity merge(CategoryEntity category);

    List<CategoryEntity> getByShop(int shopId, boolean root, int offset, int limit);

    List<CategoryEntity> get(int offset, int limit);

    CategoryEntity getById(int id);

    public void delete(final int id);

}
