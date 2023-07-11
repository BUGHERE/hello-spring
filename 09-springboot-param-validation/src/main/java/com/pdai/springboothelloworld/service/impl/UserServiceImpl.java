package com.pdai.springboothelloworld.service.impl;

import com.pdai.springboothelloworld.dao.UserRepository;
import com.pdai.springboothelloworld.entity.User;
import com.pdai.springboothelloworld.service.UserService;
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
