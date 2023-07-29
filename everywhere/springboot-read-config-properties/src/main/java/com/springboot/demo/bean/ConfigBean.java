package com.springboot.demo.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "student")
public class ConfigBean {
    private String test;

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
}
