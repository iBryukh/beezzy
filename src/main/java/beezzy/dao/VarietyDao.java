package beezzy.dao;

import beezzy.domain.entities.VarietyEntity;

import java.util.List;

/**
 * Created by denisweeks on 19.04.16.
 */
public interface VarietyDao {

    VarietyEntity merge(VarietyEntity variety);

    List<VarietyEntity> get(int offset, int limit);

    VarietyEntity getById(int id);

    public void delete(final int id);

}
