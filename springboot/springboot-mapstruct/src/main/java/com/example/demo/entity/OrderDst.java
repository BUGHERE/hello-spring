package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDst {
    private String orderFinishDate;
    private int orderId;
    private OrderStatus orderStatus;
    private LocalDate orderDate;
}
