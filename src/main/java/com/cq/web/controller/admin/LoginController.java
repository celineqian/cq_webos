package com.cq.web.controller.admin;

import com.cq.web.annotion.SystemLog;
import com.cq.web.config.log.LogManager;
import com.cq.web.config.log.LogTaskFactory;
import com.cq.web.config.shiro.ShiroUtil;
import com.cq.web.controller.app.BaseController;
import com.cq.web.entity.admin.User;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import static com.cq.web.config.web.HttpUtil.getIp;


/**
 * Created by Celine on 14/07/2017.
 */
@Controller
public class LoginController extends BaseController {


    /**
     * 用户登陆主页
     */
    @RequestMapping(value = {"/", "/index","/admin/login"}  , method = RequestMethod.GET)
    public String login(){
        return "admin/login";
    }


    /**
     * 用户登陆
     */
    @SystemLog(value = "用户登陆")
    @RequestMapping(value = "/admin/login" , method = RequestMethod.POST)
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,ModelMap model){
        try{
            Subject currentUser = ShiroUtil.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(username,password);
            currentUser.login(token);

            User user = ShiroUtil.getUser();
            LogManager.me().executeLog(LogTaskFactory.loginLog(user.getId(), getIp()));
            return REDIRECT + "/admin/index";
        } catch (AuthenticationException e) {
            model.put("message", e.getMessage());
        }
        return "admin/login";
    }

    /**
     * 退出登陆
     */
    @SystemLog(value = "退出登陆")
    @RequestMapping(value = "/admin/logout" , method = RequestMethod.GET)
    public String logout (){
        LogManager.me().executeLog(LogTaskFactory.exitLog(ShiroUtil.getUser().getId(),getIp()));
        ShiroUtil.getSubject().logout();
        return REDIRECT + "/admin/login";
    }


}
