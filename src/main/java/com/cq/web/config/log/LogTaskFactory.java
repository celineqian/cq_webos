package com.cq.web.config.log;

import com.cq.web.config.web.SpringContextHelper;
import com.cq.web.entity.admin.LoginLog;
import com.cq.web.repository.admin.LoginLogRespository;
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
    private static LoginLogRespository loginLogRespository = SpringContextHelper.getBean(LoginLogRespository.class);

    private static Logger logger = LoggerFactory.getLogger(LogManager.class);

    public static TimerTask loginLog(final Integer userId, final String ip) {
        return new TimerTask() {
            @Override
            public void run() {
                try{
                    LoginLog loginLog = LogFactory.createLoginLog(LogType.LOGIN, userId, null, ip);
                    loginLogRespository.saveAndFlush(loginLog);
                }catch(Exception e){
                    logger.error("创建登录日志异常!", e);
                }
            }
        };
    }

    public static TimerTask loginLog(final String username, final String msg, final String ip){
        return new TimerTask() {
            @Override
            public void run() {
                LoginLog loginLog = LogFactory.createLoginLog(LogType.LOGIN_FAIL,null,"账号:" + username + "," + msg,ip);
                try{
                    loginLogRespository.saveAndFlush(loginLog);
                }catch (Exception e){
                    logger.error("创建登录失败异常!", e);
                }
            }
        };
    }

    public static TimerTask exitLog(final Integer userId, final String ip) {
        return new TimerTask() {
            @Override
            public void run() {
                LoginLog loginLog = LogFactory.createLoginLog(LogType.EXIT, userId, null,ip);
                try{
                    loginLogRespository.saveAndFlush(loginLog);
                }catch (Exception e){
                    logger.error("创建退出日志异常!", e);
                }
            }
        };
    }

}