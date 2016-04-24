package beezzy.services.impl;

import beezzy.converters.BaseConverter;
import beezzy.dao.CategoryDao;
import beezzy.dao.GoodsDao;
import beezzy.domain.entities.GoodsEntity;
import beezzy.domain.request.goods.GoodView;
import beezzy.exceptions.NoSuchGoodsException;
import beezzy.services.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class GoodServiceImpl implements GoodService {

    @Autowired
    private GoodsDao goodsDao;

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private BaseConverter<GoodsEntity> goodsConverter;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public GoodsEntity merge(GoodsEntity goods) {
        if(goods == null)
            return null;
        return goodsDao.merge(goods);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Map<String, Object> getById(int id, Set<String> fields) throws NoSuchGoodsException{
        GoodsEntity goodsEntity = goodsDao.getById(id);
        if (goodsEntity==null)
            throw new NoSuchGoodsException();
        return goodsConverter.convert(goodsEntity, fields);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Map<String, Object> putGood(GoodView goodView) {
        GoodsEntity goodsEntity = new GoodsEntity();
        goodsEntity.setName(goodView.getName());
        goodsEntity.setDescription(goodView.getDescription());
        goodsEntity.setCategory(categoryDao.getById(goodView.getCategory()));
        return goodsConverter.convert(goodsDao.merge(goodsEntity), new HashSet<String>(){{add("id");}});
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean postGood(GoodView goodView) throws NoSuchGoodsException{
        if (goodsDao.getById(goodView.getId()) != null) {
            GoodsEntity goodsEntity = new GoodsEntity();
            goodsEntity.setId(goodView.getId());
            goodsEntity.setName(goodView.getName());
            goodsEntity.setDescription(goodView.getDescription());
            goodsEntity.setCategory(categoryDao.getById(goodView.getCategory()));
            goodsDao.merge(goodsEntity);
            return true;
        } else {
            throw new NoSuchGoodsException();
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean deleteGood(int id) throws NoSuchGoodsException{
        if (goodsDao.getById(id) != null) {
            goodsDao.delete(id);
            return true;
        } else {
            throw new NoSuchGoodsException();
        }
    }

}
