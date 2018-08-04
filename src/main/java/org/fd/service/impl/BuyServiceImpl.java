package org.fd.service.impl;

import org.fd.dao.BuyDao;
import org.fd.entity.BuyEntity;
import org.fd.entity.UserEntity;
import org.fd.service.BuyService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BuyServiceImpl implements BuyService {

    @Autowired
    private BuyDao buyDao;

    @Override
    public List<BuyEntity> getByUser(UserEntity userEntity) {
        return buyDao.queryByUser(userEntity);
    }
}
