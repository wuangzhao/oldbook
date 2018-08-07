package org.fd.dao;

import org.fd.entity.UserInfoEntity;

public interface UserInfoDao {

    /**
     * 修改用户信息
     * @param userInfoEntity
     * @return
     */
    int update(UserInfoEntity userInfoEntity);

    /**
     * 通过Id查用户信息
     * @param userId
     * @return UserEntity
     */
    UserInfoEntity queryUserInfoById(int userId);

    /**
     * 通过昵称查用户
     * @param userNickname
     * @return
     */
    UserInfoEntity queryUserInfoByNickname(String userNickname);
}
