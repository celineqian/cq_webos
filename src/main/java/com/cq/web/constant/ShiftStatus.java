package com.cq.web.constant;

/**
 * @Author Celine Q
 * @Create 26/10/2018 4:54 PM
 **/
public enum ShiftStatus {

    OK(0,"正常"),
    SETTLED(1,"已结算"),
    CLOSED(2,"关闭");

    int code;
    String message;

    ShiftStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
