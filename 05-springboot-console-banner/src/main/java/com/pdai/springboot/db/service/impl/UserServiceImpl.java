package com.pdai.springboot.db.service.impl;

import com.pdai.springboot.db.entity.User;
import com.pdai.springboot.db.service.UserService;
import com.pdai.springboot.db.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userDao;
    @Override
    public void addUser(User user) {
        userDao.save(user);
    }

    @Override
    public List<User> list() {
        return userDao.findAll();
    }
}
