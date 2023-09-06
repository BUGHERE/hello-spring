package com.example.demo.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class InterceptorTestController {

    @RequestMapping(value = { "/test" })
    public String test(Model model) {
        System.out.println("\n-------- InterceptorTestController.test --- ");
        return "test";
    }

    // This path is no longer used.
    // It will be redirected by OldLoginInterceptor
    @Deprecated
    @RequestMapping(value = { "/oldLogin" })
    public String oldLogin(Model model) {
        // Code here never run.
        return "oldLogin";
    }

    @RequestMapping(value = { "/login" })
    public String login(Model model) {
        System.out.println("\n-------- InterceptorTestController.login --- ");
        return "login";
    }
}
