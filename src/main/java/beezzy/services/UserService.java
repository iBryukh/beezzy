package beezzy.services;

import beezzy.domain.entities.UserEntity;

import java.util.*;

/**
 * Created by oleh on 12.02.2016.
 */
public interface UserService {

    UserEntity merge(UserEntity user);

    List<Map<String, Object>> get(Set<String> fields, int offset, int limit);

    UserEntity getByEmail(String email);

    UserEntity getAuthorised();
}
