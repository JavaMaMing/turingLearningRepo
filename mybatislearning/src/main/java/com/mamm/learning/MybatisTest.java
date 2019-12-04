package com.mamm.learning;

import com.mamm.learning.entity.User;
import com.mamm.learning.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class MybatisTest {

    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        /*maper映射方式为 <mapper resource="mybatis/UserMapper.xml"/>*/
        /*List<User> findAll = sqlSession.selectList("com.mamm.learning.mapper.UserMapper.findAll");
        System.out.println(findAll);*/

        /*maper映射方式为 <mapper class="com.mamm.learning.mapper.UserMapper"/>*/
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //List<User> findAll = mapper.findAll();
        Map<String, String> user = mapper.getUser(1);
        System.out.println(user);

    }
}
