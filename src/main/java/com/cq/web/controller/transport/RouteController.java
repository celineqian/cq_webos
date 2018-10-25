package com.cq.web.controller.transport;

import com.cq.web.annotion.SystemLog;
import com.cq.web.common.JsonResult;
import com.cq.web.config.specification.SimpleSpecificationBuilder;
import com.cq.web.config.specification.SpecificationOperator;
import com.cq.web.controller.BaseController;
import com.cq.web.entity.transport.Flight;
import com.cq.web.entity.transport.Route;
import com.cq.web.service.transport.FlightService;
import com.cq.web.service.transport.RouteService;
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
import java.util.Set;

/**
 * @author: Celine Q
 * @create: 2018-10-21 17:38
 **/
@Controller
@RequestMapping("/transport/route")
public class RouteController extends BaseController {

    @Autowired
    private RouteService routeService;

    @Autowired
    private FlightService flightService;
    /**
     * 路线首页
     */
    @RequestMapping(value = "/index")
    public String index(){
        return "transport/route/index";
    }


    /**
     * 路线列表页
     */
    @RequestMapping(value = { "/list" })
    @ResponseBody
    public Page<Route> list(){
        SimpleSpecificationBuilder<Route> builder = new SimpleSpecificationBuilder<Route>();
        String searchText = super.getHttpServletRequest().getParameter("searchText");
        if(StringUtils.isNotBlank(searchText)){
            builder.add("name", SpecificationOperator.Operator.likeAll.name(), searchText);
        }
        Page<Route> page = routeService.findAll(builder.generateSpecification(),getPageRequest());
        return page;
    }


    /**
     * 路线添加页跳转
     */
    @RequestMapping(value = "/add" , method = RequestMethod.GET)
    public String add(ModelMap map) {
        List<Flight> flights = flightService.findAll();
        map.put("flights", flights);
        return "transport/route/add";
    }


    /**
     * 路线添加
     */
    @SystemLog(value = "路线添加")
    @RequestMapping(value= {"/add"} ,method = RequestMethod.POST)
    @ResponseBody
    public JsonResult add(Route route, ModelMap map){
        try {
            routeService.saveOrUpdate(route);
        } catch (Exception e) {
            return JsonResult.failure(e.getMessage());
        }
        return JsonResult.success();
    }

    /**
     * 路线编辑页跳转
     */
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable Integer id, ModelMap map) {
        Route route = routeService.find(id);
        List<Flight> flights = flightService.findAll();
        map.put("flights",flights);
        map.put("route", route);
        return "transport/route/form";
    }

    /**
     * 路线编辑
     */
    @SystemLog(value = "路线编辑")
    @RequestMapping(value= {"/edit"} ,method = RequestMethod.POST)
    @ResponseBody
    public JsonResult edit(Route route, ModelMap map){
        try {
            routeService.saveOrUpdate(route);
        } catch (Exception e) {
            return JsonResult.failure(e.getMessage());
        }
        return JsonResult.success();
    }

    /**
     * 路线删除
     */
    @SystemLog(value = "路线删除")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult delete(@PathVariable Integer id, ModelMap map) {
        try {
            routeService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.failure(e.getMessage());
        }
        return JsonResult.success();
    }
}

