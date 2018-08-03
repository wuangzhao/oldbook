package org.fd.entity;

public class BuyEntity {

    private int BuyId;

    private UserEntity userEntity;

    private SellEntity sellEntity;

    public int getBuyId() {
        return BuyId;
    }

    public void setBuyId(int buyId) {
        BuyId = buyId;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public SellEntity getSellEntity() {
        return sellEntity;
    }

    public void setSellEntity(SellEntity sellEntity) {
        this.sellEntity = sellEntity;
    }
}
