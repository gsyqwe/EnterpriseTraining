package com.example.demo.controller;


import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Resource: 注入springboot创建好的对象
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    //private StudentDao studentDao = new StudentDao();

    @Resource
    private StudentService studentService;

    @RequestMapping("get")
    public Student get(Integer id){
        return studentService.selById(id);
    }

    /**
     * resultful风格接收参数
     * @param id
     * @return
     */
    @RequestMapping("get/{id}")
    public Student load(@PathVariable Integer id){
        return studentService.selById(id);
    }

    @RequestMapping("list")
    public List<Student> list(){
        return studentService.selAll();
    }

    @RequestMapping("query/{page}")
    public PageInfo<Student> query(@PathVariable Integer page){
        return studentService.selAll(page);
    }

    /**
     * 新增
     * @param student
     * @return
     */
    @RequestMapping("add")
    public String add(@RequestBody Student student){
        studentService.add(student);
        return "succ";
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("del/{id}")
    public String del(@PathVariable Integer id){
        studentService.del(id);
        return "succ";
    }

    /**
     * 修改
     * @param student
     * @return
     */
    @RequestMapping("update")
    public String update(@RequestBody Student student){
        studentService.update(student);
        return "succ";
    }

}
