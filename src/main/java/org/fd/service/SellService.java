package org.fd.service;

import org.fd.entity.SellEntity;

import java.util.List;

public interface SellService {

    /**
     * 通过出售id查出售单
     * @param sellId 出售id
     * @return SellEntity
     */
    SellEntity getById(int sellId);

    /**
     * 根据用户Id查销售单
     * @param userId 用户Id
     */
    List<SellEntity> getByUserId(int userId);
}
