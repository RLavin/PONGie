package com.ironyard.security;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


/**
 * Created by Raul on 11/11/16.
 */
@Configuration
public class FilterRegistrations {

    @Bean
    public FilterRegistrationBean restApiFilter() {
        /**
         * Apply SecurityFilter filter to any request that matches /rest/*
         */
        FilterRegistrationBean registration = new FilterRegistrationBean(new SecurityFilter());
        registration.addUrlPatterns("/rest/*");
        return registration;
    }

}
