package beezyy.dao;

import beezyy.domain.entities.UserEntity;

import java.util.List;

/**
 * Created by oleh on 12.02.2016.
 */
public interface UserDao {

    UserEntity merge(UserEntity user);

    List<UserEntity> get(int offset, int limit);

}
