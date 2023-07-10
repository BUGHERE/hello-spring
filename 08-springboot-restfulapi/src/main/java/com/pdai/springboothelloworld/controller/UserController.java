package com.pdai.springboothelloworld.controller;

import com.pdai.springboothelloworld.entity.ResponseResult;
import com.pdai.springboothelloworld.entity.User;
import com.pdai.springboothelloworld.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/add")
    public ResponseResult<String> add(User user) {
        userService.addUser(user);
        return ResponseResult.success("success");
    }

    @RequestMapping("/list")
    public ResponseResult<List<User>> list() {
//        List<User> users = Collections.singletonList(User.builder().userName("123").userId(123).build();
        return ResponseResult.success(userService.list());
    }
}
