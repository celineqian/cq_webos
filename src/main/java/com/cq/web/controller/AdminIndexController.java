package com.cq.web.controller;

import com.cq.web.entity.admin.Notice;
import com.cq.web.repository.admin.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Celine on 16/07/2017.
 */
@Controller
public class AdminIndexController {

    @Autowired
    private NoticeRepository noticeRepository;

    @RequestMapping(value = {"/admin/", "/admin/index"})
    public String index(){
        return "admin/index";
    }

    @RequestMapping(value = {"/admin/welcome"})
    public String welcome(ModelMap map){
        List<Notice> list = noticeRepository.findAll();
        map.put("noticeList",list);
        return "admin/welcome";
    }
}
