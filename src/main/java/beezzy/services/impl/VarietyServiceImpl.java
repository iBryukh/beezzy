package beezzy.services.impl;

import beezzy.converters.BaseConverter;
import beezzy.dao.*;
import beezzy.domain.entities.VarietyEntity;
import beezzy.domain.request.goods.GoodView;
import beezzy.domain.request.variety.VarietyView;
import beezzy.exceptions.NoSuchVarietiesException;
import beezzy.services.VarietyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class VarietyServiceImpl implements VarietyService {

    @Autowired
    private VarietyDao varietyDao;

    @Autowired
    private GoodsDao goodsDao;


    @Autowired
    private BaseConverter<VarietyEntity> varietyConverter;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public VarietyEntity merge(VarietyEntity variety) {
        if(variety == null)
            return null;
        return varietyDao.merge(variety);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Map<String, Object> getById(int id, Set<String> fields) throws NoSuchVarietiesException{
        VarietyEntity varietyEntity = varietyDao.getById(id);
        if (varietyEntity==null)
            throw new NoSuchVarietiesException();
        return varietyConverter.convert(varietyEntity, fields);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Map<String, Object> putVariety(VarietyView varietyView) {
        VarietyEntity varietyEntity = new VarietyEntity();
        varietyEntity.setGoods(goodsDao.getById(varietyView.getGoodsId()));
        varietyEntity.setDescription(varietyView.getDescription());
        varietyEntity.setAmount(varietyView.getAmount());
        varietyEntity.setPurchasePrice(varietyView.getP_price());
        varietyEntity.setSellingPrice(varietyView.getS_price());
        varietyEntity.setCode(varietyView.getCode());
        return varietyConverter.convert(varietyDao.merge(varietyEntity), new HashSet<String>(){{add("id");}});
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean postVariety(VarietyView varietyView) throws NoSuchVarietiesException{
        if (varietyDao.getById(varietyView.getId()) != null) {
            VarietyEntity varietyEntity = new VarietyEntity();
            varietyEntity.setId(varietyView.getId());
            varietyEntity.setGoods(goodsDao.getById(varietyView.getGoodsId()));
            varietyEntity.setDescription(varietyView.getDescription());
            varietyEntity.setAmount(varietyView.getAmount());
            varietyEntity.setPurchasePrice(varietyView.getP_price());
            varietyEntity.setSellingPrice(varietyView.getS_price());
            varietyEntity.setCode(varietyView.getCode());
            varietyDao.merge(varietyEntity);
            return true;
        } else {
            throw new NoSuchVarietiesException();
        }
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean deleteVariety(int id) throws NoSuchVarietiesException{
        if (varietyDao.getById(id) != null) {
            varietyDao.delete(id);
            return true;
        } else {
            throw new NoSuchVarietiesException();
        }
    }

}
