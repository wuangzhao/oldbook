import org.fd.dao.BookDao;
import org.fd.entity.BookEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml" })
public class BookDaoTest {
    @Autowired
    private BookDao bookDao;

    @Test
    public void testQueryById() throws Exception{
        int bookId = 10000;
        BookEntity b = new BookEntity();
        b.setBookId(10);
        b.setBookISBN("fa-123-fa");
        b.setBookName("ssprong");
        bookDao.deleteById(10);
        System.out.println("--------------------------------");
        //if (a == true)
            System.out.println("success");
        System.out.println("--------------------------------");
    }
}
