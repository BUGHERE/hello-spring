package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.ResourceNotFoundException2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/exception")
public class ExceptionController {

    @GetMapping("/illegalArgumentException")
    public void throwException() {
        throw new IllegalArgumentException();
    }

    @GetMapping("/resourceNotFoundException")
    public void throwException2() {
        throw new ResourceNotFoundException();
    }

    @GetMapping("/resourceNotFoundException2")
    public void throwException3() {
        throw new ResourceNotFoundException2("Sorry, the resource not found!");
    }

    /**
     * 通过ResponseStatusException构造拥有HttpStatus的自定义Exception
     * 更加方便, 可以避免额外的异常类
     */
    @GetMapping("/resourceNotFoundException3")
    public void throwException4() {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Sorry, the resource not found!", new ResourceNotFoundException());
    }
}