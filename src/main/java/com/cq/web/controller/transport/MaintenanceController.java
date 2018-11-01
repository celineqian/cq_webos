package com.cq.web.controller.transport;

import com.cq.web.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author Celine Q
 * @Create 1/11/2018 4:47 PM
 **/
@Controller
@RequestMapping("/transport/maintenance")
public class MaintenanceController extends BaseController {


    /**
     * 保养首页
     */
    @RequestMapping(value = "/index")
    public String index(){
        return "transport/service/index";
    }


}
