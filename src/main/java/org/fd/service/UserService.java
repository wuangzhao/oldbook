package org.fd.service;

import org.fd.entity.UserEntity;

public interface UserService {

    /**
     * 通过Id查用户
     * @param userId
     * @return UserEntity
     */
    UserEntity getUserById(int userId);

    /**
     * 通过账号查用户
     * @param userTel
     * @return
     */
    UserEntity getUserByTel(String userTel);

    /**
     * 通过邮箱查用户
     * @param userEmail 用户邮箱
     * @return
     */
    UserEntity getUserByEmail(String userEmail);

    /**
     * 登陆校验
     * @param userName
     * @param userPassword
     * @return
     */
    UserEntity checkLogin(String userName, String userPassword);
}
