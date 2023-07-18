package com.pdai.springboothelloworld.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class User {
    private int userId;
    private String userName;
}
