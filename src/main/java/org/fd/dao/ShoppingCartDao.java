package org.fd.dao;

import org.fd.entity.ShoppingCartEntity;

import java.util.List;

public interface ShoppingCartDao {

    int insertShoppingCart(ShoppingCartEntity shoppingCartEntity);

    int deleteShoppingCart(ShoppingCartEntity shoppingCartEntity);

    List<ShoppingCartEntity> queryShoppingCartListByUserId(Integer userId);


}