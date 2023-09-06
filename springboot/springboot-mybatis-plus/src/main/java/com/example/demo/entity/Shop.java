package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

@Data
public class Shop {

    private Long id;
    private String name;
    private Integer price;
    @Version // 添加@Version注解，使用mybatis-plus的乐观锁机制
    private Integer version;
}