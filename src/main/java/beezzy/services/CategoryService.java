package beezzy.services;

import beezzy.domain.entities.CategoryEntity;
import beezzy.domain.request.category.CategoryView;
import beezzy.exceptions.NoSuchCategoryException;

import java.util.Map;
import java.util.Set;

public interface CategoryService {

    CategoryEntity merge(CategoryEntity category);

    Map<String, Object> getById(int id, Set<String> fields) throws NoSuchCategoryException;

    Map<String, Object> putCategory(CategoryView categoryView);

    boolean postCategory(CategoryView categoryView) throws NoSuchCategoryException;

    boolean deleteCategory(int id) throws NoSuchCategoryException;

}
