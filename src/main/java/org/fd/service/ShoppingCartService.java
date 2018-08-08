package org.fd.service;

import org.fd.entity.ShoppingCartEntity;

import java.util.List;

public interface ShoppingCartService {

    boolean addToShoppingCart(ShoppingCartEntity shoppingCartEntity);

    boolean deleteShoppingCart(ShoppingCartEntity shoppingCartEntity);

    List<ShoppingCartEntity> getUserShoppingCartList(Integer userId);
}
