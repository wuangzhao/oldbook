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
    public void testQueryByISBN() throws Exception {
        String bookISBN = "123456";
        System.out.println(bookDao.queryByISBN(bookISBN).getBookName());
    }

    @Test
    public void testQueryByName() throws Exception {
        String bookName = "Ja";
        List<BookEntity> bookDaoList = bookDao.queryByName(bookName);
        for (BookEntity bookEntity : bookDaoList) {
            System.out.println(bookEntity.getBookName());
            System.out.println(bookEntity.getBookISBN());
            System.out.println("--------------------------------");
        }
    }

    @Test
    public void testQueryAll() throws Exception {
        List<BookEntity> bookEntityList = bookDao.queryAll();
        for (BookEntity bookEntity : bookEntityList) {
            System.out.println(bookEntity.getBookName());
        }
    }


    @Test
    public void testInsert() {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setBookISBN("123455");
        bookEntity.setBookName("Linxu");
        Boolean isInsert = false;
        try {
            isInsert = bookDao.insert(bookEntity);
        } catch (Exception e) {
        }
        System.out.println(isInsert);

    }
}
