package com.example.demo;

import com.example.demo.entity.Employee;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@MapperScan("com.example.demo.mapper")
class SpringbootMybatisPlusApplicationTests {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private EmployeeService employeeService;

    @Test
    void employeeMapperTest() {
        List<Employee> employees = employeeMapper.selectList(null);
        employees.forEach(System.out::println);
    }

    @Test
    void employeeServiceTest() {
        List<Employee> employees = employeeService.list();
        employees.forEach(System.out::println);
    }

    @Test
    void employeeServiceTest2() {
        List<Employee> employees = employeeService.listAllByLastName("tom");
        employees.forEach(System.out::println);
    }
}
