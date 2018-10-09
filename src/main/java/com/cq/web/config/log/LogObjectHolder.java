package com.cq.web.config.log;

import com.cq.web.config.web.SpringContextHelper;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.io.Serializable;

/**
 * @Author Celine Q
 * @Create 9/10/2018 12:07 PM
 **/
@Component
@Scope(scopeName = WebApplicationContext.SCOPE_SESSION)
public class LogObjectHolder implements Serializable {

    private Object object = null;

    public void set(Object obj) {
        this.object = obj;
    }

    public Object get() {
        return object;
    }

    public static LogObjectHolder me(){
        LogObjectHolder bean = SpringContextHelper.getBean(LogObjectHolder.class);
        return bean;
    }
}
