package com.cq.web.config.shiro.check;

import com.cq.web.config.web.SpringContextHelper;

/**
 * 权限检查管理器(入口)
 * @Author Celine Q
 * @Create 8/10/2018 2:25 PM
 **/
public class PermissionCheckManager {

    private final static PermissionCheckManager me = new PermissionCheckManager();

    private ICheck defaultCheckFactory = SpringContextHelper.getBean(ICheck.class);

    public static PermissionCheckManager me() {
        return me;
    }

    private PermissionCheckManager() {
    }

    public PermissionCheckManager(ICheck checkFactory) {
        this.defaultCheckFactory = checkFactory;
    }

    public void setDefaultCheckFactory(ICheck defaultCheckFactory) {
        this.defaultCheckFactory = defaultCheckFactory;
    }

    public static boolean check(Object[] permissions) {
        return me.defaultCheckFactory.check(permissions);
    }

    public static boolean checkAll() {
        return me.defaultCheckFactory.checkAll();
    }
}
