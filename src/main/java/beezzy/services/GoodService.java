package beezzy.services;

import beezzy.domain.entities.GoodsEntity;
import beezzy.domain.request.goods.GoodView;
import beezzy.exceptions.NoSuchGoodsException;
import beezzy.exceptions.NoSuchShopException;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface GoodService {

    GoodsEntity merge(GoodsEntity goods);

    Map<String, Object> getById(int id, Set<String> fields) throws NoSuchGoodsException;

    Map<String, Object> putGood(GoodView goodsView);

    boolean postGood(GoodView goodView) throws NoSuchGoodsException;

    boolean deleteGood(int id) throws NoSuchGoodsException;

}
