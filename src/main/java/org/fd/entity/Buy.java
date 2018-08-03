package org.fd.entity;

public class Buy {

    private int BuyId;

    private User user;

    private Sell sell;

    public int getBuyId() {
        return BuyId;
    }

    public void setBuyId(int buyId) {
        BuyId = buyId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Sell getSell() {
        return sell;
    }

    public void setSell(Sell sell) {
        this.sell = sell;
    }
}
