package com.cq.web.config.web;

import com.cq.web.config.intercepter.CommonIntercepter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Celine on 22/07/2017.
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Autowired
    CommonIntercepter commonIntercepter;

    /**
     * 添加拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(commonIntercepter).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

    @Bean
    public FilterRegistrationBean registFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new OpenEntityManagerInViewFilter());
        registration.addUrlPatterns("/*");
        registration.setOrder(1);
        return registration;
    }



}
