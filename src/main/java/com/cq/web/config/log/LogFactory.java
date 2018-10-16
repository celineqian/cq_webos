package com.cq.web.config.log;

import com.cq.web.constant.LogState;
import com.cq.web.constant.LogType;
import com.cq.web.entity.admin.LoginLog;
import com.cq.web.entity.admin.OperationLog;

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

    /**
     * 创建操作日志
     * @param logType
     * @param userId
     * @param bussinessName
     * @param clazzName
     * @param methodName
     * @param succeed
     * @return
     */
    public static OperationLog createOperationLog(LogType logType, Integer userId, String bussinessName,
                                                  String clazzName, String methodName, LogState succeed) {
        OperationLog operationLog = new OperationLog();
        operationLog.setLogType(logType.getMessage());
        operationLog.setLogName(bussinessName);
        operationLog.setUserId(userId);
        operationLog.setClassName(clazzName);
        operationLog.setMethod(methodName);
        operationLog.setCreateTime(new Date());
        operationLog.setSucceed(succeed.getMessage());
        return operationLog;
    }
}
