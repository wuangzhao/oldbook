package org.fd.dao;

import org.fd.entity.UserEntity;

public interface UserDao {


    /**
     * 插入新数据
     * @param userEntity
     * @return
     */
    int insert(UserEntity userEntity);

    /**
     * 更新数据
     * @param userEntity
     * @return
     */
    int update(UserEntity userEntity);

    /**
     * 通过Id查用户
     * @param userId
     * @return UserEntity
     */
    UserEntity queryUserById(int userId);

    /**
     * 通过手机查用户
     * @param userTel
     * @return
     */
    UserEntity queryUserByTel(String userTel);

}
