package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.Employee;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
    @Override
    public List<Employee> listAllByLastName(String lastName) {
        // 在 EmployeeServiceImpl 中我们无需将 EmployeeMapper 注入进来，因为 ServiceImpl 已经帮我们注入在baseMapper了
        return baseMapper.selectAllByLastName(lastName);
    }
}