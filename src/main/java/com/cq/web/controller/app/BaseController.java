package com.cq.web.controller.app;

import com.cq.web.common.DateEditor;
import com.cq.web.config.web.HttpKit;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.data.domain.Sort.Direction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by Celine on 17/09/2017.
 */
public class BaseController {

    protected static String SUCCESS = "SUCCESS";
    protected static String ERROR = "ERROR";

    protected static String REDIRECT = "redirect:";
    protected static String FORWARD = "forward:";

    protected HttpServletResponse getHttpServletResponse() {
        return HttpKit.getResponse();
    }

    protected HttpServletRequest getHttpServletRequest() {
        return HttpKit.getRequest();
    }

    protected HttpSession getSession() {
        return HttpKit.getRequest().getSession();
    }

    @InitBinder
    protected void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
        webDataBinder.registerCustomEditor(Date.class, new DateEditor(true));
    }
    /**
     * 获取分页请求
     * @return
     */
    protected PageRequest getPageRequest(){
        int page = 1;
        int size = 10;
        Sort sort = null;
        try {
            String sortName = getHttpServletRequest().getParameter("sortName");
            String sortOrder = getHttpServletRequest().getParameter("sortOrder");
            if(StringUtils.isNoneBlank(sortName) && StringUtils.isNoneBlank(sortOrder)){
                if(sortOrder.equalsIgnoreCase("desc")){
                    sort = new Sort(Direction.DESC, sortName);
                }else{
                    sort = new Sort(Direction.ASC, sortName);
                }
            }
            page = Integer.parseInt(getHttpServletRequest().getParameter("pageNumber")) - 1;
            size = Integer.parseInt(getHttpServletRequest().getParameter("pageSize"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        PageRequest pageRequest = new PageRequest(page, size, sort);
        return pageRequest;
    }

    /**
     * 获取分页请求
     * @param sort 排序条件
     * @return
     */
    protected PageRequest getPageRequest(Sort sort){
        int page = 0;
        int size = 10;
        try {
            String sortName = getHttpServletRequest().getParameter("sortName");
            String sortOrder = getHttpServletRequest().getParameter("sortOrder");
            if(StringUtils.isNoneBlank(sortName) && StringUtils.isNoneBlank(sortOrder)){
                if(sortOrder.equalsIgnoreCase("desc")){
                    sort.and(new Sort(Direction.DESC, sortName));
                }else{
                    sort.and(new Sort(Direction.ASC, sortName));
                }
            }
            page = Integer.parseInt(getHttpServletRequest().getParameter("pageNumber")) - 1;
            size = Integer.parseInt(getHttpServletRequest().getParameter("pageSize"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        PageRequest pageRequest = new PageRequest(page, size, sort);
        return pageRequest;
    }


}
