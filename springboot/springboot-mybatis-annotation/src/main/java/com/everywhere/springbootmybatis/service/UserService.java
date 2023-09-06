package com.everywhere.springbootmybatis.service;

import com.everywhere.springbootmybatis.bean.User;
import com.everywhere.springbootmybatis.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public List<User> selectUserByName(String name) {
        return userDao.findUserByName(name);
    }

    public List<User> selectAllUser() {
        return userDao.findAllUser();
    }

    public void insertUser(String name, Integer age, Double money) {
        userDao.insertUser(name, age, money);
    }

    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }

    // 事务
    @Transactional
    public void updateUser(String name, Integer age, Double money, int id) {
        userDao.updateUser(name, age, money, id);
    }
}
