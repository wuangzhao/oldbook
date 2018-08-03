package org.fd.service.impl;

import org.fd.dao.BookDao;
import org.fd.entity.BookEntity;
import org.fd.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public BookEntity getById(int bookId) {
        return bookDao.queryById(bookId);
    }

    @Override
    public List<BookEntity> getAll() {
        return bookDao.queryAll();
    }

    /**
     * TODO
     */
    @Override
    public BookEntity getByName(String bookName) {
        return null;
    }

    /**
     * TODO
     */
    @Override
    public BookEntity getByISBN(String bookISBN) {
        return null;
    }
}
