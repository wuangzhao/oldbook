package org.fd.entity;

import java.util.Date;

public class SellEntity {

    private Integer sellId;

    private Integer userId;

    private Integer bookId;

    private Date sellCreateTime;

    private Integer sellStatus;

    public Integer getSellId() {
        return sellId;
    }

    public void setSellId(Integer sellId) {
        this.sellId = sellId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Date getSellCreateTime() {
        return sellCreateTime;
    }

    public void setSellCreateTime(Date sellCreateTime) {
        this.sellCreateTime = sellCreateTime;
    }

    public Integer getSellStatus() {
        return sellStatus;
    }

    public void setSellStatus(Integer sellStatus) {
        this.sellStatus = sellStatus;
    }
}
