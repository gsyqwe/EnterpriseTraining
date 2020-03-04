package com.neusoft.jdbc;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class MyBatisConnStudentInfo {
    //测试students与colleges的多表查询
    public static void main(String[] args){
        Reader reader = null;
        //读取mybatis配置文件
        try {
            reader = Resources.getResourceAsReader("Configuration.xml");
            //创建SqlSessionFactory对象
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            //创建SqlSession对象(相当于jdbc中获取数据库连接Connection)
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            StudentInfo studentInfo = sqlSession.selectOne("StudentInfo.selOne",3);
            System.out.println(studentInfo.getName());
            System.out.println("----------");
            System.out.println(studentInfo.getCollege().getName()+","+studentInfo.getCollege().getAddress());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
