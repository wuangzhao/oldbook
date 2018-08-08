package org.fd.service;

import org.fd.entity.BookEntity;

import java.util.List;

public interface BookService {

    /**
     * 通过Id查书
     * @param bookId 书本id
     * @return BookEntity
     */
    BookEntity getById(int bookId);

    /**
     * 通过名字查书
     * @param bookName 书本名称
     * @return BookEntity
     */
    List<BookEntity> getByName(String bookName);

    /**
     * 通过ISBN查书
     * @param bookISBN 书本ISBN
     * @return BookEntity
     */
    BookEntity getByISBN(String bookISBN);

    /**
     * 插入
     * @param bookEntity
     * @return
     */
    BookEntity addBook(BookEntity bookEntity);

    /**
     * 删除
     * @param bookId
     * @return
     */
    boolean deleteBook(Integer bookId);

    /**
     * 修改
     * @param bookEntity
     * @return
     */
    BookEntity editBook(BookEntity bookEntity);

}
