package org.fd.service.impl;

import org.fd.dao.SellDao;
import org.fd.entity.SellEntity;
import org.fd.service.SellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellServiceImpl implements SellService {

    @Autowired
    private SellDao sellDao;
    @Override
    public SellEntity getById(int sellId) {
        return sellDao.queryById(sellId);
    }

    @Override
    public List<SellEntity> getByUserId(int userId) {
        return sellDao.queryByUserId(userId);
    }
}
