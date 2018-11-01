package com.example.hiservice.controller;

import com.example.hiservice.pojo.User;
import com.example.hiservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: demo
 * @description: yonghu
 * @author: 陈家乐
 * @create: 2018-10-31 10:55
 **/

@RestController
public class UserController {
    @Autowired
    private UserService usersevice;

    @RequestMapping(value = "/test", method = {RequestMethod.POST, RequestMethod.GET})
    public String getUserById(String name){
        return usersevice.sayHiFromClientOne(name);
    }

    @RequestMapping(value = "/insertUser", method = {RequestMethod.POST})
    public User insertUser(@RequestBody User user){
        return usersevice.insertUser(user);
    }


}
