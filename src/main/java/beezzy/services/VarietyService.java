package beezzy.services;

import beezzy.domain.entities.VarietyEntity;
import beezzy.domain.request.variety.VarietyView;
import beezzy.exceptions.NoSuchVarietiesException;

import java.util.Map;
import java.util.Set;

public interface VarietyService {

    VarietyEntity merge(VarietyEntity variety);

    Map<String, Object> getById(int id, Set<String> fields) throws NoSuchVarietiesException;

    Map<String, Object> putVariety(VarietyView varietyView);

    boolean postVariety(VarietyView varietyView) throws NoSuchVarietiesException;

    boolean deleteVariety(int id) throws NoSuchVarietiesException;
}
