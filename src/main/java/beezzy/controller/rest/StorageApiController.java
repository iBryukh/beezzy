package beezzy.controller.rest;

import beezzy.domain.response.Response;
import beezzy.services.StorageService;
import com.dropbox.core.DbxException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by oleh_kurpiak on 20.04.16.
 */
@Api(value = "storage api")
@Controller
@RequestMapping("/api/storage")
public class StorageApiController {

    @Autowired
    private StorageService storageService;


    @ApiOperation(value = "get goods photo")
    @RequestMapping(value = "/goods/{id}", method = RequestMethod.GET)
    public void getGoodsImage(
            @ApiParam(value = "goods id", required = true)
            @PathVariable("id") int id,

            HttpServletResponse response) throws IOException, DbxException {
        storageService.downloadGoodsImage(response.getOutputStream(), id);
    }

    @ApiOperation(value = "upload goods id photo")
    @RequestMapping(value = "/goods", method = RequestMethod.POST)
    public @ResponseBody
    Response<Boolean> postGoodsImage(
            @ApiParam(value = "new photo", required = true)
            @RequestParam("file") MultipartFile file,

            @ApiParam(value = "id of goods", required = true)
            @RequestParam("id") int id){
        boolean success = storageService.uploadGoodsImage(file, id);
        Response<Boolean> response = new Response<>();
        response.setResult(success);
        return response;
    }

    @ApiOperation(value = "get category photo")
    @RequestMapping(value = "/category/{id}", method = RequestMethod.GET)
    public void getCategoryImage(
            @ApiParam(value = "category id", required = true)
            @PathVariable("id") int id,

            HttpServletResponse response) throws IOException, DbxException {
        storageService.downloadCategoryImage(response.getOutputStream(), id);
    }

    @ApiOperation(value = "upload category photo")
    @RequestMapping(value = "/category", method = RequestMethod.POST)
    public @ResponseBody
    Response<Boolean> postCategoryImage(
            @ApiParam(value = "file", required = true)
            @RequestParam("file") MultipartFile file,

            @ApiParam(value = "category id", required = true)
            @RequestParam("id") int id){
        boolean success = storageService.uploadCategoryImage(file, id);
        Response<Boolean> response = new Response<>();
        response.setResult(success);
        return response;
    }

}
