package org.fd.dao;

import org.fd.entity.SellEntity;

import java.util.List;

public interface SellDao {

    /**
     * 插入新出售记录
     * @param sellEntity
     * @return
     */
    int insertSell(SellEntity sellEntity);

    /**
     * 用户删除记录
     * @param sellEntity
     * @return
     */
    int userDelete(SellEntity sellEntity);

    /**
     * 通过出售id查出售单
     * @param sellId 出售id
     * @return SellEntity
     */
    SellEntity queryById(int sellId);

    /**
     * 根据用户Id查销售单
     * @param userId 用户Id
     */
    List<SellEntity> queryByUserId(int userId);


}
