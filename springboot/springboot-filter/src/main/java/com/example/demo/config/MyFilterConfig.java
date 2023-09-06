package com.example.demo.config;

import com.example.demo.filter.MyFilter;
import com.example.demo.filter.MyFilter2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyFilterConfig {
    @Autowired
    MyFilter myFilter;
    @Autowired
    MyFilter2 myFilter2;

    @Bean
    public FilterRegistrationBean<MyFilter> filterRegistrationBean() {
        FilterRegistrationBean<MyFilter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(myFilter);
        filterFilterRegistrationBean.addUrlPatterns("/api/*");
        filterFilterRegistrationBean.setName("MyFilter");
        filterFilterRegistrationBean.setOrder(1);
        return filterFilterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean<MyFilter2> filterRegistrationBean2() {
        FilterRegistrationBean<MyFilter2> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(myFilter2);
        filterFilterRegistrationBean.addUrlPatterns("/api/*");
        filterFilterRegistrationBean.setName("MyFilter2");
        filterFilterRegistrationBean.setOrder(2);
        return filterFilterRegistrationBean;
    }
}
