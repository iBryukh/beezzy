package beezzy.services.impl;

import beezzy.auth.jwt.JwtUtil;
import beezzy.converters.BaseConverter;
import beezzy.dao.ShopDao;
import beezzy.domain.entities.GoodsEntity;
import beezzy.domain.entities.ShopEntity;
import beezzy.domain.entities.UserEntity;
import beezzy.domain.request.shop.ShopAuth;
import beezzy.exceptions.*;
import beezzy.services.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.*;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopDao shopDao;

    @Autowired
    private BaseConverter<ShopEntity> shopConverter;

    @Autowired
    private BaseConverter<GoodsEntity> goodsConverter;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public ShopEntity merge(ShopEntity shop) {
        if(shop == null)
            return null;
        return shopDao.merge(shop);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Map<String, Object> getById(int id, Set<String> fields) throws NoSuchShopException{
        ShopEntity shopEntity = shopDao.getById(id);
        if (shopEntity==null)
            throw new NoSuchShopException();
        return shopConverter.convert(shopEntity, fields);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Map<String, Object> putShop(ShopEntity shopEntity) {
        return shopConverter.convert(shopDao.merge(shopEntity), new HashSet<String>(){{add("id");}});
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean postShop(ShopEntity shopEntity) throws NoSuchShopException{
        if (shopDao.getById(shopEntity.getId()) != null) {
            shopDao.merge(shopEntity);
            return true;
        } else {
            throw new NoSuchShopException();
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean deleteShop(ShopEntity shopEntity) throws NoSuchShopException{
        if (shopDao.getById(shopEntity.getId()) != null) {
            shopDao.delete(shopEntity.getId());
            return true;
        } else {
            throw new NoSuchShopException();
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Map<String, Object>> getShopGoods(int id, Set<String> fields) throws NoSuchShopException {
        ShopEntity shopEntity =  shopDao.getById(id);
        if (shopEntity == null)
            throw new NoSuchShopException();
        return goodsConverter.convert(shopEntity.getGoods(), fields);
    }

}
