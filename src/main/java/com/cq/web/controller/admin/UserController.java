package com.cq.web.controller.admin;

import com.cq.web.annotion.SystemLog;
import com.cq.web.common.JsonResult;
import com.cq.web.controller.BaseController;
import com.cq.web.entity.admin.Role;
import com.cq.web.entity.admin.User;
import com.cq.web.service.admin.RoleService;
import com.cq.web.service.admin.UserService;
import com.cq.web.config.specification.SimpleSpecificationBuilder;
import com.cq.web.config.specification.SpecificationOperator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Celine on 01/08/2017.
 */
@Controller
@RequestMapping("/admin/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;


    @RequestMapping(value = { "/", "/index" })
    public String index() {
        return "admin/user/index";
    }

    /**
     * 用户列表页
     */
    @RequestMapping(value = { "/list" })
    @ResponseBody
    public Page<User> list() {
        SimpleSpecificationBuilder<User> builder = new SimpleSpecificationBuilder<User>();
        String searchText = super.getHttpServletRequest().getParameter("searchText");
        if(StringUtils.isNotBlank(searchText)){
            builder.add("nickName", SpecificationOperator.Operator.likeAll.name(), searchText);
        }
        Page<User> page = userService.findAll(builder.generateSpecification(), getPageRequest());
        return page;
    }

    /**
     * 跳转用户添加页面
     */
    @RequestMapping(value = "/add" , method = RequestMethod.GET)
    public String add(ModelMap map) {
        return "admin/user/add";
    }

    /**
     * 添加用户
     */
    @SystemLog(value = "添加用户")
    @RequestMapping(value= {"/add"} ,method = RequestMethod.POST)
    @ResponseBody
    public JsonResult add(User user, ModelMap map){
        try {
            userService.saveOrUpdate(user);
        } catch (Exception e) {
            return JsonResult.failure(e.getMessage());
        }
        return JsonResult.success();
    }

    /**
     * 编辑用户跳转页面
     */
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable Integer id,ModelMap map) {
        User user = userService.find(id);
        map.put("user", user);
        return "admin/user/form";
    }

    /**
     * 查看用户信息
     */
    @RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
    public String view(@PathVariable Integer id,ModelMap map) {
        User user = userService.find(id);
        map.put("user", user);
        return "admin/user/view";
    }

    /**
     * 编辑用户
     */
    @SystemLog(value = "编辑用户")
    @RequestMapping(value= {"/edit"} ,method = RequestMethod.POST)
    @ResponseBody
    public JsonResult edit(User user, ModelMap map){
        try {
            userService.saveOrUpdate(user);
        } catch (Exception e) {
            return JsonResult.failure(e.getMessage());
        }
        return JsonResult.success();
    }

    /**
     * 删除用户
     */
    @SystemLog(value = "删除用户")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult delete(@PathVariable Integer id,ModelMap map) {
        try {
            userService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.failure(e.getMessage());
        }
        return JsonResult.success();
    }


    /**
     * 跳转到关联角色页面
     */
    @RequestMapping(value = "/grant/{id}", method = RequestMethod.GET)
    public String grant(@PathVariable Integer id, ModelMap map){
        User user = userService.find(id);
        map.put("user" , user);
        Set<Role> set = user.getRoles();
        List<Integer> roleIds = new ArrayList<Integer>();
        for (Role role: set){
            roleIds.add(role.getId());
        }
        map.put("roleIds" , roleIds);
        List<Role> roles = roleService.findAll();
        map.put("roles" , roles);
        return "admin/user/grant";
    }

    /**
     * 关联角色
     */
    @SystemLog(value = "关联角色")
    @ResponseBody
    @RequestMapping(value = "/grant/{id}", method = RequestMethod.POST)
    public JsonResult grant(@PathVariable Integer id,String[] roleIds, ModelMap map) {
        try{
            userService.grant(id, roleIds);
        }catch (Exception e){
            e.printStackTrace();
            return JsonResult.failure(e.getMessage());
        }
        return JsonResult.success();
    }

}
