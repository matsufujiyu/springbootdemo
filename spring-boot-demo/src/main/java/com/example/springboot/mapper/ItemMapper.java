package com.example.springboot.mapper;


import org.apache.ibatis.annotations.Mapper;

import com.example.springboot.entity.Item;

@Mapper
public interface ItemMapper {
    Item findById(int id);
}