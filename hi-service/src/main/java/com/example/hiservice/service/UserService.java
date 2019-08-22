package com.example.hiservice.service;

import com.example.hiservice.pojo.User;
import com.example.hiservice.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @program: demo
 * @description: sdd
 * @author: 陈家乐
 * @create: 2018-10-31 10:57
 **/
@Service
public class UserService {

    
    @Autowired
    private UserMapper userMapper;

    /**
     * @Description:
     * @Param: [name]
     * @return: java.lang.String
     * @Author: 陈家乐
     * @Date: 2018/10/31
     */
    public String sayHiFromClientOne(String name) {

        return "参数-->"+name;
    }
    
    /** 
    * @Description: 添加用户 
    * @Param: [user] 
    * @return: com.example.hiservice.pojo.User 
    * @Author: 陈家乐 
    * @Date: 2018/11/1
    */ 
    public User insertUser(User user) {
        userMapper.insertUseGeneratedKeys(user);
        return user;
    }
}
