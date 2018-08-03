package org.fd.dao;

import org.fd.entity.BookEntity;

import java.util.List;


public interface BookDao {

    /**
     * 通过Id查书
     * @param bookId  书本id
     * @return BookEntity
     */
    BookEntity queryById(int bookId);

    /**
     * 查询所有书籍
     * @return BookEntity
     */
    List<BookEntity> queryAll();

    /**
     * 按照书本序号删除
     * @param BookId 书本id
     */
    void DeleteById(int BookId);

    /**
     * 新增书籍
     * @param bookEntity
     */
    void insert(BookEntity bookEntity);

    /**
     * 根据isbn
     * @param bookISBN
     * @return
     */
    BookEntity queryByISBN(String bookISBN);

    List<BookEntity> queryByName(String bookName);

}
