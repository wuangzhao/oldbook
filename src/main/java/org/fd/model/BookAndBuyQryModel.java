package org.fd.model;

import org.fd.entity.BookEntity;
import org.fd.entity.BuyEntity;

public class BookAndBuyQryModel {

    private BookEntity book;

    private BuyEntity buy;

    public BookEntity getBook() {
        return book;
    }

    public void setBook(BookEntity book) {
        this.book = book;
    }

    public BuyEntity getBuy() {
        return buy;
    }

    public void setBuy(BuyEntity buy) {
        this.buy = buy;
    }
}
