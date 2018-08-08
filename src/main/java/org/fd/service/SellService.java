package org.fd.service;

import org.fd.dto.SellExecution;
import org.fd.entity.SellEntity;

import java.util.List;

public interface SellService {

    /**
     * 通过出售id查出售单
     * @param sellId 出售id
     * @return SellEntity
     */
    SellEntity getBySellId(int sellId);

    /**
     * 根据用户Id查销售单
     * @param userId 用户Id
     */
    List<SellEntity> getByUserId(int userId);

    /**
     *  插入新出售记录
     * @param sellEntity
     * @return
     */
    SellExecution addSell(SellEntity sellEntity);
}
