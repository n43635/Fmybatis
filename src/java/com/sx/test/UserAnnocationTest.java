package com.sx.test;

import com.sx.annocation.UserMapper;
import com.sx.po.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

public class UserAnnocationTest {
    SqlSession session = null;

    @Before
    public void init(){
        String resource = "mybatis-configuration.xml";
        InputStream inputStream = CRUDTest.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory SessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session = SessionFactory.openSession();
    }

    @Test
    public void testAnnoaction()throws Exception{

        //根据session获取userMapper接口
        UserMapper userMapper = session.getMapper(UserMapper.class);

        //调用selectUserById()方法
        User user = userMapper.selectUserById(1);
        System.out.println(user);

        //调用insertUser()方法
        User user1 = new User();
        user1.setUsername("aliks");
        user1.setSex("不详");
        userMapper.insertUser(user1);

        //调用updateUserById()方法
        User user2 = new User();
        user2.setId(6);
        user2.setUsername("lbj");
        userMapper.updateUserById(user2);

        //调用delectUserById()方法
        userMapper.delectUserById(6);
        session.commit();
        session.close();
    }
}
