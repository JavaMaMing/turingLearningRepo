package com.mamm.learning.mapper;

import com.mamm.learning.entity.User;
import java.util.List;
import java.util.Map;

public interface UserMapper{

    List<User> findAll();
    Map<String,String> getUser(Integer id);
    int insertUser(User user);
    int updateUser(User user);
    int deleteUser(Integer id);
    List<User> findByCondition(Map<String,Object>param);

}
