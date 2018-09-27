package com.cq.web.controller.admin;

import com.cq.web.controller.app.BaseController;
import com.cq.web.repository.admin.NoticeRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author: Celine Q
 * @create: 2018-09-25 20:49
 **/
@Controller
@RequestMapping("/admin/notice")
public class NoticeController extends BaseController {

    @Autowired
    private NoticeRespository noticeRespository;


    @RequestMapping(value = { "/list" })
    public String list(ModelMap map){
        List list = noticeRespository.findAll();
        map.put("noticeList",list);
        return "redirect:admin/login";
    }

}

