package org.fd.dao;

import org.fd.entity.SellEntity;

import java.util.List;

public interface SellDao {

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
