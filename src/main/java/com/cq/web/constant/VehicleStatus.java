package com.cq.web.constant;

/**
 * @Author Celine Q
 * @Create 31/10/2018 10:48 AM
 **/
public enum  VehicleStatus {

    OK(0,"正常"),
    USING(1,"使用中"),
    MAINTAINING(2,"保养"),
    RETIRED(3,"报废");

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
