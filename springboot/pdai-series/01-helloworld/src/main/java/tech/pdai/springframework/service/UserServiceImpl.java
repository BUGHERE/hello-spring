package tech.pdai.springframework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.pdai.springframework.dao.UserDaoImpl;
import tech.pdai.springframework.entity.User;

import java.util.List;

@Service
public class UserServiceImpl {
    @Autowired
    private UserDaoImpl userDao;

    public UserServiceImpl() {
    }

    public List<User> findUserList() {
        return this.userDao.findUserList();
    }

    public void setUserDao(UserDaoImpl userDao) {
        this.userDao = userDao;
    }
}
