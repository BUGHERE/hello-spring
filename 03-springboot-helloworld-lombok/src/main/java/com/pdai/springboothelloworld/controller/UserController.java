package com.pdai.springboothelloworld.controller;

import com.pdai.springboothelloworld.entity.User;
import com.pdai.springboothelloworld.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/add")
    public User add(User user) {
        userService.addUser(user);
        return user;
    }

    @RequestMapping("/list")
    public List<User> list() {
        return userService.list();
    }
}
