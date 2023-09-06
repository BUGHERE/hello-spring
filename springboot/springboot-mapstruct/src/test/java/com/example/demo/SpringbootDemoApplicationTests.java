package com.example.demo;

import com.example.demo.converter.Converter;
import com.example.demo.converter.MapStructConverter;
import com.example.demo.entity.*;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
class SpringbootDemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void codeTest() {
        CodeSrc codeSrc = new CodeSrc("1234");
        Converter converter = MapStructConverter.INSTANCE;
        CodeDst convert = converter.convert(codeSrc);
        System.out.println("convert = " + convert);
    }

    @Test
    void orderTest() {
        OrderSrc orderSrc = new OrderSrc("1234", 1, new OrderStatus(), LocalDate.now());
        Converter converter = MapStructConverter.INSTANCE;
        OrderDst convert = converter.convert(orderSrc);
        System.out.println("convert = " + convert);
    }

}
