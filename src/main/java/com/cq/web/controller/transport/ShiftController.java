package com.cq.web.controller.transport;

import com.cq.web.annotion.SystemLog;
import com.cq.web.common.JsonResult;
import com.cq.web.config.specification.SimpleSpecificationBuilder;
import com.cq.web.config.specification.SpecificationOperator;
import com.cq.web.controller.BaseController;
import com.cq.web.entity.transport.Driver;
import com.cq.web.entity.transport.Route;
import com.cq.web.entity.transport.Shift;
import com.cq.web.entity.transport.Vehicle;
import com.cq.web.repository.transport.DriverRepository;
import com.cq.web.repository.transport.ShiftRepository;
import com.cq.web.repository.transport.VehicleRepository;
import com.cq.web.service.transport.DriverService;
import com.cq.web.service.transport.RouteService;
import com.cq.web.service.transport.ShiftService;
import com.cq.web.service.transport.VehicleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author Celine Q
 * @Create 26/10/2018 4:09 PM
 **/
@Controller
@RequestMapping("/transport/shift")
public class ShiftController extends BaseController {

    @Autowired
    private ShiftService shiftService;

    @Autowired
    private DriverService driverService;

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private RouteService routeService;

    /**
     * 班次首页
     */
    @RequestMapping(value = "/index")
    public String index() {
        return "transport/shift/index";
    }

    /**
     * 班次列表页
     */
    @RequestMapping(value = { "/list" })
    @ResponseBody
    public Page<Shift> list(){
        SimpleSpecificationBuilder<Shift> builder = new SimpleSpecificationBuilder<Shift>();
        String searchText = super.getHttpServletRequest().getParameter("searchText");
        if(StringUtils.isNotBlank(searchText)){
            builder.add("name", SpecificationOperator.Operator.likeAll.name(), searchText);
        }
        Page<Shift> page = shiftService.findAll(builder.generateSpecification(),getPageRequest());
        return page;
    }


    /**
     * 班次添加页跳转
     */
    @RequestMapping(value = "/add" , method = RequestMethod.GET)
    public String add(ModelMap map) {
        List<Driver> drivers = driverService.findAll();
        map.put("drivers" , drivers);
        List<Vehicle> vehicles = vehicleService.findAll();
        map.put("vehicles" , vehicles);
        List<Route> routes = routeService.findAll();
        map.put("routes" , routes);
        return "transport/shift/add";
    }

    /**
     * 班次添加
     */
    @SystemLog(value = "班次添加")
    @RequestMapping(value= {"/add"} ,method = RequestMethod.POST)
    @ResponseBody
    public JsonResult add(Shift shift, ModelMap map){
        try {
            shiftService.saveOrUpdate(shift);
        } catch (Exception e) {
            return JsonResult.failure(e.getMessage());
        }
        return JsonResult.success();
    }



}
