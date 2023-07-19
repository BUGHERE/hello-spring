package com.pdai.springboothelloworld.controller;

import com.pdai.springboothelloworld.config.version.ApiVersion;
import com.pdai.springboothelloworld.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/{v}/user")
public class UserController {
    @RequestMapping("get")
    public User getUser() {
        return User.builder().userId(18).userName("pdai, default").build();
    }

    @ApiVersion("1.0.0")
    @RequestMapping("get")
    public User getUserV1() {
        return User.builder().userId(18).userName("pdai, v1.0.0").build();
    }

    @ApiVersion("1.1.0")
    @RequestMapping("get")
    public User getUserV11() {
        return User.builder().userId(19).userName("pdai, v1.1.0").build();
    }

    @ApiVersion("1.1.2")
    @RequestMapping("get")
    public User getUserV112() {
        return User.builder().userId(19).userName("pdai2, v1.1.2").build();
    }
}
