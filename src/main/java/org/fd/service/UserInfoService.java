package org.fd.service;

import org.fd.entity.UserInfoEntity;

public interface UserInfoService {

    /**
     * 通过Id查用户
     * @param userId
     * @return UserEntity
     */
    UserInfoEntity getUserInfoById(int userId);

    /**
     * 通过名字查用户
     * @param userNickname
     * @return
     */
    UserInfoEntity getUserInfoByNickname(String userNickname);

    /**
     * 通过手机号码查用户
     * @param userTel 用户手机号
     * @return
     */
    UserInfoEntity getUserInfoByTel(String userTel);
}
