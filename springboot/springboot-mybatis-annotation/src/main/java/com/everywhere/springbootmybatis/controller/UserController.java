package com.everywhere.springbootmybatis.controller;

import com.everywhere.springbootmybatis.bean.User;
import com.everywhere.springbootmybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/query")
    public List<User> testQuery(@RequestParam("name") String name) {
        return userService.selectUserByName(name);
    }

    @RequestMapping("/insert")
    public List<User> testInsert(@RequestParam("name") String name,
                                 @RequestParam("age") Integer age,
                                 @RequestParam("money") Double money) {
        userService.insertUser(name, age, money);
        return userService.selectAllUser();
    }


    @RequestMapping("/update")
    public List<User> testUpdateUser(@RequestParam("name") String name,
                                     @RequestParam("age") Integer age,
                                     @RequestParam("money") Double money,
                                     @RequestParam("id") int id) {
        userService.updateUser(name, age, money, id);
        return userService.selectAllUser();
    }

    @RequestMapping("/delete")
    public String testDelete(@RequestParam("id") int id) {
        userService.deleteUser(id);
        return "OK";
    }
}