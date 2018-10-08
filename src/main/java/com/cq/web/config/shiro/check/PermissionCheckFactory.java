package com.cq.web.config.shiro.check;

import com.cq.web.common.CollectionUtil;
import com.cq.web.config.shiro.ShiroUtil;
import com.cq.web.config.web.SpringContextHelper;
import com.cq.web.entity.admin.User;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



/**
 * 权限自定义检查
 * @Author Celine Q
 * @Create 8/10/2018 2:43 PM
 **/
@Service
@DependsOn("springContextHelper")
@Transactional(readOnly = true)
public class PermissionCheckFactory implements ICheck {

    public static ICheck me() {
        return SpringContextHelper.getBean(ICheck.class);
    }

    @Override
    public boolean check(Object[] permissions) {
        User user = ShiroUtil.getUser();
        if(null == user)
            return false;
        String join = CollectionUtil.join(permissions,",");
        if(ShiroUtil.hasAnyRoles(join))
            return true;
        return false;
    }

    @Override
    public boolean checkAll() {
        //TODO finish it
        return false;
    }
}
