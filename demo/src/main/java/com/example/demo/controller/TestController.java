package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private Book demoBook;

    @Resource
    private User demoUser;

    @RequestMapping("demo")
    public Book demo(){
        return demoBook;
    }

    @RequestMapping("demo1")
    public User demo1(){
        return demoUser;
    }
}
