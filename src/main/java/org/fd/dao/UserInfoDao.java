package org.fd.dao;

import org.fd.entity.UserInfoEntity;

public interface UserInfoDao {

    /**
     * 通过Id查用户
     * @param userId
     * @return UserEntity
     */
    UserInfoEntity queryUserInfoById(int userId);

    /**
     * 通过名字查用户
     * @param userNickname
     * @return
     */
    UserInfoEntity queryUserInfoByNickname(String userNickname);

    /**
     * 通过手机号码查用户
     * @param userTel 用户手机号
     * @return
     */
    UserInfoEntity queryUserInfoByTel(String userTel);
}
