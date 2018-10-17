package com.cq.web.aop;

import com.cq.web.annotion.SystemLog;
import com.cq.web.config.log.LogManager;
import com.cq.web.config.log.LogTaskFactory;
import com.cq.web.config.shiro.ShiroUtil;
import com.cq.web.entity.admin.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Author Celine Q
 * @Create 9/10/2018 11:17 AM
 **/
@Aspect
@Component
public class SystemLogAop {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Pointcut(value = "@annotation(com.cq.web.annotion.SystemLog)")
    public void cutService() {
    }

    @Around("cutService()")
    public Object recordSysLog(ProceedingJoinPoint point) throws Throwable {
        //先执行任务
        Object result = point.proceed();
        try {
            handle(point);
        } catch (Exception e) {
            log.error("日志记录错误", e);
        }
        return result;
    }

    private void handle(ProceedingJoinPoint point) throws Exception {
        //获取拦截的方法名
        Signature signature = point.getSignature();
        MethodSignature ms = null;
        if(!(signature instanceof MethodSignature)){
            throw new IllegalArgumentException("该注解只能用于方法");
        }
        ms = (MethodSignature) signature;
        Object target = point.getTarget();
        Method currentMethod =  target.getClass().getMethod(ms.getName(),ms.getParameterTypes());
        String methodName = currentMethod.getName();

        User user = ShiroUtil.getUser();
        if(user == null)
            return;

        //获取拦截方法的参数
        String className = point.getTarget().getClass().getName();
        Object[] params = point.getArgs();

        SystemLog annotation = currentMethod.getAnnotation(SystemLog.class);
        String businessName = annotation.value();
        StringBuilder sb = new StringBuilder();
        for(Object param: params){
            sb.append(param);
            sb.append(" & ");
        }
        LogManager.me().executeLog(LogTaskFactory.bussinessLog(user.getId(),businessName,className,methodName,""));
    }


}



