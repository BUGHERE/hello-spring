package com.example.demo.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper extends BaseMapper<Employee> {
    // 实现在 EmployeeMapper.xml 中
    // 这里的xml文件路径不需要在application.yml中配置，因为mybatis-plus默认配置在resources/mapper下
    List<Employee> selectAllByLastName(@Param("lastName") String lastName);
}
