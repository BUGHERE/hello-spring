package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 自定义Exception
 * 通过ResponseStatus注解简单处理异常的方法（将异常映射为状态码）
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException2 extends RuntimeException {

   public ResourceNotFoundException2() {
   }

   public ResourceNotFoundException2(String message) {
       super(message);
   }
}