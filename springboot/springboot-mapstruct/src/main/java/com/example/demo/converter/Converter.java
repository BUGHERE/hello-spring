package com.example.demo.converter;

import com.example.demo.entity.CodeDst;
import com.example.demo.entity.CodeSrc;
import com.example.demo.entity.OrderDst;
import com.example.demo.entity.OrderSrc;

public interface Converter {
    OrderDst convert(OrderSrc sourceOrder);
    CodeDst convert(CodeSrc sourceCode);
}
