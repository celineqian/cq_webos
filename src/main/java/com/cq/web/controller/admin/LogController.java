package com.cq.web.controller.admin;

import com.cq.web.controller.app.BaseController;
import com.cq.web.repository.admin.OperationLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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


}
