import org.fd.dao.BuyDao;
import org.fd.dao.UserDao;
import org.fd.entity.SellEntity;
import org.fd.entity.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml" })
public class BuyDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void testInsert() throws Exception {
        UserEntity s = userDao.queryUserById(1);
        System.out.println("--------------------------");
        System.out.println(s.getUserName());
        System.out.println("---------------------");

    }
}
