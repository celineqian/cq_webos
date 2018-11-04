package com.cq.web.controller.transport;

import com.cq.web.annotion.SystemLog;
import com.cq.web.common.JsonResult;
import com.cq.web.config.specification.SimpleSpecificationBuilder;
import com.cq.web.config.specification.SpecificationOperator;
import com.cq.web.controller.BaseController;
import com.cq.web.entity.transport.Vehicle;
import com.cq.web.service.transport.VehicleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @Author Celine Q
 * @Create 19/10/2018 6:24 PM
 **/
@Controller
@RequestMapping("/transport/vehicle")
public class VehicleController extends BaseController {

    @Autowired
    private VehicleService vehicleService;

    /**
     * 车辆首页
     */
    @RequestMapping(value = "/index")
    public String index() {
        return "transport/vehicle/index";
    }


    /**
     * 车辆列表页
     */
    @RequestMapping(value = { "/list" })
    @ResponseBody
    public Page<Vehicle> list(@RequestParam("plate") String plate, @RequestParam("serviceDate")Date serviceDate){
        String plateNo = plate;
        Date sDate = serviceDate;
        SimpleSpecificationBuilder<Vehicle> builder = new SimpleSpecificationBuilder<Vehicle>();
        String searchText = super.getHttpServletRequest().getParameter("searchText");
        if(StringUtils.isNotBlank(searchText)){
            builder.add("name", SpecificationOperator.Operator.likeAll.name(), searchText);
        }
        Page<Vehicle> page = vehicleService.findAll(builder.generateSpecification(),getPageRequest());
        return page;
    }


    /**
     * 车辆添加页跳转
     */
    @RequestMapping(value = "/add" , method = RequestMethod.GET)
    public String add(ModelMap map) {
        return "transport/vehicle/add";
    }


    /**
     * 车辆添加
     */
    @SystemLog(value = "车辆添加")
    @RequestMapping(value= {"/add"} ,method = RequestMethod.POST)
    @ResponseBody
    public JsonResult add(Vehicle vehicle, ModelMap map){
        try {
            vehicleService.saveOrUpdate(vehicle);
        } catch (Exception e) {
            return JsonResult.failure(e.getMessage());
        }
        return JsonResult.success();
    }

    /**
     * 车辆编辑页跳转
     */
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable Integer id, ModelMap map) {
        Vehicle vehicle = vehicleService.find(id);
        map.put("vehicle", vehicle);
        return "transport/Vehicle/form";
    }

    /**
     * 车辆编辑
     */
    @SystemLog(value = "车辆编辑")
    @RequestMapping(value= {"/edit"} ,method = RequestMethod.POST)
    @ResponseBody
    public JsonResult edit(Vehicle vehicle, ModelMap map){
        try {
            vehicleService.saveOrUpdate(vehicle);
        } catch (Exception e) {
            return JsonResult.failure(e.getMessage());
        }
        return JsonResult.success();
    }

    /**
     * 车辆删除
     */
    @SystemLog(value = "车辆删除")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult delete(@PathVariable Integer id, ModelMap map) {
        try {
            vehicleService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.failure(e.getMessage());
        }
        return JsonResult.success();
    }


}
