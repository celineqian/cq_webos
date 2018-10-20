package com.cq.web.controller.transport;

import com.cq.web.annotion.SystemLog;
import com.cq.web.common.JsonResult;
import com.cq.web.config.specification.SimpleSpecificationBuilder;
import com.cq.web.config.specification.SpecificationOperator;
import com.cq.web.controller.BaseController;
import com.cq.web.entity.transport.Driver;
import com.cq.web.entity.transport.Vehicle;
import com.cq.web.service.transport.DriverService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author Celine Q
 * @Create 20/10/2018 11:11 AM
 **/
@Controller
@RequestMapping("/transport/driver")
public class DriverController extends BaseController {

    @Autowired
    private DriverService driverService;

    /**
     * 司机首页
     */
    @RequestMapping(value = "/index")
    public String index(){
        return "transport/driver/index";
    }


    /**
     * 司机列表页
     */
    @RequestMapping(value = { "/list" })
    @ResponseBody
    public Page<Driver> list(){
        SimpleSpecificationBuilder<Driver> builder = new SimpleSpecificationBuilder<Driver>();
        String searchText = super.getHttpServletRequest().getParameter("searchText");
        if(StringUtils.isNotBlank(searchText)){
            builder.add("name", SpecificationOperator.Operator.likeAll.name(), searchText);
        }
        Page<Driver> page = driverService.findAll(builder.generateSpecification(),getPageRequest());
        return page;
    }


    /**
     * 司机添加页跳转
     */
    @RequestMapping(value = "/add" , method = RequestMethod.GET)
    public String add(ModelMap map) {
        return "transport/driver/add";
    }


    /**
     * 司机添加
     */
    @SystemLog(value = "司机添加")
    @RequestMapping(value= {"/add"} ,method = RequestMethod.POST)
    @ResponseBody
    public JsonResult add(Driver driver, ModelMap map){
        try {
            driverService.saveOrUpdate(driver);
        } catch (Exception e) {
            return JsonResult.failure(e.getMessage());
        }
        return JsonResult.success();
    }


    /**
     * 司机编辑页跳转
     */
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable Integer id, ModelMap map) {
        Driver driver  = driverService.find(id);
        map.put("driver", driver);
        return "transport/driver/form";
    }

    /**
     * 司机编辑
     */
    @SystemLog(value = "司机编辑")
    @RequestMapping(value= {"/edit"} ,method = RequestMethod.POST)
    @ResponseBody
    public JsonResult edit(Driver driver, ModelMap map){
        try {
            driverService.saveOrUpdate(driver);
        } catch (Exception e) {
            return JsonResult.failure(e.getMessage());
        }
        return JsonResult.success();
    }

    /**
     * 司机删除
     */
    @SystemLog(value = "司机删除")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult delete(@PathVariable Integer id, ModelMap map) {
        try {
            driverService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.failure(e.getMessage());
        }
        return JsonResult.success();
    }



}
