package beezzy.controller.rest;

import beezzy.auth.aop.Auth;
import beezzy.domain.entities.CategoryEntity;
import beezzy.domain.enums.Roles;
import beezzy.domain.request.category.CategoryView;
import beezzy.domain.response.Response;
import beezzy.exceptions.NoSuchCategoryException;
import beezzy.services.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;

@Api(value = "api for category")
@Controller
@RequestMapping("/api/categories")
public class CategoryApiController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryEntity categoryEntity;


    @ApiOperation(value = "get category by id")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody Response<Map<String, Object>> getById(
            @ApiParam(value = "category id", required = true)
            @PathVariable(value = "id") int id,

            @ApiParam(value = "fields", defaultValue = "id, name, parent_id", required = false)
            @RequestParam(value = "fields", required = false, defaultValue = "id, name, parent_id") Set<String> fields
    ) throws NoSuchCategoryException {
        Response<Map<String, Object>> response = new Response<Map<String, Object>>();
        response.setResult(categoryService.getById(id, fields));
        return response;
    }

    @ApiOperation(value = "create category")
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public @ResponseBody Response<Map<String, Object>> putGood(
            @ApiParam(value = "category json body")
            @RequestBody CategoryView categoryView) throws NoSuchCategoryException {
        categoryService.putCategory(categoryView);
        Response<Map<String, Object>> response = new Response<Map<String, Object>>();
        response.setResult(categoryService.putCategory(categoryView));
        return response;
    }

    @ApiOperation(value = "update category")
    @Auth(required = true, roles = {Roles.owner, Roles.admin, Roles.consultant})
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public @ResponseBody Response<Boolean> postCategory(
            @ApiParam(value = "category json body")
            @RequestBody CategoryView categoryView) throws NoSuchCategoryException {
        categoryService.postCategory(categoryView);
        Response<Boolean> response = new Response<Boolean>();
        response.setResult(new Boolean(categoryService.postCategory(categoryView)));
        return response;
    }

    @ApiOperation(value = "delete category")
    @Auth(required = true, roles = {Roles.owner, Roles.admin, Roles.consultant})
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public @ResponseBody Response<Boolean> deleteCategory(
            @ApiParam(value = "category id")
            @PathVariable int id) throws NoSuchCategoryException {
        Response<Boolean> response = new Response<Boolean>();
        response.setResult(new Boolean(categoryService.deleteCategory(id)));
        return response;
    }

}
