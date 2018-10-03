package com.cq.web.controller.admin;

import com.cq.web.config.log.LogManager;
import com.cq.web.config.log.LogTaskFactory;
import com.cq.web.config.shiro.ShiroKit;
import com.cq.web.config.shiro.ShiroUser;
import com.cq.web.controller.app.BaseController;
import com.cq.web.entity.admin.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import static com.cq.web.config.web.HttpKit.getIp;


/**
 * Created by Celine on 14/07/2017.
 */
@Controller
public class LoginController extends BaseController {


    @RequestMapping(value = "/admin/login" , method = RequestMethod.GET)
    public String login(){
        return "admin/login";
    }


    @RequestMapping(value = "/admin/login" , method = RequestMethod.POST)
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,ModelMap model){
        try{
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(username,password);
            subject.login(token);

            User u = (User)SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal();
            LogManager.me().executeLog(LogTaskFactory.loginLog(u.getId(), getIp()));

            return REDIRECT + "/admin/index";
        } catch (AuthenticationException e) {
            model.put("message", e.getMessage());
        }
        return "admin/login";
    }

    /**
     * 退出登陆
     * @return
     */
    @RequestMapping(value = "/admin/logout" , method = RequestMethod.GET)
    public String logout (){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return REDIRECT + "/admin/login";
    }


}
