package org.fd.enums;

public enum BuyStateEnum {

    SUCCESS(1, "购买失败"), HAS_SOLD(0, "已出售"), INNER_ERROR(-1, "系统异常"), ILLEGAL(-2, "非法操作");

    private int state;

    private String stateInfo;

    BuyStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static BuyStateEnum stateOf(int index) {
        for (BuyStateEnum state : values()) {
            if (state.getState() == index) {
                return state;
            }
        }
        return null;
    }

}
