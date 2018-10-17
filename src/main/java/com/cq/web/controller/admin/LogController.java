package com.cq.web.controller.admin;

import com.cq.web.annotion.SystemLog;
import com.cq.web.common.JsonResult;
import com.cq.web.controller.app.BaseController;
import com.cq.web.entity.admin.OperationLog;
import com.cq.web.repository.admin.OperationLogRepository;
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
 * @Create 5/10/2018 9:58 AM
 **/
@Controller
@RequestMapping("/admin/log")
public class LogController extends BaseController {

    @Autowired
    private OperationLogRepository operationLogRepository;

    @RequestMapping(value = { "/", "/index" })
    public String index() {
        return "admin/log/index";
    }


    /**
     * 业务日志列表页
     */
    @RequestMapping(value = { "/list" })
    @ResponseBody
    public Page<OperationLog> list() {
        SimpleSpecificationBuilder<OperationLog> builder = new SimpleSpecificationBuilder<OperationLog>();
        String searchText = super.getHttpServletRequest().getParameter("searchText");
        if(StringUtils.isNotBlank(searchText)){
            builder.add("nickName", SpecificationOperator.Operator.likeAll.name(), searchText);
        }
        Page<OperationLog> page = operationLogRepository.findAll(builder.generateSpecification(), getPageRequest());
        return page;
    }


    /**
     * 清空业务日志
     */
    @SystemLog(value = "清空业务日志")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult delete() {
        try {
            operationLogRepository.deleteAll();
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.failure(e.getMessage());
        }
        return JsonResult.success();
    }


}
