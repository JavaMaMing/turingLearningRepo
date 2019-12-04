package com.mamm.learning.mapper;

import com.mamm.learning.entity.User;
import java.util.List;
import java.util.Map;

public interface UserMapper{

    List<User> findAll();
    Map<String,String> getUser(Integer id);

}
