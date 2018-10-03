package com.cq.web.config.shiro;

import com.jagregory.shiro.freemarker.ShiroTags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import javax.annotation.PostConstruct;

/**
 * Created by Celine on 19/07/2017.
 */
@Configuration
public class ShiroTagConfig {


    @Autowired
    private freemarker.template.Configuration configuration;

    @PostConstruct
    public void setSharedVariable() {
        try {
            configuration.setSharedVariable("shiro", new ShiroTags());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


