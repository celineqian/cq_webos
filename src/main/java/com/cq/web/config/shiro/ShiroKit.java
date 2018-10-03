package com.cq.web.config.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

/**
 * @Author Celine Q
 * @Create 3/10/2018 3:08 PM
 **/
public class ShiroKit {

    /**
     * 获取当前 Subject
     *
     * @return Subject
     */
    public static Subject getSubject() {

        return SecurityUtils.getSubject();
    }

    /**
     *
     * @return
     */
    public static ShiroUser getUser() {
        if (isGuest()) {
            return null;
        } else {
                ShiroUser u = (ShiroUser)getSubject().getPrincipals().getPrimaryPrincipal();
                return u;
        }
    }

    /**
     * 认证通过或已记住的用户。
     *
     * @return 用户：true，否则 false
     */
    public static boolean isUser() {
        return getSubject() != null && getSubject().getPrincipal() != null;
    }

    /**
     * 验证当前用户是否为“访客”，即未认证（包含未记住）的用户。
     *
     * @return 访客：true，否则false
     */
    public static boolean isGuest() {
        return !isUser();
    }


}
