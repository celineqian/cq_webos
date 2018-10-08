package com.cq.web.config.shiro.check;

/**
 * 检查用接口
 * @Author Celine Q
 * @Create 8/10/2018 2:26 PM
 **/
public interface ICheck {

    /**
     * 检查当前登录用户是否拥有指定的角色访问当
     * @param permissions
     * @return
     */
    boolean check(Object[] permissions);

    /**
     * 检查当前登录用户是否拥有当前请求的servlet的权限
     * @return
     */
    boolean checkAll();

}
