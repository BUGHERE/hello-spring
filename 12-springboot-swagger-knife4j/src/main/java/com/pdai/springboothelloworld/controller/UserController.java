package com.pdai.springboothelloworld.controller;

import com.pdai.springboothelloworld.entity.User;
import com.pdai.springboothelloworld.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation("Add User")
//    @ApiImplicitParam(name = "user", dataTypeClass = User.class, required = true)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", dataTypeClass = Integer.class, required = true),
            @ApiImplicitParam(name = "userName", dataTypeClass = String.class, required = true)
    })
    @RequestMapping("/add")
    public User add(User user) {
        userService.addUser(user);
        return user;
    }

    @ApiOperation("Query User List")
    @RequestMapping("/list")
    public List<User> list() {
        return userService.list();
    }
}
