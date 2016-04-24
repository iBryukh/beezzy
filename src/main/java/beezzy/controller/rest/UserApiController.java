package beezzy.controller.rest;

import beezzy.auth.aop.Auth;
import beezzy.domain.entities.RoleEntity;
import beezzy.domain.entities.UserEntity;
import beezzy.domain.enums.Roles;
import beezzy.domain.request.user.UserAuth;
import beezzy.domain.request.user.UserView;
import beezzy.domain.response.Response;
import beezzy.exceptions.*;
import beezzy.services.UserService;
import beezzy.utils.SessionUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.*;

/**
 * Created by oleh on 08.03.2016.
 */
@Api(value = "api for users")
@Controller
@RequestMapping("/api/users")
public class UserApiController {

    @Autowired
    private UserService userService;

    @ApiOperation("get users with params")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public @ResponseBody Response<List<Map<String, Object>>> getUsers(
            @ApiParam(value = "offset", defaultValue = "0", required = false)
            @RequestParam(value = "offset", required = false, defaultValue = "0") int offset,

            @ApiParam(value = "limit", defaultValue = "10", required = false)
            @RequestParam(value = "limit", required = false, defaultValue = "10") int limit,

            @ApiParam(value = "fields", defaultValue = "id, name", required = false)
            @RequestParam(value = "fields", required = false, defaultValue = "id, email") Set<String> fields
    ){
        Response<List<Map<String, Object>>> response = new Response<List<Map<String, Object>>>();
        response.setResult(userService.get(fields, offset, limit));
        return response;
    }

    @ApiOperation(value = "get user shops")
    @RequestMapping(value = "/{id}/shops", method = RequestMethod.GET)
    public @ResponseBody Response<List<Map<String, Object>>> getUsers(
            @ApiParam(value = "user id", required = true)
            @PathVariable(value = "id") int id,

            @ApiParam(value = "fields", defaultValue = "id, name", required = true)
            @RequestParam(value = "fields", required = false, defaultValue = "id, name") Set<String> fields
    ) throws NoSuchUserException {
        Response<List<Map<String, Object>>> response = new Response<List<Map<String, Object>>>();
        response.setResult(userService.getUserShops(id, fields));
        return response;
    }

    @ApiOperation(value = "get user by id")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody Response<Map<String, Object>> getUserById(
            @ApiParam(value = "user id", required = true)
            @PathVariable(value = "id") int id,

            @ApiParam(value = "fields", defaultValue = "id, email", required = false)
            @RequestParam(value = "fields", required = false, defaultValue = "id, email") Set<String> fields
    ) throws NoSuchUserException {
        Response<Map<String, Object>> response = new Response<Map<String, Object>>();
        response.setResult(userService.getById(id, fields));
        return response;
    }

    @ApiOperation(value = "create user")
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public @ResponseBody Response<Map<String, Object>> putUser(
            @ApiParam(value = "user json body")
            @RequestBody UserView userView) throws NoSuchUserException, UserAlreadyExistException {
        UserEntity userEntity = new UserEntity();
        userEntity.setActive(userView.isActive());
        userEntity.setPassword(userView.getPassword());
        userEntity.setEmail(userView.getEmail());
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setName(userView.getRole());
        // TODO userEntity.setRole(roleEntity);
        Response<Map<String, Object>> response = new Response<Map<String, Object>>();
        response.setResult(userService.putUser(userEntity));
        return response;
    }

    @ApiOperation(value = "update user")
    @Auth(required = true, roles = {Roles.owner, Roles.admin, Roles.consultant})
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public @ResponseBody Response<Boolean> postUser(
            @ApiParam(value = "user json body")
            @RequestBody UserView userView) throws NoSuchUserException, PasswordsDoNotMatchException {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userView.getId());
        userEntity.setActive(userView.isActive());
        userEntity.setPassword(userEntity.getPassword());
        userEntity.setEmail(userView.getEmail());
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setName(userView.getRole());
        // TODO userEntity.setRole(roleEntity);
        userService.postUser(userEntity, userView.getOldPassword());
        Response<Boolean> response = new Response<Boolean>();
        response.setResult(new Boolean(true));
        return response;
    }

    @ApiOperation(value = "sign in")
    @Auth(required = false, roles = {Roles.owner, Roles.admin, Roles.consultant})
    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public @ResponseBody Response<Map<String, Object>> signin(
            @ApiParam(value = "user auth body")
            @RequestBody UserAuth userAuth) throws WrongPasswordException, WrongEmailException {
        Response<Map<String, Object>> response = new Response<Map<String, Object>>();
        response.setResult(userService.signin(userAuth));
        return response;
    }

}
