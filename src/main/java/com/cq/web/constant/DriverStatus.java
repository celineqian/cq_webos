package com.cq.web.constant;

/**
 * @author: Celine Q
 * @create: 2018-10-20 00:19
 **/
public enum  DriverStatus {

    OK(0,"正常"),
    WORKING(1,"工作中"),
    HOLIDAY(2,"休假"),
    INJURED(3,"伤病"),
    LEAVE(4,"离职");

    int code;
    String message;

    DriverStatus(int code, String message) {
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

