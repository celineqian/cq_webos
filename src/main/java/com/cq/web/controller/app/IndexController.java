package com.cq.web.controller.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Celine on 02/07/2017.
 */
@Controller
public class IndexController {

    @RequestMapping(value = {"/", "/index"})
    public String index(){
        return "index";
    }
}
