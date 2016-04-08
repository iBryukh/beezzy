package beezzy.controller.rest;

import beezzy.auth.aop.Auth;
import beezzy.domain.enums.Roles;
import beezzy.domain.request.user.UserAuth;
import beezzy.domain.response.Response;
import beezzy.services.UserService;
import beezzy.utils.SessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by oleh on 08.03.2016.
 */
@Controller
@RequestMapping("/api/users")
public class UserApiController {

    @Autowired
    private UserService userService;

    @Auth(required = false, roles = {Roles.owner, Roles.admin, Roles.consultant})
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


    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public @ResponseBody Response<Map<String, Object>> signin(@RequestBody UserAuth userAuth){
        Response<Map<String, Object>> response = new Response<Map<String, Object>>();
        response.setResult(userService.signin(userAuth));
        return response;
    }

}
