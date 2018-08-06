package org.fd.dao;

import org.fd.entity.BuyEntity;

import java.util.List;

/**
 * Created by USER on 2018/8/3.
 */
public interface BuyDao {

    /**
     * 插入一条新购买信息
     * @param
     * @return buy_id
     */
    int insert(BuyEntity buyEntity);

    /**
     * 查询用户的购买记录
     * @param userId
     * @return 购买列表
     */
    List<BuyEntity> queryByUserId(int userId);

    /**
     *
     * @param buyId
     * @return
     */
    BuyEntity queryByBuyId(int buyId);
}
