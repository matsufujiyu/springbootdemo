package com.example.springboot.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.dto.ItemResponse;
import com.example.springboot.entity.Item;
import com.example.springboot.mapper.ItemMapper;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    ItemMapper itemMapper;

    @GetMapping("/{id}")
    public ItemResponse findById(@PathVariable int id){
        // DBからidをキーにデータを取得
        Item item = itemMapper.findById(id);

        // Responseにデータをコピーしてreturn
        ItemResponse itemResponse = new ItemResponse();
        BeanUtils.copyProperties(item, itemResponse);
        return  itemResponse;
    }
}