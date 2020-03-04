package com.example.student.controller;


import com.example.student.model.College;
import com.example.student.model.Student;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/student")
public class StudentController {

    @RequestMapping("get")
    public Student queryStudent(){
        Student student = new Student();
        student.setId(1);
        student.setName("张三");
        student.setAddress("南京");
        student.setCollegeId(2);
        //调用学校微服务里面接口:根据ID获取学校
        String url = "http://localhost:8761/college/get/" + student.getCollegeId();
        RestTemplate restTemplate = new RestTemplate();
        College college = restTemplate.getForObject(url, College.class);
        student.setCollege(college);
        return student;
    }
}
