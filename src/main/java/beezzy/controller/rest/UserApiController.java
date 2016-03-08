package beezzy.controller.rest;

import beezzy.domain.response.Response;
import beezzy.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * Created by oleh on 08.03.2016.
 */
@Controller
@RequestMapping("/api/users")
public class UserApiController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public @ResponseBody Response<List<Map<String, Object>>> getUsers(
            @RequestParam(value = "offset", required = false, defaultValue = "0") int offset,
            @RequestParam(value = "limit", required = false, defaultValue = "10") int limit,
            @RequestParam(value = "fields", required = false, defaultValue = "id, email") Set<String> fields
    ){
        Response<List<Map<String, Object>>> response = new Response<List<Map<String, Object>>>();
        response.setResult(userService.get(fields, offset, limit));
        return response;
    }

}
