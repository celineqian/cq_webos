package com.cq.web.config.web;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author Celine Q
 * @Create 3/10/2018 3:15 PM
 **/
public class HttpUtil {


    public static String getIp(){
        return HttpUtil.getRequest().getRemoteHost();
    }

    /**
     * 获取 HttpServletRequest
     */
    public static HttpServletResponse getResponse() {
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        return response;
    }

    /**
     * 获取 包装防Xss Sql注入的 HttpServletRequest
     * @return request
     */
    public static HttpServletRequest getRequest() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return new WebAppFirewallWrapper(request);
    }


    /**
     * 获取所有请求的值
     * @return
     */
    public static Map<String, String> getRequestParameters() {
        HashMap<String, String> values = new HashMap<>();
        HttpServletRequest request = HttpUtil.getRequest();
        Enumeration enums = request.getParameterNames();
        while(enums.hasMoreElements()){
            String paramName = (String) enums.nextElement();
            String paramValue = request.getParameter(paramName);
            values.put(paramName,paramValue);
        }
        return values;
    }
}
