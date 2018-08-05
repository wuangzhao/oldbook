package org.fd.model;

import org.fd.entity.BookEntity;
import org.fd.entity.SellEntity;
import org.fd.entity.UserInfoEntity;

public class BookAndSellQryModel {

    private BookEntity book;

    private SellEntity sell;

    public BookEntity getBook() {
        return book;
    }

    public void setBook(BookEntity book) {
        this.book = book;
    }

    public SellEntity getSell() {
        return sell;
    }

    public void setSell(SellEntity sell) {
        this.sell = sell;
    }
}
