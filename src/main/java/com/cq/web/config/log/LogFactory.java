package com.cq.web.config.log;

import com.cq.web.entity.admin.LoginLog;

import java.util.Date;

/**
 * @Author Celine Q
 * @Create 3/10/2018 12:01 PM
 **/
public class LogFactory {

    /**
     * 创建登陆日志
     * @param logType 日志类型
     * @param userId 用户ID
     * @param msg 日志信息
     * @param ip 登陆ip地址
     * @return
     */
    public static LoginLog createLoginLog(LogType logType, Integer userId, String msg, String ip) {
        LoginLog loginLog = new LoginLog();
        loginLog.setLogName(logType.getMessage());
        loginLog.setUserId(userId);
        loginLog.setCreateTime(new Date());
        loginLog.setIp(ip);
        loginLog.setMessage(msg);
        return loginLog;
    }
}
