package beezzy.controller.rest;

import beezzy.auth.aop.Auth;
import beezzy.domain.entities.GoodsEntity;
import beezzy.domain.enums.Roles;
import beezzy.domain.request.goods.GoodView;
import beezzy.domain.response.Response;
import beezzy.exceptions.NoSuchGoodsException;
import beezzy.services.GoodService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;

@Api(value = "api for goods")
@Controller
@RequestMapping("/api/goods")
public class GoodsApiController {

    @Autowired
    private GoodService goodService;


    @ApiOperation(value = "get good by id")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody Response<Map<String, Object>> getById(
            @ApiParam(value = "good id", required = true)
            @PathVariable(value = "id") int id,

            @ApiParam(value = "fields", defaultValue = "id, name, description, category_id", required = false)
            @RequestParam(value = "fields", required = false, defaultValue = "id, name, description, category_id") Set<String> fields
    ) throws NoSuchGoodsException {
        Response<Map<String, Object>> response = new Response<Map<String, Object>>();
        response.setResult(goodService.getById(id, fields));
        return response;
    }

    @ApiOperation(value = "create goods")
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public @ResponseBody Response<Map<String, Object>> putGood(
            @ApiParam(value = "goods json body")
            @RequestBody GoodView goodView) throws NoSuchGoodsException {
        goodService.putGood(goodView);
        Response<Map<String, Object>> response = new Response<Map<String, Object>>();
        response.setResult(goodService.putGood(goodView));
        return response;
    }

    @ApiOperation(value = "update goods")
    @Auth(required = true, roles = {Roles.owner, Roles.admin, Roles.consultant})
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public @ResponseBody Response<Boolean> postGood(
            @ApiParam(value = "goods json body")
            @RequestBody GoodView goodView) throws NoSuchGoodsException {
        goodService.postGood(goodView);
        Response<Boolean> response = new Response<Boolean>();
        response.setResult(new Boolean(goodService.postGood(goodView)));
        return response;
    }

    @ApiOperation(value = "delete good")
    @Auth(required = true, roles = {Roles.owner, Roles.admin, Roles.consultant})
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public @ResponseBody Response<Boolean> deleteGood(
            @ApiParam(value = "good id")
            @PathVariable int id) throws NoSuchGoodsException {
        Response<Boolean> response = new Response<Boolean>();
        response.setResult(new Boolean(goodService.deleteGood(id)));
        return response;
    }

}
