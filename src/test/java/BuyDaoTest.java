import org.fd.dao.BuyDao;
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
    private BuyDao buyDao;

    @Test
    public void testInsert() throws Exception {

        UserEntity userEntity = new UserEntity();
        SellEntity sellEntity = new SellEntity();

        userEntity.setUserId(100000);
        sellEntity.setSellId(100001);

        boolean isInsert = buyDao.insert(userEntity, sellEntity);

        System.out.println(isInsert);

    }
}
