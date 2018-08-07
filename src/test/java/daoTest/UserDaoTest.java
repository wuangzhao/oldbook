package daoTest;

import org.fd.dao.UserDao;
import org.fd.entity.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml" })
public class UserDaoTest {

    @Autowired
    UserDao userDao;

    @Test
    public void testInsert() {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserPassword("1234576");
        userEntity.setUserTel("13160616619");
        userDao.insert(userEntity);
    }

    @Test
    public void testUpdate() {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserPassword("1");
        userEntity.setUserTel("13160616619");
        userDao.update(userEntity);
    }

    @Test
    public void testQryUserById() {
        System.out.println(userDao.queryUserById(100000).getUserPassword());
    }

    @Test
    public void testQryUserByTel() {
        System.out.println(userDao.queryUserByTel("13160616619").getUserPassword());
    }

}
