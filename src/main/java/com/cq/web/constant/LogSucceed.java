package com.cq.web.constant;

/**
 * 业务是否成功的日志记录
 * @Author Celine Q
 * @Create 9/10/2018 12:49 PM
 **/
public enum LogSucceed {

    SUCCESS("成功"),
    FAIL("失败");

    String message;

    LogSucceed(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
