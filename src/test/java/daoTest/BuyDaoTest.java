package daoTest;

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
        BuyEntity buyEntity = new BuyEntity();
        buyEntity.setUserId(100002);
        buyEntity.setSellId(100009);
        buyDao.insert(buyEntity);
    }


    @Test
    public void testUserDelete() {
        BuyEntity buyEntity = new BuyEntity();
        buyEntity.setBuyId(100010);
        buyDao.userDelete(buyEntity);
    }

    @Test
    public void testQueryByUser() throws Exception {
        List<BuyEntity> list = buyDao.queryByUserId(100000);
        for (BuyEntity buyEntity : list) {
            System.out.println(buyEntity.getBuyCreateTime());
        }
    }

    @Test
    public void testQryByBuyId() throws Exception{
        System.out.println(buyDao.queryByBuyId(100010).getBuyCreateTime());
    }
}
