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
        BookEntity book = bookDao.queryById(bookId);
        System.out.println("--------------------------------");
        if (book != null)
            System.out.println(book.getBookName());
        System.out.println("--------------------------------");
    }
}
