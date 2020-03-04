package com.neusoft.jdbc;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.Date;
import java.util.List;

public class MyBatisConnCollege {
    //测试colleges的单表查询以及college与students的1对多查询
    public static void main(String[] args){
        Reader reader = null;
        //读取mybatis配置文件
        try {
            reader = Resources.getResourceAsReader("Configuration.xml");
            //创建SqlSessionFactory对象
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            //创建SqlSession对象(相当于jdbc中获取数据库连接Connection)
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            College college = new College();
            college.setId(4);
            college.setName("武汉大学");
            college.setAddress("武汉");
            college.setPhone("444");
            //新增
            sqlSession.insert("CollegeInfo.add",college);
            //根据主加载
            College ci = sqlSession.selectOne("CollegeInfo.sel",3);
            System.out.println("111"+ci);
            ci.setName("小李飞刀");
            //修改
            sqlSession.update("CollegeInfo.update",ci);
            ci = sqlSession.selectOne("CollegeInfo.sel",3);
            System.out.println(ci);
            //删除
            sqlSession.delete("CollegeInfo.del",4);
            //查询列表
            List<College> list = sqlSession.selectList("CollegeInfo.selAll");
            System.out.println(list);
            //根据学校id，查询这个学校有多少个学生,1对多查询
            ci = sqlSession.selectOne("CollegeInfo.selStudents",1);
            for (int i=0;i<ci.getStudentList().size();i++){
                System.out.println(ci.getStudentList().get(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
