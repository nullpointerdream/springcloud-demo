package com.example.configclient.controller;

import com.example.configclient.service.User;
import com.example.configclient.service.UserSeviceClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.RequestWrapper;

/**
 * @program: demo
 * @description: 用户
 * @author: 陈家乐
 * @create: 2018-10-31 10:36
 **/
@RestController
@Api(description = "用户管理")
public class Usercontroller {

    @Autowired private UserSeviceClient userSeviceClient;

    @ApiOperation(value="获取验证码")
    @ApiImplicitParams({@ApiImplicitParam(name = "name", value = "名字",paramType = "query")})
    @RequestMapping(value = "/test", method = {RequestMethod.POST, RequestMethod.GET})
    public String getUserById(String name){
        return userSeviceClient.sayHiFromClientOne(name);
    }
    @ApiOperation(value="添加用户")
    @RequestMapping(value = "/insertUser", method = {RequestMethod.POST})
    public User insertUser(@RequestBody User user){
        return userSeviceClient.insertUser(user);
    }


}
