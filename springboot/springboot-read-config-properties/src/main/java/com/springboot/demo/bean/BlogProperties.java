package com.springboot.demo.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BlogProperties {
    @Value("${test}")
    private String test;

    public String getTest() {
        return test;
    }
}
