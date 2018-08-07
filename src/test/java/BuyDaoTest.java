import org.fd.dao.BuyDao;
import org.fd.entity.BuyEntity;
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
    private BuyDao buyDao;

    @Test
    public void testInsert() throws Exception {
    }

    @Test
    public void testQueryByUser() throws Exception {
        List<BuyEntity> list = buyDao.queryByUserId(100000);
        for (BuyEntity buyEntity : list) {
            System.out.println(buyEntity.toString());
        }
    }
}
