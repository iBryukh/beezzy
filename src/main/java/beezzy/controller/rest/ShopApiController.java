package beezzy.controller.rest;

import beezzy.auth.aop.Auth;
import beezzy.domain.entities.ShopEntity;
import beezzy.domain.enums.Roles;
import beezzy.domain.request.shop.ShopView;
import beezzy.domain.response.Response;
import beezzy.exceptions.*;
import beezzy.services.ShopService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;

@Api(value = "api for shops")
@Controller
@RequestMapping("/api/shops")
public class ShopApiController {

    @Autowired
    private ShopService shopService;

    @ApiOperation(value = "get shop by id")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody Response<Map<String, Object>> getById(
            @ApiParam(value = "shop id", required = true)
            @PathVariable(value = "id") int id,

            @ApiParam(value = "fields", defaultValue = "id, name", required = false)
            @RequestParam(value = "fields", required = false, defaultValue = "id, name") Set<String> fields
    ) throws NoSuchShopException {
        Response<Map<String, Object>> response = new Response<Map<String, Object>>();
        response.setResult(shopService.getById(id, fields));
        return response;
    }

    @ApiOperation(value = "create shop")
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public @ResponseBody Response<Map<String, Object>> putShop(
            @ApiParam(value = "user json body")
            @RequestBody ShopView shopView) throws NoSuchShopException {
        ShopEntity shopEntity = new ShopEntity();
        shopEntity.setName(shopView.getName());
        shopEntity.setDescription(shopView.getDescription());
        Response<Map<String, Object>> response = new Response<Map<String, Object>>();
        response.setResult(shopService.putShop(shopEntity));
        return response;
    }

    @ApiOperation(value = "update shop")
    @Auth(required = true, roles = {Roles.owner, Roles.admin, Roles.consultant})
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public @ResponseBody Response<Boolean> postShop(
            @ApiParam(value = "shop json body")
            @RequestBody ShopView shopView) throws NoSuchShopException {
        ShopEntity shopEntity = new ShopEntity();
        shopEntity.setId(shopView.getId());
        shopEntity.setName(shopView.getName());
        shopEntity.setDescription(shopView.getDescription());
        Response<Boolean> response = new Response<Boolean>();
        response.setResult(new Boolean(shopService.postShop(shopEntity)));
        return response;
    }

    @ApiOperation(value = "delete shop")
    @Auth(required = true, roles = {Roles.owner, Roles.admin, Roles.consultant})
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public @ResponseBody Response<Boolean> deleteShop(
            @ApiParam(value = "shop id")
            @PathVariable int id) throws NoSuchShopException {
        Response<Boolean> response = new Response<Boolean>();
        response.setResult(new Boolean(shopService.deleteShop(id)));
        return response;
    }

}
