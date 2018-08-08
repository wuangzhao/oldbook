package daoTest;

import org.fd.dao.ShoppingCartDao;
import org.fd.entity.ShoppingCartEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml" })
public class ShoppingCartDaoTest {

    @Autowired
    ShoppingCartDao shoppingCartDao;

    @Test
    public void testInsert() {
        ShoppingCartEntity shoppingCartEntity = new ShoppingCartEntity();
        shoppingCartEntity.setSellId(100003);
        shoppingCartEntity.setUserId(100000);
        shoppingCartDao.insertShoppingCart(shoppingCartEntity);
    }

    @Test
    public void testDelete() {
        ShoppingCartEntity shoppingCartEntity = new ShoppingCartEntity();
        shoppingCartEntity.setSellId(100000);
        shoppingCartEntity.setUserId(100000);
        shoppingCartDao.deleteShoppingCart(shoppingCartEntity);
    }

    @Test
    public void testQryListById() {
        List<ShoppingCartEntity> entityList = shoppingCartDao.queryShoppingCartListByUserId(100000);
        for (ShoppingCartEntity entity : entityList) {
            System.out.println(entity.getSellId());
            System.out.println(entity.getUserId());
            System.out.println("-------------------------");
        }
    }
}
