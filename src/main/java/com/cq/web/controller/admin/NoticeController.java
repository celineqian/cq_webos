package com.cq.web.controller.admin;

import com.cq.web.common.JsonResult;
import com.cq.web.controller.app.BaseController;
import com.cq.web.entity.admin.Notice;
import com.cq.web.repository.admin.NoticeRespository;
import com.cq.web.service.admin.NoticeService;
import com.cq.web.service.specification.SimpleSpecificationBuilder;
import com.cq.web.service.specification.SpecificationOperator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * @author: Celine Q
 * @create: 2018-09-25 20:49
 **/
@Controller
@RequestMapping("/admin/notice")
public class NoticeController extends BaseController {


    @Autowired
    private NoticeService noticeService;

    @RequestMapping(value = { "/", "/index" })
    public String index() {

        return "admin/notice/index";
    }

    @RequestMapping(value = { "/list" })
    @ResponseBody
    public Page<Notice> list(){
        SimpleSpecificationBuilder<Notice> builder = new SimpleSpecificationBuilder<Notice>();
        String searchText = super.getHttpServletRequest().getParameter("searchText");
        if(StringUtils.isNotBlank(searchText)){
            builder.add("name", SpecificationOperator.Operator.likeAll.name(), searchText);
        }
        Page<Notice> page = noticeService.findAll(builder.generateSpecification(),getPageRequest());
        return page;
    }

    @RequestMapping(value = "/add" , method = RequestMethod.GET)
    public String add(ModelMap map) {
        return "admin/notice/form";
    }


    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable Integer id,ModelMap map) {
        Notice notice = noticeService.find(id);
        map.put("notice", notice);
        return "admin/notice/form";
    }


    @RequestMapping(value= {"/edit"} ,method = RequestMethod.POST)
    @ResponseBody
    public JsonResult edit(Notice notice, ModelMap map){
        try {
            noticeService.saveOrUpdate(notice);
        } catch (Exception e) {
            return JsonResult.failure(e.getMessage());
        }
        return JsonResult.success();
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult delete(@PathVariable Integer id, ModelMap map) {
        try {
            noticeService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.failure(e.getMessage());
        }
        return JsonResult.success();
    }



}

