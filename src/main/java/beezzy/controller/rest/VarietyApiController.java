package beezzy.controller.rest;

import beezzy.auth.aop.Auth;
import beezzy.domain.entities.GoodsEntity;
import beezzy.domain.entities.VarietyEntity;
import beezzy.domain.enums.Roles;
import beezzy.domain.request.goods.GoodView;
import beezzy.domain.request.variety.VarietyView;
import beezzy.domain.response.Response;
import beezzy.exceptions.NoSuchGoodsException;
import beezzy.exceptions.NoSuchVarietiesException;
import beezzy.services.GoodService;
import beezzy.services.VarietyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;

@Api(value = "api for variety")
@Controller
@RequestMapping("/api/varieties")
public class VarietyApiController {

    @Autowired
    private VarietyService varietyService;

    @Autowired
    private VarietyEntity varietyEntity;


    @ApiOperation(value = "get varieties by id")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody Response<Map<String, Object>> getById(
            @ApiParam(value = "variety id", required = true)
            @PathVariable(value = "id") int id,

            @ApiParam(value = "fields", defaultValue = "id, goods_id, description, amount, p_price, s_price, code", required = false)
            @RequestParam(value = "fields", required = false, defaultValue = "id, goods_id, description, amount, p_price, s_price, code") Set<String> fields
    ) throws NoSuchVarietiesException {
        Response<Map<String, Object>> response = new Response<Map<String, Object>>();
        response.setResult(varietyService.getById(id, fields));
        return response;
    }

    @ApiOperation(value = "create varieties")
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public @ResponseBody Response<Map<String, Object>> putGood(
            @ApiParam(value = "variety json body")
            @RequestBody VarietyView varietyView) throws NoSuchVarietiesException {
        varietyService.putVariety(varietyView);
        Response<Map<String, Object>> response = new Response<Map<String, Object>>();
        response.setResult(varietyService.putVariety(varietyView));
        return response;
    }

    @ApiOperation(value = "update varieties")
    @Auth(required = true, roles = {Roles.owner, Roles.admin, Roles.consultant})
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public @ResponseBody Response<Boolean> postVariety(
            @ApiParam(value = "variety json body")
            @RequestBody VarietyView varietyView) throws NoSuchVarietiesException {
        varietyService.postVariety(varietyView);
        Response<Boolean> response = new Response<Boolean>();
        response.setResult(new Boolean(varietyService.postVariety(varietyView)));
        return response;
    }

    @ApiOperation(value = "delete varieties")
    @Auth(required = true, roles = {Roles.owner, Roles.admin, Roles.consultant})
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public @ResponseBody Response<Boolean> deleteVariety(
            @ApiParam(value = "variety id")
            @PathVariable int id) throws NoSuchVarietiesException {
        Response<Boolean> response = new Response<Boolean>();
        response.setResult(new Boolean(varietyService.deleteVariety(id)));
        return response;
    }

}
