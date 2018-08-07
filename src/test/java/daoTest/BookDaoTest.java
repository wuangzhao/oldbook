package daoTest;

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
    public void testInsert() {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setBookId(123);
        bookEntity.setBookName("C++");
        bookEntity.setBookISBN("53asd2423");
    }

    @Test
    public void testDelete() {
        bookDao.deleteById(100015);
    }

    @Test
    public void testUpdate() {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setBookName("Java update");
        bookEntity.setBookISBN("123412");
        bookEntity.setBookId(100002);
    }

    @Test
    public void testQryById() {
        System.out.println(bookDao.queryById(100000).getBookName());
    }

    @Test
    public void testQryByBookName() {
        List<BookEntity> bookEntities = bookDao.queryByName("");
        for (BookEntity bookEntity : bookEntities) {
            System.out.println(bookEntity.getBookName());
        }
    }

    @Test
    public void testQryBookISBN() {
        System.out.println(bookDao.queryByISBN("123455").getBookName());
    }



}
