package beezzy.controller.rest;

import beezzy.auth.aop.Auth;
import beezzy.domain.entities.RoleEntity;
import beezzy.domain.entities.UserEntity;
import beezzy.domain.enums.Roles;
import beezzy.domain.request.user.UserAuth;
import beezzy.domain.response.Response;
import beezzy.exceptions.*;
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

    @RequestMapping(value = "/{id}/shops", method = RequestMethod.GET)
    public @ResponseBody Response<List<Map<String, Object>>> getUsers(
            @PathVariable(value = "id") int id,
            @RequestParam(value = "fields", required = false, defaultValue = "id") Set<String> fields
    ) throws NoSuchUserException {
        Response<List<Map<String, Object>>> response = new Response<List<Map<String, Object>>>();
        response.setResult(userService.getUserShops(id, fields));
        return response;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody Response<Map<String, Object>> getUserById(
            @PathVariable(value = "id") int id,
            @RequestParam(value = "fields", required = false, defaultValue = "id, email") Set<String> fields
    ) throws NoSuchUserException {
        Response<Map<String, Object>> response = new Response<Map<String, Object>>();
        response.setResult(userService.getById(id, fields));
        return response;
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public @ResponseBody Response<Map<String, Object>> putUser(
            @RequestParam(value = "email") String email,
            @RequestParam(value = "password") String password,
            @RequestParam(value = "role") Roles role,
            @RequestParam(value = "active") boolean active
    ) throws NoSuchUserException, UserAlreadyExistException {
        UserEntity userEntity = new UserEntity();
        userEntity.setActive(active);
        userEntity.setPassword(password);
        userEntity.setEmail(email);
        // TODO
        // userEntity.setRole();
        Response<Map<String, Object>> response = new Response<Map<String, Object>>();
        response.setResult(userService.putUser(userEntity));
        return response;
    }

    @Auth(required = true, roles = {Roles.owner, Roles.admin, Roles.consultant})
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public @ResponseBody Response<Boolean> postUser(
            @RequestParam(value = "id") int id,
            @RequestParam(value = "email") String email,
            @RequestParam(value = "password") String password,
            @RequestParam(value = "old_password") String oldPassword,
            @RequestParam(value = "role") Roles role,
            @RequestParam(value = "active") boolean active
    ) throws NoSuchUserException, PasswordsDoNotMatchException {
        UserEntity userEntity = new UserEntity();
        userEntity.getId();
        userEntity.setActive(active);
        userEntity.setPassword(password);
        userEntity.setEmail(email);
        // TODO
        // userEntity.setRole();
        userService.postUser(userEntity, oldPassword);
        Response<Boolean> response = new Response<Boolean>();
        response.setResult(new Boolean(true));
        return response;
    }

    @Auth(required = false, roles = {Roles.owner, Roles.admin, Roles.consultant})

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public @ResponseBody Response<Map<String, Object>> signin(@RequestBody UserAuth userAuth) throws WrongPasswordException, WrongEmailException {
        Response<Map<String, Object>> response = new Response<Map<String, Object>>();
        response.setResult(userService.signin(userAuth));
        return response;
    }

}
