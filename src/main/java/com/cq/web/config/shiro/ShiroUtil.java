package com.cq.web.config.shiro;

import com.cq.web.entity.admin.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

/**
 * @Author Celine Q
 * @Create 3/10/2018 3:08 PM
 **/
public class ShiroUtil {

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
    public static User getUser() {
        if (isGuest()) {
            return null;
        } else {
            return (User)getSubject().getPrincipals().getPrimaryPrincipal();
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
