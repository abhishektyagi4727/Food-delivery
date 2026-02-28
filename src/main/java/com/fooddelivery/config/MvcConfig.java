package com.fooddelivery.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // REMOVE these if you already have them in controllers
        // registry.addViewController("/login").setViewName("login");
        // registry.addViewController("/register").setViewName("register");
        
        // Keep only non-controller mappings
        registry.addViewController("/access-denied").setViewName("error/access-denied");
    }
}