package org.fd.dto;

import org.fd.entity.SellEntity;
import org.fd.enums.SellStateEnum;

public class SellExecution {

    //图书ID
    private int bookId;

    //出售状态
    private int state;

    //状态标示
    private String stateInfo;

    //预约成功对象
    private SellEntity sellEntity;

    public SellExecution() {

    }

    //失败构造器
    public SellExecution(int bookId, SellStateEnum stateEnum) {
        this.bookId = bookId;
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }

    //成功构造器
    public SellExecution(int bookId, SellStateEnum stateEnum, SellEntity sellEntity) {
        this.bookId = bookId;
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.sellEntity = sellEntity;
    }


    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
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

    public SellEntity getSellEntity() {
        return sellEntity;
    }

    public void setSellEntity(SellEntity sellEntity) {
        this.sellEntity = sellEntity;
    }

    @Override
    public String toString() {
        return "SellExecution{" +
                "bookId=" + bookId +
                ", state=" + state +
                ", stateInfo='" + stateInfo + '\'' +
                ", sellEntity=" + sellEntity +
                '}';
    }
}
