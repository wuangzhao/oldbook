package org.fd.service.impl;

import org.fd.dao.UserInfoDao;
import org.fd.entity.UserInfoEntity;
import org.fd.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserInfoDao userInfoDao;

    @Override
    public UserInfoEntity getUserInfoById(int userId) {
        return userInfoDao.queryUserInfoById(userId);
    }

    @Override
    public UserInfoEntity getUserInfoByNickname(String userNickname) {
        return userInfoDao.queryUserInfoByNickname(userNickname);
    }

    @Override
    public UserInfoEntity getUserInfoByTel(String userTel) {
        return userInfoDao.queryUserInfoByTel(userTel);
    }
}
