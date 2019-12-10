package com.mamm.learning;

import com.mamm.learning.entity.User;
import com.mamm.learning.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MybatisTest {

    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //自动提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //默认不自动提交事务
        //SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> findAll = sqlSession.selectList("com.mamm.learning.mapper.UserMapper.findAll");
        System.out.println(findAll);
        /*UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, String> user = mapper.getUser(3);*/
        /*insert*/
        /*UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user=new User();
        user.setId(3);
        user.setUserName("明明");
        user.setAge(20);
        user.setPhone("123456789");
        user.setDes("暂无介绍");
        int i = mapper.insertUser(user);
        //默认不自动提交
        sqlSession.commit();
        System.out.println(i);*/

        /*update*/
        /*User user=new User();
        user.setId(3);
        user.setUserName("明明123");
        user.setAge(200);
        user.setPhone("123456789");
        user.setDes("暂无介绍");
        int i = mapper.updateUser(user);
        System.out.println(i);*/

        /*delete*/
        /*int i = mapper.deleteUser(1);
        System.out.println(i);*/
    }

    /*public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //自动提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String,Object>param=new HashMap<String, Object>();
        param.put("userName", "mm");
        param.put("age","15");
        List<User> byCondition = mapper.findByCondition(param);
        System.out.println(byCondition);
    }*/
}
