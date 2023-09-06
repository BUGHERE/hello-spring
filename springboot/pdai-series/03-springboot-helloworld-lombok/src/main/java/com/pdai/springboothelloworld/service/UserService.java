package com.pdai.springboothelloworld.service;

import com.pdai.springboothelloworld.entity.User;

import java.util.List;

public interface UserService {
    public void addUser(User user);
    public List<User> list();
}
