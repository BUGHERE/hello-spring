package com.example.demo.exception;

import com.example.demo.controller.ExceptionController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

/**
 * Exception拦截器
 */
// @ControllerAdvice注解的类可以拦截所有Controller的异常, 使用assignableTypes参数可以指定特定的Controller
@ControllerAdvice(assignableTypes = {ExceptionController.class})
@ResponseBody
public class GlobalExceptionHandler {

    ErrorResponse illegalArgumentResponse = new ErrorResponse(new IllegalArgumentException("参数错误!"));
    ErrorResponse resourceNotFoundResponse = new ErrorResponse(new ResourceNotFoundException("Sorry, the resource not found!"));

    @ExceptionHandler(value = Exception.class)// 拦截所有异常, 这里只是为了演示，一般情况下一个方法特定处理一种异常
    public ResponseEntity<ErrorResponse> exceptionHandler(Exception e) {

        if (e instanceof IllegalArgumentException) {
            return ResponseEntity.status(400).body(illegalArgumentResponse);
        } else if (e instanceof ResourceNotFoundException) {
            return ResponseEntity.status(404).body(resourceNotFoundResponse);
        } else if (e instanceof ResourceNotFoundException2) {
            return ResponseEntity.status(404).body(new ErrorResponse(e.getClass().getName(), e.getMessage()));
        } else if (e instanceof ResponseStatusException) {
            return ResponseEntity.status(((ResponseStatusException) e).getRawStatusCode())
                    .body(new ErrorResponse(e.getClass().getName(), e.getMessage()));
        }
        return null;
    }
}
