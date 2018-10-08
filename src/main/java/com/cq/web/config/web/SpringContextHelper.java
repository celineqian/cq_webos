package com.cq.web.config.web;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Spring的ApplicationContext的帮助类,可以用静态方法的方式获取spring容器中的bean
 * @author: Celine Q
 * @create: 2018-10-03 18:29
 **/
@Component
public class SpringContextHelper implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextHelper.applicationContext = applicationContext;
    }

    /**
     * 通过类获取
     * @param clazz 注入的类
     * @param <T> 返回类型
     * @return 返回这个bean
     * @throws BeansException 异常
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(Class clazz) throws BeansException {
        return (T) applicationContext.getBean(clazz);
    }

    /**
     * 通过名字获取
     * @param beanName Bean名字
     * @param <T> 返回类型
     * @return 返回这个bean
     * @throws BeansException 异常
     */
    public static <T> T getBean(String beanName) throws BeansException {
        return  (T) applicationContext.getBean(beanName);
    }
}

