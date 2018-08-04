package org.fd.service.impl;

import org.fd.dao.UserDao;
import org.fd.entity.UserEntity;
import org.fd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserEntity getUserById(int userId) {
        return userDao.queryUserById(userId);
    }

    @Override
    public UserEntity getUserByName(String userName) {
        return userDao.queryUserByName(userName);
    }

    @Override
    public UserEntity getUserByTel(String userTel) {
        return userDao.queryUserByTel(userTel);
    }
}
