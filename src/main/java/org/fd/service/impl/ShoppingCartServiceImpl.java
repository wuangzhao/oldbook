package org.fd.service.impl;

import org.fd.dao.ShoppingCartDao;
import org.fd.entity.SellEntity;
import org.fd.entity.ShoppingCartEntity;
import org.fd.service.BuyService;
import org.fd.service.SellService;
import org.fd.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    ShoppingCartDao shoppingCartDao;

    @Autowired
    SellService sellService;

    @Override
    public boolean addToShoppingCart(ShoppingCartEntity shoppingCartEntity) {
        SellEntity sellEntity = sellService.getBySellId(shoppingCartEntity.getSellId());
        if (sellEntity == null || sellEntity.getSellStatus() == 1 || shoppingCartDao.insertShoppingCart(shoppingCartEntity) == 0) {
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteShoppingCart(ShoppingCartEntity shoppingCartEntity) {
        if (shoppingCartDao.deleteShoppingCart(shoppingCartEntity) == 0) {
            return false;
        }
        return true;
    }

    @Override
    public List<ShoppingCartEntity> getUserShoppingCartList(Integer userId) {
        return shoppingCartDao.queryShoppingCartListByUserId(userId);
    }
}
