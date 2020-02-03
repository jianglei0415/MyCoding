package com.springboot.chapter12.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author: jianglei
 * @date: 2020/2/1 14:50
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login/page").setViewName("login");
        registry.addViewController("/logout/page").setViewName("logout_welcome");
        registry.addViewController("/logout").setViewName("logout");
    }
}
