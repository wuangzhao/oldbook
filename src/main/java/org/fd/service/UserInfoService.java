package org.fd.service;

import org.fd.dao.UserInfoDao;
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
     * 修改用户信息
     * @param userInfoEntity
     * @return
     */
    UserInfoEntity editUserInfo(UserInfoEntity userInfoEntity);
}
