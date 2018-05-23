package com.sx.test;

import com.sx.po.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class CRUDTest {
    //定义SqlSession
    private SqlSession session = null;

    @Before
    public void init(){
        String resource = "mybatis-configuration.xml";
        //加载mybatis全局配置文件
        InputStream inputStream = CRUDTest.class.getClassLoader().getResourceAsStream(resource);
        //构建Session工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //根据SqlSessionFactory
        session = sqlSessionFactory.openSession();

    }

    //根据id查询user表数据
    @Test
    public void testSelectUserById(){
        /*这个字符串由 userMapper.xml 文件中 两个部分构成
            <mapper namespace="com.ys.po.userMapper"> 的 namespace 的值
            <select id="selectUserById" > id 值*/
        String statement = "com.sx.mapper.userMapper.selectUserById";
        User user = session.selectOne(statement, 1);
        System.out.println(user);
        session.close();
    }

    //查询所有user表所有数据
    @Test
    public void testSelectUserAll(){
        String statement = "com.sx.mapper.userMapper.selectUserAll";
        List<User> listUser = session.selectList(statement);
        for (User user:listUser) {
            System.out.println(user);

        }
        session.close();
    }

    //模糊查询:根据user表的username字段
    @Test
    public void testSelectLikeUserName(){
        String statement = "com.sx.mapper.userMapper.selectLikeUserName";
        List<User> listUser = session.selectList(statement, "%t%");
        for (User user:listUser) {
            System.out.println(user);
        }
        session.close();
    }

    @Test
    public void testInsertUser(){
        String statement = "com.sx.mapper.userMapper.insertUser";
        User user = new User();
        user.setUsername("Bob");
        user.setSex("女");
        session.insert(statement,user);

        //提交插入数据
        session.commit();
        session.close();
    }


    //根据id删除user表的数据
    @Test
    public void testDelectUserById(){
        String statement = "com.sx.mapper.userMapper.deleteUserById";
        session.delete(statement,4);
        session.commit();
        session.close();
    }
}
