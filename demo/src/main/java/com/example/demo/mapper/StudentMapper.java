package com.example.demo.mapper;

import com.example.demo.model.Student;
import java.util.List;

public interface StudentMapper {
    void deleteByPrimaryKey(Integer id);

    int insert(Student record);

    Student selectByPrimaryKey(Integer id);

    List<Student> selectAll();

    int updateByPrimaryKey(Student record);
}