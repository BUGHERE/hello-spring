package com.example.demo.exception;

import java.util.Map;

/**
 * 使用BaseException简化自定义异常
 */
public class ResourceNotFoundException extends BaseException {

    public ResourceNotFoundException(Map<String, Object> data) {
        super(ErrorCode.RESOURCE_NOT_FOUND, data);
    }
}