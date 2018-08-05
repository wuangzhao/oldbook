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
     * 通过账号查用户
     * @param userName
     * @return
     */
    UserEntity queryUserByName(String userName);

    /**
     * 通过邮箱查用户
     * @param userEmail 用户邮箱
     * @return
     */
    UserEntity queryUserByEmail(String userEmail);
}
