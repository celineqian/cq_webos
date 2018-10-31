package com.cq.web.controller.transport;

import com.cq.web.annotion.SystemLog;
import com.cq.web.common.JsonResult;
import com.cq.web.config.specification.SimpleSpecificationBuilder;
import com.cq.web.config.specification.SpecificationOperator;
import com.cq.web.controller.BaseController;
import com.cq.web.entity.transport.Company;
import com.cq.web.service.transport.CompanyService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


/**
 * @Author Celine Q
 * @Create 29/10/2018 11:55 AM
 **/
@Controller
@RequestMapping("/transport/company")
public class CompanyController extends BaseController {


    @Autowired
    private CompanyService companyService;

    /**
     * 公司首页
     */
    @RequestMapping(value = "/index")
    public String index(){
        return "transport/company/index";
    }


    /**
     * 公司列表页
     */
    @RequestMapping(value = { "/list" })
    @ResponseBody
    public Page<Company> list(){
        SimpleSpecificationBuilder<Company> builder = new SimpleSpecificationBuilder<Company>();
        String searchText = super.getHttpServletRequest().getParameter("searchText");
        if(StringUtils.isNotBlank(searchText)){
            builder.add("name", SpecificationOperator.Operator.likeAll.name(), searchText);
        }
        Page<Company> page = companyService.findAll(builder.generateSpecification(),getPageRequest());
        return page;
    }

    /**
     * 公司添加页跳转
     */
    @RequestMapping(value = "/add" , method = RequestMethod.GET)
    public String add(ModelMap map) {
        return "transport/company/add";
    }


    /**
     * 公司添加
     */
    @SystemLog(value = "公司添加")
    @RequestMapping(value= {"/add"} ,method = RequestMethod.POST)
    @ResponseBody
    public JsonResult add(Company company, ModelMap map){
        try {
            companyService.saveOrUpdate(company);
        } catch (Exception e) {
            return JsonResult.failure(e.getMessage());
        }
        return JsonResult.success();
    }


    /**
     * 公司编辑页跳转
     */
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable Integer id, ModelMap map) {
        Company company  = companyService.find(id);
        map.put("company", company);
        return "transport/company/form";
    }

    /**
     * 公司编辑
     */
    @SystemLog(value = "公司编辑")
    @RequestMapping(value= {"/edit"} ,method = RequestMethod.POST)
    @ResponseBody
    public JsonResult edit(Company company, ModelMap map){
        try {
            companyService.saveOrUpdate(company);
        } catch (Exception e) {
            return JsonResult.failure(e.getMessage());
        }
        return JsonResult.success();
    }



    /**
     * 公司删除
     */
    @SystemLog(value = "公司删除")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult delete(@PathVariable Integer id, ModelMap map) {
        try {
            companyService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.failure(e.getMessage());
        }
        return JsonResult.success();
    }


}
