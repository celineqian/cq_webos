package com.cq.web.constant;

/**
 * 日志类型
 * @Author Celine Q
 * @Create 3/10/2018 12:02 PM
 **/
public enum LogType {


    LOGIN("登录日志"),
    LOGIN_FAIL("登录失败日志"),
    LOGIN_SUCCEED("登陆成功"),
    EXIT("退出日志"),
    EXCEPTION("异常日志"),
    BUSSINESS("业务日志");

    String message;

    LogType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
