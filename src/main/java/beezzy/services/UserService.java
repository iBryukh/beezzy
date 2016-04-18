package beezzy.services;

import beezzy.domain.entities.UserEntity;
import beezzy.domain.request.user.UserAuth;
import beezzy.exceptions.ForbiddenException;
import beezzy.exceptions.WrongEmailException;
import beezzy.exceptions.WrongPasswordException;

import java.util.*;

/**
 * Created by oleh on 12.02.2016.
 */
public interface UserService {

    UserEntity merge(UserEntity user);

    List<Map<String, Object>> get(Set<String> fields, int offset, int limit);

    UserEntity getByEmail(String email);

    UserEntity getAuthorised();

    Map<String, Object> signin(UserAuth userAuth) throws WrongPasswordException, WrongEmailException;
}
