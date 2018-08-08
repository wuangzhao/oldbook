package org.fd.service.impl;

import org.fd.dao.BookDao;
import org.fd.entity.BookEntity;
import org.fd.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public BookEntity getById(int bookId) {
        return bookDao.queryById(bookId);
    }

    @Override
    public List<BookEntity> getByName(String bookName) {
        return bookDao.queryByName(bookName);
    }

    @Override
    public BookEntity getByISBN(String bookISBN) {
        return bookDao.queryByISBN(bookISBN);
    }

    @Override
    public BookEntity addBook(BookEntity bookEntity) {
        if (bookDao.insert(bookEntity) == 0) {
            return bookDao.queryById(bookEntity.getBookId());
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteBook(Integer bookId) {
        return bookDao.deleteById(bookId) == 0;
    }

    @Override
    public BookEntity editBook(BookEntity bookEntity) {
        BookEntity book = bookDao.queryById(bookDao.updateBook(bookEntity));
        return book;
    }
}
