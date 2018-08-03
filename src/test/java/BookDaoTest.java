import org.fd.dao.BookDao;
import org.fd.entity.BookEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml" })
public class BookDaoTest {

    @Autowired
    private BookDao bookDao;

    @Test
    public void testQueryById() throws Exception {
        int bookId = 10000;
        BookEntity book = bookDao.queryById(bookId);
        System.out.println("--------------------------------");
        if (book != null)
            System.out.println(book.getBookName());
        System.out.println("--------------------------------");
    }

    @Test
    public void testInsert() throws Exception {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setBookISBN("123456");
        bookEntity.setBookName("Java");
        Boolean isInsert = bookDao.insert(bookEntity);
        System.out.println(isInsert);
    }

    @Test
    public void testDeleteById() throws Exception {
        int bookId = 100001;
        System.out.println(bookDao.DeleteById(bookId));
    }

    @Test
    public void testQuery() throws Exception {
        List<BookEntity> bookEntityList = bookDao.queryAll();
        for (BookEntity bookEntity : bookEntityList) {
            System.out.println(bookEntity.getBookName());
        }
    }
}
