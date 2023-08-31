package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("tbl_employee")
public class Employee {
    // IdType
    //
    /**
     * IdType
     *      AUTO            数据库ID自增
     *      NONE            该类型为未设置主键类型(注解里等于跟随全局)
     *      INPUT           需要自行输入ID
     *      ASSIGN_ID       默认实现类为DefaultIdentifierGenerator雪花算法(默认)
     *      ASSIGN_UUID     默认实现类为DefaultIdentifierGenerator UUID
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    private String lastName;
    private String email;
    private Integer age;
    @TableField(fill = FieldFill.INSERT)  // 创建的时候自动填充
    private LocalDateTime gmtCreate;
    @TableField(fill = FieldFill.INSERT_UPDATE)  // 创建和更新的时候自动填充
    private LocalDateTime gmtModified;
    /**
     * 逻辑删除属性
     */
    @TableLogic
    @TableField("is_deleted")
    private Boolean deleted;
}