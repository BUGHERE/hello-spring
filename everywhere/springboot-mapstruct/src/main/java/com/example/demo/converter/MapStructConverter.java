package com.example.demo.converter;

import com.example.demo.entity.CodeDst;
import com.example.demo.entity.CodeSrc;
import com.example.demo.entity.OrderDst;
import com.example.demo.entity.OrderSrc;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MapStructConverter extends Converter {
    MapStructConverter INSTANCE = Mappers.getMapper(MapStructConverter.class);

    @Mapping(source = "status", target = "orderStatus")
    @Override
    OrderDst convert(OrderSrc sourceOrder);

    @Override
    CodeDst convert(CodeSrc sourceCode);
}