package com.cq.web.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Celine on 16/07/2017.
 */
@Controller
public class AdminIndexController {

    @RequestMapping(value = {"/admin/", "/admin/index"})
    public String index(){

        return "admin/index";
    }

    @RequestMapping(value = {"/admin/welcome"})
    public String welcome(){
        return "admin/welcome";
    }
}
