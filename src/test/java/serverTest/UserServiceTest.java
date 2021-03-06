package serverTest;

import org.fd.entity.UserEntity;
import org.fd.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml" })
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    public void testCheckLogin() {
        UserEntity user = userService.checkLogin("root", "root");
        if (user == null) {
            System.out.println("null");
        } else {
            System.out.println("success");
        }
    }
}
