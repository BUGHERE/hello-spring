package com.springboot.demo;

import com.springboot.demo.bean.BlogProperties;
import com.springboot.demo.bean.ConfigBean;
import com.springboot.demo.bean.TestConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EnableConfigurationProperties({ConfigBean.class, TestConfigBean.class})
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}

	@Autowired
	private BlogProperties blogProperties;

	@RequestMapping("/test")
	public String test() {
		return blogProperties.getTest();
	}

	@Autowired
	private ConfigBean configBean;

	@RequestMapping("/test1")
	public String test1() {
		return configBean.getTest();
	}

	@Autowired
	private TestConfigBean testConfigBean;

	@RequestMapping("/test2")
	public String test2() {
		return testConfigBean.getTest1() + " " + testConfigBean.getTest2();
	}
}
