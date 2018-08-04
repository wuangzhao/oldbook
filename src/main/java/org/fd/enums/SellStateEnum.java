package org.fd.enums;

public enum SellStateEnum {

    SUCCESS(1, "出售成功"), FAILURE(0, "出售失败"), INNER_ERROR(-1, "系统异常");

    private int state;

    private String stateInfo;

    SellStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static SellStateEnum stateOf(int index) {
        for (SellStateEnum state : values()) {
            if (state.getState() == index) {
                return state;
            }
        }
        return null;
    }
}
