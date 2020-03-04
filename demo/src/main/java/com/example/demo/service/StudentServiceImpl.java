package com.example.demo.service;

import com.example.demo.mapper.StudentMapper;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Autowired: 把dao层注入到别的类
 * @Service: 项目加载的时候会new StudentServiceImpl对象名默默认是接口名studentService
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    /**
     * 根据键加载记录
     * @param id
     * @return
     */
    @Override
    public Student selById(Integer id) {
        return studentMapper.selectByPrimaryKey(id);
    }

    /**
     * 查所有记录
     * @return
     */
    @Override
    public List<Student> selAll() {
        return studentMapper.selectAll();
    }

    /**
     * 新增
     * @param student
     */
    @Override
    public void add(Student student) {
        studentMapper.insert(student);
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void del(Integer id) {
        studentMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改
     * @param student
     */
    @Override
    public void update(Student student) {
        studentMapper.updateByPrimaryKey(student);
    }

    /**
     * 分页查询
     * @param currPage 第几页
     * @return
     */
    @Override
    public PageInfo<Student> selAll(Integer currPage) {
        if(currPage == null) currPage = 1;
        //设置从第几页开始查询2条,1页有2条数据
        PageHelper.startPage(currPage,2);
        //分页查询
        PageInfo<Student> pageInfo = new PageInfo<>(studentMapper.selectAll());
        return pageInfo;
    }
}
