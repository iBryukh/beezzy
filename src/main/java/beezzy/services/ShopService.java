package beezzy.services;

import beezzy.domain.entities.ShopEntity;
import beezzy.domain.request.shop.ShopAuth;
import beezzy.exceptions.*;

import java.io.IOException;
import java.util.*;

public interface ShopService {

    ShopEntity merge(ShopEntity shops);

    Map<String, Object> getById(int id, Set<String> fields) throws NoSuchShopException;

    Map<String, Object> putShop(ShopEntity shopEntity);

    boolean postShop(ShopEntity shopEntity) throws NoSuchShopException;

    boolean deleteShop(int id) throws NoSuchShopException;

    List<Map<String, Object>> getShopGoods(int id, Set<String> fields) throws NoSuchShopException;


}
