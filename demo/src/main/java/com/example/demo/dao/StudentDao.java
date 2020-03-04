package com.example.demo.dao;


import com.example.demo.model.Student;
import com.example.demo.util.ConnDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentDao {

    /**
     * 根据主键加载记录
     * @param id
     * @return
     */
    public Student getById(Integer id){
        Student student = new Student();
        Connection connection = ConnDB.getConn();
        String sql = "select id,name,sex,birthday,score,address from student where id=?";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1,id);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setSex(rs.getString("sex"));
                student.setBirthday(new Date(rs.getString("birthday")));
                student.setScore(rs.getDouble("score"));

            }
            rs.close();
            pst.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }


    /**
     * 查询所有记录
     * @return
     */
    public List<Student> selAll(){
        List<Student> list = new ArrayList<>();
        Connection connection = ConnDB.getConn();
        String sql = "select id,name,sex,birthday,score,address from student";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setSex(rs.getString("sex"));
                student.setBirthday(new Date(rs.getString("birthday")));
                student.setScore(rs.getDouble("score"));

                list.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
