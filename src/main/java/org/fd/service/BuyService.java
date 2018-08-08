package org.fd.service;

import org.fd.dto.BuyExecution;
import org.fd.entity.BuyEntity;
import org.fd.entity.UserEntity;

import java.util.List;

public interface BuyService {

    /**
     * 查询用户的购买记录
     * @param userId
     * @return 购买列表
     */
    List<BuyEntity> getByUserId(int userId);

    /**
     * 添加购买记录
     * @param userId
     * @param sellId
     * @return
     */
    BuyExecution addBuy(int userId, int sellId);

    /**
     * 用户删除购买列表
     * @param buyEntity
     * @return
     */
    boolean userDelete(BuyEntity buyEntity);

    /**
     * 查询某一编号购买记录
     * @param buyId
     * @return
     */
    BuyEntity getByBuyId(int buyId);
}
