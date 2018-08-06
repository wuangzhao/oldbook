package org.fd.dto;

import org.fd.entity.BuyEntity;
import org.fd.enums.BuyStateEnum;

public class BuyExecution {

    private int sellId;

    private int state;

    private String stateInfo;

    private BuyEntity buyEntity;

    public BuyExecution() {

    }

    public BuyExecution(int sellId, BuyStateEnum buyStateEnum) {
        this.sellId = sellId;
        this.state = buyStateEnum.getState();
        this.stateInfo = buyStateEnum.getStateInfo();
    }

    public BuyExecution(int sellId, BuyStateEnum buyStateEnum, BuyEntity buyEntity) {
        this.sellId = sellId;
        this.state = buyStateEnum.getState();
        this.stateInfo = buyStateEnum.getStateInfo();
        this.buyEntity = buyEntity;
    }

    public int getSellId() {
        return sellId;
    }

    public void setSellId(int sellId) {
        this.sellId = sellId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public BuyEntity getBuyEntity() {
        return buyEntity;
    }

    public void setBuyEntity(BuyEntity buyEntity) {
        this.buyEntity = buyEntity;
    }

    @Override
    public String toString() {
        return "BuyExecution{" +
                "sellId=" + sellId +
                ", state=" + state +
                ", stateInfo='" + stateInfo + '\'' +
                ", buyEntity=" + buyEntity +
                '}';
    }
}