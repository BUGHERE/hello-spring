package com.pdai.springboot.db.service;

import com.pdai.springboot.db.entity.User;

import java.util.List;

public interface UserService {
    public void addUser(User user);
    public List<User> list();
}
