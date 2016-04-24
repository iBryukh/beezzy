package beezzy.dao;

import beezzy.domain.entities.PermissionEntity;

import java.util.List;

/**
 * Created by denisweeks on 19.04.16.
 */
public interface PermissionDao {

    PermissionEntity merge(PermissionEntity permission);

    List<PermissionEntity> get(int offset, int limit);

    PermissionEntity getById(int id);

    public void delete(final int id);

}
