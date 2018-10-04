package com.cq.web.controller.admin;

import com.cq.web.common.JsonResult;
import com.cq.web.controller.app.BaseController;
import com.cq.web.entity.admin.LoginLog;
import com.cq.web.repository.admin.LoginLogRespository;
import com.cq.web.service.specification.SimpleSpecificationBuilder;
import com.cq.web.service.specification.SpecificationOperator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author Celine Q
 * @Create 4/10/2018 9:52 AM
 **/
@Controller
@RequestMapping("/admin/loginlog")
public class LoginLogController extends BaseController {

    @Autowired
    private LoginLogRespository loginLogRespository;

    @RequestMapping(value = { "/", "/index" })
    public String index() {
        return "admin/loginlog/index";
    }



    @RequestMapping(value = { "/list" })
    @ResponseBody
    public Page<LoginLog> list() {
        SimpleSpecificationBuilder<LoginLog> builder = new SimpleSpecificationBuilder<LoginLog>();
        String searchText = super.getHttpServletRequest().getParameter("searchText");
        if(StringUtils.isNotBlank(searchText)){
            builder.add("nickName", SpecificationOperator.Operator.likeAll.name(), searchText);
        }
        Page<LoginLog> page = loginLogRespository.findAll(builder.generateSpecification(), getPageRequest());
        return page;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult delete() {
        try {
            loginLogRespository.deleteAll();
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.failure(e.getMessage());
        }
        return JsonResult.success();
    }



}