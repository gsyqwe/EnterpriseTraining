package com.example.demo.mapper;

import com.example.demo.model.College;
import java.util.List;

public interface CollegeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(College record);

    College selectByPrimaryKey(Integer id);

    List<College> selectAll();

    int updateByPrimaryKey(College record);
}