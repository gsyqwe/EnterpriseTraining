package com.example.demo.service;

import com.example.demo.model.Student;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface StudentService {

    /**
     * 根据键加载记录
     * @param id
     * @return
     */
    public Student selById(Integer id);

    /**
     * 查所有记录
     * @return
     */
    public List<Student> selAll();

    /**
     * 新增
     * @param student
     */
    public void add(Student student);

    /**
     * 删除
     * @param id
     */
    public void del(Integer id);

    /**
     * 修改
     * @param student
     */
    public void update(Student student);

    /**
     * 分页查询
     * @param currPage 第几页
     * @return
     */
    public PageInfo<Student> selAll(Integer currPage);

}
