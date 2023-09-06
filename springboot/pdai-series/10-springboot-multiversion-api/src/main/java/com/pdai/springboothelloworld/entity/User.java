package com.pdai.springboothelloworld.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private int userId;
    private String userName;
}
