package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PersonSource  {
    private Integer id;
    private String username;
    private String password;
    private Integer age;
}