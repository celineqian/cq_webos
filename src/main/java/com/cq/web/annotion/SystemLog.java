package com.cq.web.annotion;

import java.lang.annotation.*;

/**
 * @Author Celine Q
 * @Create 5/10/2018 11:56 AM
 **/
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface SystemLog {

    /**
     * 业务名称,例如："修改菜单"
     * @return
     */
    String value() default "";

}
