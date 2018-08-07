package daoTest;

import org.fd.dao.UserInfoDao;
import org.fd.entity.UserInfoEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml" })
public class UserInfoDaoTest {

    @Autowired
    UserInfoDao userInfoDao;

    @Test
    public void testUpdate() {
        Date ndate = new Date();
        UserInfoEntity userInfoEntity = new UserInfoEntity();
        userInfoEntity.setUserId(100003);
        userInfoEntity.setUserNickname("test");
        userInfoEntity.setUserBirthday(ndate);
        userInfoDao.update(userInfoEntity);
    }

    @Test
    public void testQryUserInfoById() {
        UserInfoEntity userInfoEntity = userInfoDao.queryUserInfoById(100003);
        System.out.println(userInfoEntity.getUserNickname());
    }

    @Test
    public void testQryUserInfoByNickname() {
        UserInfoEntity userInfoEntity = userInfoDao.queryUserInfoByNickname("test");
        System.out.println(userInfoEntity.getUserId());
    }
}
