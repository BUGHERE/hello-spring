package com.example.demo.controller;

import com.example.demo.bean.Person;
import com.example.demo.exception.BaseException;
import com.example.demo.exception.ErrorCode;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/exception")
public class ExceptionController {

    @GetMapping("/resourceNotFound")
    public void throwException() {
        Person p=new Person(1L,"SnailClimb");
        Map<String, Object> map = new HashMap();
        map.put("person id:", p.getId());
        throw new ResourceNotFoundException(map);
    }

    @GetMapping("/resourceNotFound2")
    public void throwException2() {
        Person p=new Person(1L,"SnailClimb");
        Map<String, Object> map = new HashMap();
        map.put("person id:", p.getId());
        throw new BaseException(ErrorCode.RESOURCE_NOT_FOUND, map);
    }
}