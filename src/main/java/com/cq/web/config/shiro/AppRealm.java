package com.cq.web.config.shiro;

import com.cq.web.common.MD5Utils;
import com.cq.web.config.log.LogManager;
import com.cq.web.config.log.LogTaskFactory;
import com.cq.web.entity.admin.Resource;
import com.cq.web.entity.admin.Role;
import com.cq.web.entity.admin.User;
import com.cq.web.repository.admin.UserRepository;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.AllowAllCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

import static com.cq.web.config.web.HttpKit.getIp;

/**
 * Created by Celine on 14/07/2017.
 */
@Component
public class AppRealm extends AuthorizingRealm {


    @Autowired
    private UserRepository userRepository;



    public AppRealm(){
        super(new AllowAllCredentialsMatcher());
        setAuthenticationTokenClass(UsernamePasswordToken.class);
        //FIXME: 暂时禁用Cache
        setCachingEnabled(false);
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(
            PrincipalCollection principals) {
        User user = (User) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        User dbUser = userRepository.findByUserName(user.getUserName());
        Set<String> shiroPermissions = new HashSet<>();
        Set<String> roleSet = new HashSet();
        Set<Role> roles = dbUser.getRoles();
        for(Role role : roles) {
            Set<Resource> resources = role.getResources();
            for (Resource resource : resources) {
                shiroPermissions.add(resource.getSourceKey());
            }
            roleSet.add(role.getRoleKey());
        }
        authorizationInfo.setRoles(roleSet);
        authorizationInfo.setStringPermissions(shiroPermissions);
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {
        String username = (String)token.getPrincipal();
        User user = userRepository.findByUserName(username);
        String password = new String((char[]) token.getCredentials());
        if(user == null) {
            String msg = "账号或密码不正确";
            LogManager.me().executeLog(LogTaskFactory.loginLog(username,msg,getIp()));
            throw new UnknownAccountException(msg);
        }
        // 密码错误
        if (!MD5Utils.md5(password).equals(user.getPassword())) {
            String msg = "密码不正确";
            LogManager.me().executeLog(LogTaskFactory.loginLog(username,msg,getIp()));
            throw new IncorrectCredentialsException(msg);
        }
        // 账号锁定
        if (user.getLocked() == 1) {
            String msg = "账号已被锁定,请联系管理员";
            LogManager.me().executeLog(LogTaskFactory.loginLog(username,msg,getIp()));
            throw new LockedAccountException(msg);
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());
        return info;
    }
}
