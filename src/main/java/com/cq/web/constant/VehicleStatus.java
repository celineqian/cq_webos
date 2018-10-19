package com.cq.web.constant;

/**
 * @author: Celine Q
 * @create: 2018-10-19 23:33
 **/
public enum VehicleStatus {

    OK(0,"可用"),
    INUSE(1,"在使用"),
    MAINTAIN(1,"保养"),
    BROKEN(2,"报废");

    int code;
    String message;

    VehicleStatus(int code, String message) {
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

