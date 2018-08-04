package org.fd.dao;

import org.apache.ibatis.annotations.Param;
import org.fd.entity.BookEntity;
import org.fd.entity.BuyEntity;
import org.fd.entity.SellEntity;
import org.fd.entity.UserEntity;

import java.util.Date;
import java.util.List;

/**
 * Created by USER on 2018/8/3.
 */
public interface BuyDao {

    /**
     * 插入一条新购买信息
     * @param
     * @return true 插入成功
     * @return false 插入失败
     */
    boolean insert(BuyEntity buyEntity);

    /**
     * 查询用户的购买记录
     * @param userEntity
     * @return 购买列表
     */
    List<BuyEntity> queryByUser(UserEntity userEntity);
}
