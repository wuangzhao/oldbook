import org.fd.dao.BuyDao;
import org.fd.dao.UserDao;
import org.fd.entity.BuyEntity;
import org.fd.entity.SellEntity;
import org.fd.entity.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml" })
public class BuyDaoTest {

    @Autowired
    private UserDao userDao;

    @Autowired
    private BuyDao buyDao;

    @Test
    public void testInsert() throws Exception {
        UserEntity s = userDao.queryUserById(1);
        System.out.println("--------------------------");
        System.out.println(s.getUserName());
        System.out.println("---------------------");
    }

    @Test
    public void testQueryByUser() throws Exception {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(100000);
        List<BuyEntity> list = buyDao.queryByUser(userEntity);
        for (BuyEntity buyEntity : list) {
            System.out.println(buyEntity.getSellId());
        }
    }
}
