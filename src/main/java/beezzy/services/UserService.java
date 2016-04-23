package beezzy.services;

import beezzy.domain.entities.UserEntity;
import beezzy.domain.request.user.UserAuth;
import beezzy.exceptions.*;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by oleh on 12.02.2016.
 */
public interface UserService {

    UserEntity merge(UserEntity user);

    List<Map<String, Object>> get(Set<String> fields, int offset, int limit);

    List<Map<String, Object>> getUserShops(int id, Set<String> fields) throws NoSuchUserException;

    UserEntity getByEmail(String email);

    Map<String, Object> getById(int id, Set<String> fields) throws NoSuchUserException;

    Map<String, Object> putUser(UserEntity userEntity) throws UserAlreadyExistException;

    boolean postUser(UserEntity userEntity, String oldPass) throws NoSuchUserException, PasswordsDoNotMatchException;

    Map<String, Object> signin(UserAuth userAuth) throws WrongPasswordException, WrongEmailException;
}
