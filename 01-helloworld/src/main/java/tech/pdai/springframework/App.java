package tech.pdai.springframework;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import tech.pdai.springframework.config.BeansConfig;
import tech.pdai.springframework.entity.User;
import tech.pdai.springframework.service.UserServiceImpl;

import java.util.List;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("tech.pdai.springframework");
        UserServiceImpl service = context.getBean("userService", UserServiceImpl.class);
        List<User> userList = service.findUserList();
        userList.forEach((user) -> System.out.println(user.getName() + ": " + user.getAge()));
    }
}