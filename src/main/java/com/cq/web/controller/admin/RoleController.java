package com.cq.web.controller.admin;

import com.cq.web.annotion.SystemLog;
import com.cq.web.common.JsonResult;
import com.cq.web.controller.BaseController;
import com.cq.web.entity.admin.Role;
import com.cq.web.service.admin.RoleService;
import com.cq.web.config.specification.SimpleSpecificationBuilder;
import com.cq.web.config.specification.SpecificationOperator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Celine on 10/10/2017.
 */
@Controller
@RequestMapping("/admin/role")
public class RoleController extends BaseController {

    @Autowired
    private RoleService roleService;


    /**
     * 角色主页跳转
     */
    @RequestMapping(value = { "/", "/index" })
    public String index() {
        return "admin/role/index";
    }

    /**
     * 角色列表页
     */
    @RequestMapping(value = { "/list" })
    @ResponseBody
    public Page<Role> list() {
        SimpleSpecificationBuilder<Role> builder = new SimpleSpecificationBuilder<Role>();
        String searchText = super.getHttpServletRequest().getParameter("searchText");
        if(StringUtils.isNotBlank(searchText)){
            builder.add("name", SpecificationOperator.Operator.likeAll.name(), searchText);
            builder.addOr("description", SpecificationOperator.Operator.likeAll.name(), searchText);
        }
        Page<Role> page = roleService.findAll(builder.generateSpecification(), getPageRequest());
        return page;
    }

    /**
     * 角色添加页面跳转
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(ModelMap map) {
        return "admin/role/add";
    }

    /**
     * 角色添加
     */
    @SystemLog(value = "角色添加")
    @RequestMapping(value= {"/add"},method = RequestMethod.POST)
    @ResponseBody
    public JsonResult add(Role role, ModelMap map){
        try {
            roleService.saveOrUpdate(role);
        } catch (Exception e) {
            return JsonResult.failure(e.getMessage());
        }
        return JsonResult.success();
    }

    /**
     * 角色修改页面跳转
     */
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable Integer id,ModelMap map) {
        Role role = roleService.find(id);
        map.put("role", role);
        return "admin/role/form";
    }


    /**
     * 角色修改
     */
    @SystemLog(value = "角色修改")
    @RequestMapping(value= {"/edit"},method = RequestMethod.POST)
    @ResponseBody
    public JsonResult edit(Role role, ModelMap map){
        try {
            roleService.saveOrUpdate(role);
        } catch (Exception e) {
            return JsonResult.failure(e.getMessage());
        }
        return JsonResult.success();
    }

    /**
     * 角色删除
     */
    @SystemLog(value = "角色删除")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult delete(@PathVariable Integer id,ModelMap map) {
        try {
            roleService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.failure(e.getMessage());
        }
        return JsonResult.success();
    }

    /**
     * 角色权限分配页跳转
     */
    @RequestMapping(value = "/grant/{id}", method = RequestMethod.GET)
    public String grant(@PathVariable Integer id, ModelMap map) {
        Role role = roleService.find(id);
        map.put("role", role);
        return "admin/role/grant";
    }

    /**
     * 资源分配
     */
    @SystemLog(value = "资源分配")
    @RequestMapping(value = "/grant/{id}", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult grant(@PathVariable Integer id,
                            @RequestParam(required = false) String[] resourceIds, ModelMap map) {
        try {
            roleService.grant(id,resourceIds);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.failure(e.getMessage());
        }
        return JsonResult.success();
    }


}
