package com.cq.web.constant;

/**
 * @Author Celine Q
 * @Create 16/10/2018 9:51 AM
 **/
public enum AccountStatus {

    OK(0,"正常"),
    FROZEN(1,"冻结"),
    DELETED(2,"删除");

    int code;
    String message;

    AccountStatus(int code, String message) {
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
