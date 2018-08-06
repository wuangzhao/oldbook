package org.fd.entity;

import java.util.Date;

public class BuyEntity {

    private Integer buyId;

    private Integer userId;

    private Integer sellId;

    private Date buyCreateTime;

    public Integer getBuyId() {
        return buyId;
    }

    public void setBuyId(Integer buyId) {
        this.buyId = buyId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSellId() {
        return sellId;
    }

    public void setSellId(Integer sellId) {
        this.sellId = sellId;
    }


    public Date getBuyCreateTime() {
        return buyCreateTime;
    }

    public void setBuyCreateTime(Date buyCreateTime) {
        this.buyCreateTime = buyCreateTime;
    }

    @Override
    public String toString() {
        return "BuyEntity{" +
                "buyId=" + buyId +
                ", userId=" + userId +
                ", sellId=" + sellId +
                ", buyCreateTime=" + buyCreateTime +
                '}';
    }
}
