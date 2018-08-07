package daoTest;

import org.fd.dao.SellDao;
import org.fd.entity.SellEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml" })
public class SellDaoTest {

    @Autowired
    SellDao sellDao;

    @Test
    public void testInsert() {
        SellEntity sellEntity = new SellEntity();
        sellEntity.setUserId(100000);
        sellEntity.setBookId(100018);
        sellDao.insertSell(sellEntity);
    }

    @Test
    public void testUserDelete() {
        SellEntity sellEntity = new SellEntity();
        sellEntity.setSellId(100000);
        sellDao.userDelete(sellEntity);
    }

    @Test
    public void testQryById() {
        SellEntity sellEntity = sellDao.queryById(100000);
        System.out.println(sellEntity.getSellCreateTime());
    }

    @Test
    public void testQryByUserId() {
        List<SellEntity> sellEntityList = sellDao.queryByUserId(100000);
        for (SellEntity sellEntity : sellEntityList) {
            System.out.println(sellEntity.getSellCreateTime());
        }
    }
}
