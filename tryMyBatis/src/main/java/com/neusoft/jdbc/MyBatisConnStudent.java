package com.neusoft.jdbc;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.Date;
import java.util.List;

public class MyBatisConnStudent {
    //测试students的单表查询
    public static void main(String[] args){
        Reader reader = null;
        //读取mybatis配置文件
        try {
            reader = Resources.getResourceAsReader("Configuration.xml");
            //创建SqlSessionFactory对象
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            //创建SqlSession对象(相当于jdbc中获取数据库连接Connection)
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            Student studentInfo = new Student();
            studentInfo.setName("小李");
            studentInfo.setSex("0");
            studentInfo.setBirthday(new Date());
            studentInfo.setScore(99.5);
            studentInfo.setAddress("南京");
            //新增
            sqlSession.insert("Student.add",studentInfo);
            //根据主加载
            Student si = sqlSession.selectOne("Student.sel",4);
            System.out.println(si);
            si.setName("小李飞刀");
            si.setSex("1");
            //修改
            sqlSession.update("Student.update",si);
            si = sqlSession.selectOne("Student.sel",4);
            System.out.println(si);
            //删除
            sqlSession.delete("Student.del",4);
            //查询列表
            List<StudentInfo> list = sqlSession.selectList("Student.selAll");
            System.out.println(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
