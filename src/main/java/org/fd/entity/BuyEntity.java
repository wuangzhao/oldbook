package org.fd.entity;

import javax.xml.crypto.Data;

public class BuyEntity {

    private Integer buyId;

    private Integer userId;

    private Integer sellId;

    private Data BuyCreateTime;

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

    public Data getBuyCreateTime() {
        return BuyCreateTime;
    }

    public void setBuyCreateTime(Data buyCreateTime) {
        BuyCreateTime = buyCreateTime;
    }
}
