package com.neusoft.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {

    /**
     * 新增
     * @param student
     */
    public void add(Student student){
        Connection connection = ConnDB.getConn();
        String sql = "insert into students(name,sex,birthday,score,address) " +
                     "values(?,?,?,?,?)";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1,student.getName());
            pst.setString(2,student.getSex());
            pst.setString(3,student.getBirthday().toString());
            pst.setDouble(4,student.getScore());
            pst.setString(5,student.getAddress());
            pst.executeUpdate();
            pst.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * 根据主键加载记录
     * @param id
     * @return
     */
    public Student getById(Integer id){
        Student student = new Student();
        Connection connection = ConnDB.getConn();
        String sql = "select id,name,sex,birthday,score,address from students where id=?";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1,id);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setSex(rs.getString("sex"));
                student.setBirthday(rs.getDate("birthday"));
                student.setScore(rs.getDouble("score"));
                student.setAddress(rs.getString("address"));
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
     * 删除
     * @param id
     */
    public void del(Integer id){
        Connection connection = ConnDB.getConn();
        String sql = "delete from students where id=?";
        PreparedStatement pst = null;
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1,id);
            pst.executeUpdate();
            pst.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * 修改
     * @param student
     */
    public void update(Student student){
        Connection connection = ConnDB.getConn();
        String sql = "update students set name=?,sex=?,birthday=?,score=?,address=? " +
                     "where id=?";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1,student.getName());
            pst.setString(2,student.getSex());
            pst.setString(3,student.getBirthday().toString());
            pst.setDouble(4,student.getScore());
            pst.setString(5,student.getAddress());
            pst.setInt(6,student.getId());
            pst.executeUpdate();
            pst.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * 查询所有记录
     * @return
     */
    public List<Student> selAll(){
        List<Student> list = new ArrayList<>();
        Connection connection = ConnDB.getConn();
        String sql = "select id,name,sex,birthday,score,address from students";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setSex(rs.getString("sex"));
                student.setBirthday(rs.getDate("birthday"));
                student.setScore(rs.getDouble("score"));
                student.setAddress(rs.getString("address"));
                list.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args){
        StudentDao studentDao = new StudentDao();
        Student student = new Student();
        student.setName("小丽");
        student.setSex("1");
        student.setBirthday(Date.valueOf("2000-05-12"));
        student.setScore(77.5);
        student.setAddress("南京");

        //studentDao.add(student);
        Student st = studentDao.getById(5);
        //System.out.println(st);
        st.setBirthday(Date.valueOf("1999-01-02"));
        st.setScore(55.0);
        //studentDao.update(st);

        //studentDao.del(6);
        List<Student> list = studentDao.selAll();
        for(Student s:list){
            System.out.println("---------------------------------");
            System.out.println(s);
        }
    }
}
