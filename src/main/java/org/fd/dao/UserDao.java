package org.fd.dao;

import org.fd.entity.UserEntity;

public interface UserDao {

    /**
     * 通过Id查用户
     * @param userId
     * @return UserEntity
     */
    UserEntity queryUserById(int userId);

    /**
     * 通过名字查用户
     * @param userName
     * @return
     */
    UserEntity queryUserByName(String userName);

    /**
     * 通过手机号码查用户
     * @param userTel 用户手机号
     * @return
     */
    UserEntity queryUserByTel(String userTel);
}
