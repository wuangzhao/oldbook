import org.fd.dao.SellDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml" })
public class SellDaoTest {

    @Autowired
    SellDao sellDao;

    @Test
    public void testInsert() {
        int userId = 100000;
        int bookId = 100000;
        System.out.println(sellDao.insertSell(userId, bookId));
    }
}
