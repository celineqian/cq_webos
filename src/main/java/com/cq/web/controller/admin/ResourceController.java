package com.cq.web.controller.admin;

import com.cq.web.annotion.SystemLog;
import com.cq.web.common.JsonResult;
import com.cq.web.controller.app.BaseController;
import com.cq.web.entity.admin.Resource;
import com.cq.web.service.admin.ResourceService;
import com.cq.web.service.specification.SimpleSpecificationBuilder;
import com.cq.web.service.specification.SpecificationOperator;
import com.cq.web.vo.ZtreeView;
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
 * Created by Celine on 10/10/2017.
 */
@Controller
@RequestMapping("/admin/resource")
public class ResourceController extends BaseController {

    @Autowired
    private ResourceService resourceService;

    /**
     * 资源树列表
     */
    @RequestMapping("/tree/{resourceId}")
    @ResponseBody
    public List<ZtreeView> tree(@PathVariable Integer resourceId){
        List<ZtreeView> list = resourceService.tree(resourceId);
        return list;
    }

    /**
     * 资源主页跳转
     */
    @RequestMapping("/index")
    public String index() {
        return "admin/resource/index";
    }

    /**
     *  资源列表页
     */
    @RequestMapping("/list")
    @ResponseBody
    public Page<Resource> list() {
        SimpleSpecificationBuilder<Resource> builder = new SimpleSpecificationBuilder<Resource>();
        String searchText = super.getHttpServletRequest().getParameter("searchText");
        if(StringUtils.isNotBlank(searchText)){
            builder.add("name", SpecificationOperator.Operator.likeAll.name(), searchText);
        }
        Page<Resource> page = resourceService.findAll(builder.generateSpecification(),getPageRequest());
        return page;
    }

    /**
     * 资源添加页面跳转
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(ModelMap map) {
        List<Resource> list = resourceService.findAll();
        map.put("list", list);
        return "admin/resource/add";
    }

    /**
     * 资源添加
     */
    @SystemLog(value = "资源添加")
    @RequestMapping(value= {"/add"}, method = RequestMethod.POST)
    @ResponseBody
    public JsonResult add(Resource resource, ModelMap map){
        try {
            resourceService.saveOrUpdate(resource);
        } catch (Exception e) {
            return JsonResult.failure(e.getMessage());
        }
        return JsonResult.success();
    }

    /**
     * 资源编辑页面跳转
     */
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable Integer id,ModelMap map) {
        Resource resource = resourceService.find(id);
        map.put("resource", resource);

        List<Resource> list = resourceService.findAll();
        map.put("list", list);
        return "admin/resource/form";
    }

    /**
     * 资源编辑
     */
    @SystemLog(value = "资源编辑")
    @RequestMapping(value= {"/edit"}, method = RequestMethod.POST)
    @ResponseBody
    public JsonResult edit(Resource resource, ModelMap map){
        try {
            resourceService.saveOrUpdate(resource);
        } catch (Exception e) {
            return JsonResult.failure(e.getMessage());
        }
        return JsonResult.success();
    }

    /**
     * 资源删除
     */
    @SystemLog(value = "资源删除")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult delete(@PathVariable Integer id,ModelMap map) {
        try {
            resourceService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.failure(e.getMessage());
        }
        return JsonResult.success();
    }

}
