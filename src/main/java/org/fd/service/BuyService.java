package org.fd.service;

import org.fd.entity.BuyEntity;
import org.fd.entity.UserEntity;

import java.util.List;

public interface BuyService {

    /**
     * 查询用户的购买记录
     * @param userEntity
     * @return 购买列表
     */
    List<BuyEntity> getByUser(UserEntity userEntity);
}
