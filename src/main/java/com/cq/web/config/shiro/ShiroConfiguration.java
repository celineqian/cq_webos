package com.cq.web.config.shiro;

import com.cq.web.entity.admin.Resource;
import com.cq.web.repository.admin.ResourceRepository;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.shiro.mgt.SecurityManager;
import org.springframework.context.annotation.DependsOn;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Celine on 22/07/2017.
 */
@Configuration
public class ShiroConfiguration {


    @Autowired
    private ResourceRepository resourceRepository;

    @Bean(name = "lifecycleBeanPostProcessor")
    public static LifecycleBeanPostProcessor getLifecycleBeanPostProcessor(){
        return new LifecycleBeanPostProcessor();
    }


    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        shiroFilterFactoryBean.setSecurityManager(securityManager);
        shiroFilterFactoryBean.setLoginUrl("/admin/login");
        shiroFilterFactoryBean.setSuccessUrl("/admin/index");
        shiroFilterFactoryBean.setUnauthorizedUrl("/static/403");

        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<String,String>();
        filterChainDefinitionMap.put("static/**","anon");
        filterChainDefinitionMap.put("/admin/login", "anon");
        List<Resource> resourceList = resourceRepository.findAll();
        for(Resource r : resourceList){
            if(StringUtils.isNotEmpty(r.getSourceUrl())){
                String permission = "perms[" + r.getSourceKey() + "]";
                filterChainDefinitionMap.put(r.getSourceUrl(),permission);
            }
        }
        filterChainDefinitionMap.put("/admin/**" , "authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    /**
     * 用户授权信息Cache
     */
    @Bean(name = "shiroCacheManager")
    @ConditionalOnMissingBean
    public CacheManager cacheManager() {
        return new MemoryConstrainedCacheManager();
    }

    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myShiroRealm());
        securityManager.setCacheManager(cacheManager());
        return securityManager;
    }

    @Bean
    public AppRealm myShiroRealm(){
        AppRealm realm = new AppRealm();
        return realm;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        return authorizationAttributeSourceAdvisor;
    }

    @Bean(name = "defaultAdvisorAutoProxyCreator")
    @ConditionalOnMissingBean
    @DependsOn("lifecycleBeanPostProcessor")
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
        return defaultAdvisorAutoProxyCreator;

    }
}
