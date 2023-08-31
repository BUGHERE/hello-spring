package com.example.demo;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Shop;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.mapper.ShopMapper;
import com.example.demo.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
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

    @Test
    void saveEmployeeWithoutId() {
        Employee employee = new Employee();
        employee.setLastName("lisa");
        employee.setEmail("lisa@qq.com");
        employee.setAge(20);
        employeeService.save(employee);
    }

    /**
     * setGmtCreate and setGmtModified manually
     */
    @Test
    void employeeServiceTest3() {
        Employee employee = new Employee();
        employee.setLastName("lisa");
        employee.setEmail("lisa@qq.com");
        employee.setAge(20);
        // 设置时间
        employee.setGmtCreate(LocalDateTime.now());
        employee.setGmtModified(LocalDateTime.now());
        employeeService.save(employee);
    }

    /**
     * 属性自动填充
     */
    @Test
    void employeeServiceTest4() {
        Employee employee = new Employee();
        employee.setLastName("lisa");
        employee.setEmail("lisa@qq.com");
        employee.setAge(20);
        employeeService.save(employee);
    }

    @Test
    void employeeRemoveTest() {
        employeeService.removeById(1696496974923980801L);
    }

    @Autowired
    private ShopMapper shopMapper;

    /**
     * 模拟并发场景
     * 乐观锁认为数据产生冲突的情况一般不会发生，所以在修改数据的时候并不会对数据表进行加锁的操作，而是在提交数据时进行校验，判断提交上来的数据是否会发生冲突
     * 如果发生冲突，则提示用户重新进行操作，一般的实现方式为 设置版本号字段 。
     * 就以商品售价为例，在该表中设置一个版本号字段，让其初始为 1，此时 A 管理员和 B 管理员同时需要修改售价，它们会先读取到数据表中的内容，此时两个管理员读取到的版本号都为 1
     * 此时 B 管理员的操作先生效了，它就会将当前数据表中对应数据的版本号与最开始读取到的版本号作一个比对，发现没有变化，于是修改就生效了，此时版本号加 1。
     * 而 A 管理员马上也提交了修改操作，但是此时的版本号为 2，与最开始读取到的版本号并不对应，这就说明数据发生了冲突，此时应该提示 A 管理员操作失败，并让 A 管理员重新查询一次数据。
     */
    @Test
    void shopTest() {

        // A、B管理员读取数据
        Shop A = shopMapper.selectById(1L);
        Shop B = shopMapper.selectById(1L);
        // B管理员先修改
        B.setPrice(9000);
        int result = shopMapper.updateById(B);
        if (result == 1) {
            System.out.println("B管理员修改成功!");
        } else {
            System.out.println("B管理员修改失败!");
        }
        // A管理员后修改
        A.setPrice(8500);
        int result2 = shopMapper.updateById(A);
        if (result2 == 1) {
            System.out.println("A管理员修改成功!");
        } else {
            System.out.println("A管理员修改失败!");
        }
        // 最后查询
        System.out.println(shopMapper.selectById(1L));
    }
}
