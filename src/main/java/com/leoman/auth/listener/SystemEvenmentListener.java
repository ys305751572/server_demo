package com.leoman.auth.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.leoman.auth.service.CustomDefaultFilterChainManager;
import com.leoman.auth.service.ShiroFilterChainManager;

/**
 * 初始化Shiro过滤器链。
 *
 * @author lucas
 */
public class SystemEvenmentListener implements ServletContextListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(SystemEvenmentListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        WebApplicationContext applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(sce.getServletContext());
        CustomDefaultFilterChainManager filterChainManager = (CustomDefaultFilterChainManager) applicationContext.getBean("customDefaultFilterChainManager");
        ShiroFilterChainManager shiroFilterChainManager = (ShiroFilterChainManager) applicationContext.getBean("shiroFilterChainManager");
        filterChainManager.init();
        shiroFilterChainManager.init();
        shiroFilterChainManager.initFilterChain();
        LOGGER.info("init System Evenment.");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
