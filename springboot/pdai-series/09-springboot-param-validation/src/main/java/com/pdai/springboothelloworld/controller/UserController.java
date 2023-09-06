package com.pdai.springboothelloworld.controller;

import com.pdai.springboothelloworld.entity.User;
import com.pdai.springboothelloworld.service.UserService;
import com.pdai.springboothelloworld.validation.AddValidationGroup;
import com.pdai.springboothelloworld.validation.ListValidationGroup;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity add(@Validated(AddValidationGroup.class) User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            allErrors.forEach(error -> {
                FieldError e = (FieldError) error;
                log.error("Invalid Parameter: object - {}, field - {}, errorMessage - {}", e.getObjectName(), e.getField(), e.getDefaultMessage());
            });
//            String msg = allErrors.stream().map((e) -> e.getDefaultMessage()).reduce("", (res, a) -> res + a, (r1, r2) -> r1 + r2 + "\n");
            return ResponseEntity.ok(allErrors);
        }
        userService.addUser(user);
        return ResponseEntity.ok(user);
    }

    @RequestMapping("/list")
    public ResponseEntity<List<User>> list(@Validated(ListValidationGroup.class) User user, BindingResult bindingResult) {
//        List<User> users = Collections.singletonList(User.builder().userName("123").userId(123).build();
        if (bindingResult.hasErrors()) {
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            allErrors.forEach(error -> {
                FieldError e = (FieldError) error;
                log.error("Invalid Parameter: object - {}, field - {}, errorMessage - {}", e.getObjectName(), e.getField(), e.getDefaultMessage());
            });
        }
        return ResponseEntity.ok(userService.list());
    }
}
