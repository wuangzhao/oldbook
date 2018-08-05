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
    public void testQueryByUserName() {
        UserEntity user = userDao.queryUserByName("root");
        System.out.println(user.getUserName());
    }
}