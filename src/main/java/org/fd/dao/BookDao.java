package org.fd.dao;

import org.fd.entity.BookEntity;

import java.util.List;


public interface BookDao {

    /**
     * 新增书籍
     * @param bookEntity
     * @return true 成功
     * @return false 失败
     */
    int insert(BookEntity bookEntity);

    /**
     * 按照书本序号删除
     * @param BookId 书本id
     * @return true 成功
     * @return false 失败
     */
    int deleteById(int BookId);

    /**
     * 修改
     * @param bookEntity
     * @return
     */
    int updateBook(BookEntity bookEntity);

    /**
     * 通过Id查书
     * @param bookId  书本id
     * @return BookEntity
     */
    BookEntity queryById(int bookId);

    /**
     * 根据isbn
     * @param bookISBN
     * @return
     */
    BookEntity queryByISBN(String bookISBN);

    /**
     * 通过书名查书
     * @param bookName
     * @return
     */
    List<BookEntity> queryByName(String bookName);
}
