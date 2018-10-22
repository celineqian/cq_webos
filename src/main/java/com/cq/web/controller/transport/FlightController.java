package com.cq.web.controller.transport;

import com.cq.web.annotion.SystemLog;
import com.cq.web.common.JsonResult;
import com.cq.web.config.specification.SimpleSpecificationBuilder;
import com.cq.web.config.specification.SpecificationOperator;
import com.cq.web.controller.BaseController;
import com.cq.web.entity.transport.Flight;
import com.cq.web.service.transport.FlightService;
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
 * @Create 22/10/2018 1:07 PM
 **/
@Controller
@RequestMapping("/transport/flight")
public class FlightController extends BaseController {

    @Autowired
    private FlightService flightService;

    /**
     * 航班首页
     */
    @RequestMapping(value = "/index")
    public String index(){
        return "transport/flight/index";
    }


    /**
     * 航班列表页
     */
    @RequestMapping(value = { "/list" })
    @ResponseBody
    public Page<Flight> list(){
        SimpleSpecificationBuilder<Flight> builder = new SimpleSpecificationBuilder<Flight>();
        String searchText = super.getHttpServletRequest().getParameter("searchText");
        if(StringUtils.isNotBlank(searchText)){
            builder.add("name", SpecificationOperator.Operator.likeAll.name(), searchText);
        }
        Page<Flight> page = flightService.findAll(builder.generateSpecification(),getPageRequest());
        return page;
    }


    /**
     * 航班添加页跳转
     */
    @RequestMapping(value = "/add" , method = RequestMethod.GET)
    public String add(ModelMap map) {
        return "transport/flight/add";
    }


    /**
     * 航班添加
     */
    @SystemLog(value = "航班添加")
    @RequestMapping(value= {"/add"} ,method = RequestMethod.POST)
    @ResponseBody
    public JsonResult add(Flight flight, ModelMap map){
        try {
            flightService.saveOrUpdate(flight);
        } catch (Exception e) {
            return JsonResult.failure(e.getMessage());
        }
        return JsonResult.success();
    }


    /**
     * 航班编辑页跳转
     */
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable Integer id, ModelMap map) {
        Flight flight  = flightService.find(id);
        map.put("flight", flight);
        return "transport/flight/form";
    }

    /**
     * 航班编辑
     */
    @SystemLog(value = "司机编辑")
    @RequestMapping(value= {"/edit"} ,method = RequestMethod.POST)
    @ResponseBody
    public JsonResult edit(Flight flight, ModelMap map){
        try {
            flightService.saveOrUpdate(flight);
        } catch (Exception e) {
            return JsonResult.failure(e.getMessage());
        }
        return JsonResult.success();
    }

    /**
     * 航班删除
     */
    @SystemLog(value = "航班删除")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult delete(@PathVariable Integer id, ModelMap map) {
        try {
            flightService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.failure(e.getMessage());
        }
        return JsonResult.success();
    }

}
