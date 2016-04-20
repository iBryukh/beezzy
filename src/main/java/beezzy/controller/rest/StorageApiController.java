package beezzy.controller.rest;

import beezzy.domain.response.Response;
import beezzy.services.StorageService;
import com.dropbox.core.DbxException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by oleh_kurpiak on 20.04.16.
 */
@Controller
@RequestMapping("/api/storage")
public class StorageApiController {

    @Autowired
    private StorageService storageService;


    @RequestMapping(value = "/goods/{id}", method = RequestMethod.GET)
    public void getGoodsImage(@PathVariable("id") int id,
                              HttpServletResponse response) throws IOException, DbxException {
        storageService.downloadGoodsImage(response.getOutputStream(), id);
    }

    @RequestMapping(value = "/goods", method = RequestMethod.POST)
    public @ResponseBody
    Response<Boolean> postGoodsImage(@RequestParam("file") MultipartFile file,
                            @RequestParam("id") int id){
        boolean success = storageService.uploadGoodsImage(file, id);
        Response<Boolean> response = new Response<>();
        response.setResult(success);
        return response;
    }

    @RequestMapping(value = "/category/{id}", method = RequestMethod.GET)
    public void getCategoryImage(@PathVariable("id") int id,
                              HttpServletResponse response) throws IOException, DbxException {
        storageService.downloadCategoryImage(response.getOutputStream(), id);
    }

    @RequestMapping(value = "/category", method = RequestMethod.POST)
    public @ResponseBody
    Response<Boolean> postCategoryImage(@RequestParam("file") MultipartFile file,
                                        @RequestParam("id") int id){
        boolean success = storageService.uploadCategoryImage(file, id);
        Response<Boolean> response = new Response<>();
        response.setResult(success);
        return response;
    }

}
