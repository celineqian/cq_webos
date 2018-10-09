package com.cq.web.config.log;

import com.cq.web.config.web.SpringContextHelper;
import com.cq.web.entity.admin.LoginLog;
import com.cq.web.entity.admin.OperationLog;
import com.cq.web.repository.admin.LoginLogRepository;
import com.cq.web.repository.admin.OperationLogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.TimerTask;

/**
 * @Author Celine Q
 * @Create 3/10/2018 11:59 AM
 **/

public class LogTaskFactory {

    @Autowired
    private static LoginLogRepository loginLogRepository = SpringContextHelper.getBean(LoginLogRepository.class);

    private static OperationLogRepository operationLogRepository = SpringContextHelper.getBean(OperationLogRepository.class);

    private static Logger logger = LoggerFactory.getLogger(LogManager.class);

    public static TimerTask loginLog(final Integer userId, final String ip) {
        return new TimerTask() {
            @Override
            public void run() {
                try {
                    LoginLog loginLog = LogFactory.createLoginLog(LogType.LOGIN, userId, null, ip);
                    loginLogRepository.saveAndFlush(loginLog);
                } catch (Exception e) {
                    logger.error("创建登录日志异常!", e);
                }
            }
        };
    }

    public static TimerTask loginLog(final String username, final String msg, final String ip) {
        return new TimerTask() {
            @Override
            public void run() {
                LoginLog loginLog = LogFactory.createLoginLog(LogType.LOGIN_FAIL, null, "账号:" + username + "," + msg, ip);
                try {
                    loginLogRepository.saveAndFlush(loginLog);
                } catch (Exception e) {
                    logger.error("创建登录失败异常!", e);
                }
            }
        };
    }

    public static TimerTask exitLog(final Integer userId, final String ip) {
        return new TimerTask() {
            @Override
            public void run() {
                LoginLog loginLog = LogFactory.createLoginLog(LogType.EXIT, userId, null, ip);
                try {
                    loginLogRepository.saveAndFlush(loginLog);
                } catch (Exception e) {
                    logger.error("创建退出日志异常!", e);
                }
            }
        };
    }

    public static TimerTask bussinessLog(final Integer userId, final String bussinessName, final String clazzName, final String methodName, final String msg) {
        return new TimerTask() {
            @Override
            public void run() {
                OperationLog operationLog = LogFactory.createOperationLog(LogType.BUSSINESS, userId, bussinessName, clazzName, methodName, msg, LogSucceed.SUCCESS);
                try {
                    operationLogRepository.saveAndFlush(operationLog);
                } catch (Exception e) {
                    logger.error("创建业务日志异常!", e);
                }
            }
        };
    }

}
