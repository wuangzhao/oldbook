package org.fd.dao;

import org.fd.entity.Book;

public interface BookDao {

    /**
     * 通过Id查书
     * @param bookId
     * @return Book
     */
    Book queryById(long bookId);

}
