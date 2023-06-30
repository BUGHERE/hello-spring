package tech.pdai.springframework.dao;

import org.springframework.stereotype.Repository;
import tech.pdai.springframework.entity.User;

import java.util.Collections;
import java.util.List;

@Repository
public class UserDaoImpl {
    public UserDaoImpl() {
    }

    public List<User> findUserList() {
        return Collections.singletonList(new User("pdai", 18));
    }
}
