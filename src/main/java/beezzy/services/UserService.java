package beezzy.services;

import beezzy.domain.entities.UserEntity;

import java.util.List;

/**
 * Created by oleh on 12.02.2016.
 */
public interface UserService {

    UserEntity merge(UserEntity user);

    List<UserEntity> get(int offset, int limit);

    UserEntity getByEmail(String email);

}
