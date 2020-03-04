package com.example.demo.controller;

import com.example.demo.model.Student;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Controller:控制器
 * RestController: 控制器,返回数据都是json格式
 * RequestMapping:如何访问控制器
 * ResponseBody: 返回json格式数据
 */
/*@Controller*/
@RestController
@RequestMapping("/demo")
public class DemoController {

    @RequestMapping("test")
    /*@ResponseBody*/
    public String test(){
        return "1";
    }

    @RequestMapping("test1")
    /*@ResponseBody*/
    public String test1(){
        return "2";
    }

    @RequestMapping("test2")
    public Student test2(){
        Student student = new Student(1,"张三","0",new Date("2012-12-12"),77.0,"南京",2);
        return student;
    }
}
