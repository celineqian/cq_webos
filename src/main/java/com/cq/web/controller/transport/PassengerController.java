package com.cq.web.controller.transport;

import com.cq.web.annotion.SystemLog;
import com.cq.web.common.JsonResult;
import com.cq.web.config.specification.SimpleSpecificationBuilder;
import com.cq.web.config.specification.SpecificationOperator;
import com.cq.web.controller.BaseController;
import com.cq.web.entity.transport.Company;
import com.cq.web.entity.transport.Passenger;
import com.cq.web.repository.transport.CompanyRepository;
import com.cq.web.service.transport.PassengerService;
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
 * @Author Celine Q
 * @Create 27/10/2018 10:59 AM
 **/
@Controller
@RequestMapping("/transport/passenger")
public class PassengerController extends BaseController {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private PassengerService passengerService;

    /**
     * 乘客首页
     */
    @RequestMapping(value = "/index")
    public String index(){
        return "transport/passenger/index";
    }


    /**
     * 乘客列表页
     */
    @RequestMapping(value = { "/list" })
    @ResponseBody
    public Page<Passenger> list(){
        SimpleSpecificationBuilder<Passenger> builder = new SimpleSpecificationBuilder<Passenger>();
        String searchText = super.getHttpServletRequest().getParameter("searchText");
        if(StringUtils.isNotBlank(searchText)){
            builder.add("name", SpecificationOperator.Operator.likeAll.name(), searchText);
        }
        Page<Passenger> page = passengerService.findAll(builder.generateSpecification(),getPageRequest());
        return page;
    }


    /**
     * 乘客添加页跳转
     */
    @RequestMapping(value = "/add" , method = RequestMethod.GET)
    public String add(ModelMap map) {
        List<Company> companies = companyRepository.findAll();
        map.put("companies" ,  companies);
        return "transport/passenger/add";
    }


    /**
     * 乘客添加
     */
    @SystemLog(value = "乘客添加")
    @RequestMapping(value= {"/add"} ,method = RequestMethod.POST)
    @ResponseBody
    public JsonResult add(Passenger passenger, ModelMap map){
        try {
            passengerService.saveOrUpdate(passenger);
        } catch (Exception e) {
            return JsonResult.failure(e.getMessage());
        }
        return JsonResult.success();
    }


    /**
     * 乘客编辑页跳转
     */
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable Integer id, ModelMap map) {
        Passenger passenger  = passengerService.find(id);
        map.put("passenger", passenger);
        List<Company> companies = companyRepository.findAll();
        map.put("companies" ,  companies);
        return "transport/passenger/form";
    }

    /**
     * 乘客编辑
     */
    @SystemLog(value = "乘客编辑")
    @RequestMapping(value= {"/edit"} ,method = RequestMethod.POST)
    @ResponseBody
    public JsonResult edit(Passenger passenger, ModelMap map){
        try {
            passengerService.saveOrUpdate(passenger);
        } catch (Exception e) {
            return JsonResult.failure(e.getMessage());
        }
        return JsonResult.success();
    }

    /**
     * 乘客删除
     */
    @SystemLog(value = "乘客删除")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult delete(@PathVariable Integer id, ModelMap map) {
        try {
            passengerService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.failure(e.getMessage());
        }
        return JsonResult.success();
    }

}
