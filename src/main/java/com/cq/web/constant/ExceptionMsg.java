package com.cq.web.constant;

/**
 * @author: Celine Q
 * @create: 2018-10-15 23:16
 **/
public enum ExceptionMsg {

    WRONG_PASSWORD("密码错误"),
    WRONG_USERORPWD("账号或密码错误"),
    ACCOUNT_LOCKED("账号已被冻结,请联系管理员"),
    ACCOUNT_DELETED("账号已删除");

    String message;

    ExceptionMsg(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

