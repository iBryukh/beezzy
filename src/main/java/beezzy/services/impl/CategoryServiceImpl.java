package beezzy.services.impl;

import beezzy.converters.BaseConverter;
import beezzy.dao.CategoryDao;
import beezzy.dao.ShopDao;
import beezzy.domain.entities.CategoryEntity;
import beezzy.domain.entities.ShopEntity;
import beezzy.domain.request.category.CategoryView;
import beezzy.exceptions.NoSuchCategoryException;
import beezzy.exceptions.NoSuchShopException;
import beezzy.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private ShopDao shopDao;

    @Autowired
    private BaseConverter<CategoryEntity> categoryConverter;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public CategoryEntity merge(CategoryEntity category) {
        if(category == null)
            return null;
        return categoryDao.merge(category);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Map<String, Object> getById(int id, Set<String> fields) throws NoSuchCategoryException{
        CategoryEntity categoryEntity = categoryDao.getById(id);
        if (categoryEntity==null)
            throw new NoSuchCategoryException();
        return categoryConverter.convert(categoryEntity, fields);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Map<String, Object> putCategory(CategoryView categoryView) {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setName(categoryView.getName());
        categoryEntity.setParent(categoryDao.getById(categoryView.getParentId()));
        return categoryConverter.convert(categoryDao.merge(categoryEntity), new HashSet<String>(){{add("id");}});
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean postCategory(CategoryView categoryView) throws NoSuchCategoryException{
        if (categoryDao.getById(categoryView.getId()) != null) {
            CategoryEntity categoryEntity = new CategoryEntity();
            categoryEntity.setId(categoryView.getId());
            categoryEntity.setName(categoryView.getName());
            categoryEntity.setParent(categoryDao.getById(categoryView.getParentId()));
            categoryDao.merge(categoryEntity);
            return true;
        } else {
            throw new NoSuchCategoryException();
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean deleteCategory(int id) throws NoSuchCategoryException{
        if (categoryDao.getById(id) != null) {
            categoryDao.delete(id);
            return true;
        } else {
            throw new NoSuchCategoryException();
        }
    }

    @Override
    public List<Map<String, Object>> getByShop(int shopId, boolean root, Set<String> fileds, int offset, int limit) throws NoSuchShopException {
        ShopEntity shopEntity = shopDao.getById(shopId);
        if (shopEntity==null)
            throw new NoSuchShopException();
        return categoryConverter.convert(categoryDao.getByShop(shopId, root, offset, limit), fileds);
    }

}
