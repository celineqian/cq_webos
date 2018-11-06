package com.cq.web.controller.transport;

import com.cq.web.annotion.SystemLog;
import com.cq.web.common.JsonResult;
import com.cq.web.config.specification.SimpleSpecificationBuilder;
import com.cq.web.config.specification.SpecificationOperator;
import com.cq.web.controller.BaseController;
import com.cq.web.entity.transport.*;
import com.cq.web.service.transport.DriverService;
import com.cq.web.service.transport.ServiceRecordService;
import com.cq.web.service.transport.VehicleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author Celine Q
 * @Create 2/11/2018 10:35 AM
 **/
@Controller
@RequestMapping("/transport/servicerecord")
public class ServiceRecordController extends BaseController {

    @Autowired
    private ServiceRecordService serviceRecordService;

    @Autowired
    private DriverService driverService;

    @Autowired
    private VehicleService vehicleService;


    /**
     * 保养记录首页
     */
    @RequestMapping(value = "/index")
    public String index() {
        return "transport/servicerecord/index";
    }

    /**
     * 保养记录列表页
     */
    @RequestMapping(value = { "/list" })
    @ResponseBody
    public Page<ServiceRecord> list(){
        SimpleSpecificationBuilder<ServiceRecord> builder = new SimpleSpecificationBuilder<ServiceRecord>();
        String beginTime = super.getHttpServletRequest().getParameter("beginTime");
        String endTime = super.getHttpServletRequest().getParameter("endTime");

        if(StringUtils.isNotBlank(beginTime)){

            builder.add("serviceDate", SpecificationOperator.Operator.gt.name(), beginTime);
        }
        if(StringUtils.isNotBlank(endTime)){
            builder.add("serviceDate", SpecificationOperator.Operator.lt.name(), endTime);
        }
        Page<ServiceRecord> page = serviceRecordService.findAll(builder.generateSpecification(),getPageRequest());
        return page;
    }

    /**
     * 保养记录添加页跳转
     */
    @RequestMapping(value = "/add" , method = RequestMethod.GET)
    public String add(ModelMap map) {
        List<Driver> drivers = driverService.findAll();
        map.put("drivers" , drivers);
        List<Vehicle> vehicles = vehicleService.findAll();
        map.put("vehicles" , vehicles);
        return "transport/servicerecord/add";
    }


    /**
     * 保养记录添加
     */
    @SystemLog(value = "保养记录添加")
    @RequestMapping(value= {"/add"} ,method = RequestMethod.POST)
    @ResponseBody
    public JsonResult add(ServiceRecord servicerecord, ModelMap map){
        try {
            serviceRecordService.saveOrUpdate(servicerecord);
        } catch (Exception e) {
            return JsonResult.failure(e.getMessage());
        }
        return JsonResult.success();
    }


    /**
     * 保养记录编辑页跳转
     */
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable Integer id, ModelMap map) {
        ServiceRecord servicerecord = serviceRecordService.find(id);
        map.put("servicerecord", servicerecord);
        List<Driver> drivers = driverService.findAll();
        map.put("drivers" , drivers);
        List<Vehicle> vehicles = vehicleService.findAll();
        map.put("vehicles" , vehicles);
        return "transport/servicerecord/form";
    }


    /**
     * 保养记录编辑
     */
    @SystemLog(value = "保养记录编辑")
    @RequestMapping(value= {"/edit"} ,method = RequestMethod.POST)
    @ResponseBody
    public JsonResult edit(ServiceRecord servicerecord , ModelMap map){
        try {
            serviceRecordService.saveOrUpdate(servicerecord);
        } catch (Exception e) {
            return JsonResult.failure(e.getMessage());
        }
        return JsonResult.success();
    }

}
