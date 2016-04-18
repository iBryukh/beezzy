package beezzy.dao;

import beezzy.domain.entities.RoleEntity;

import java.util.List;

/**
 * Created by denisweeks on 19.04.16.
 */
public interface RoleDao {

    RoleEntity merge(RoleEntity category);

    List<RoleEntity> get(int offset, int limit);

    public void delete(final int id);

}
