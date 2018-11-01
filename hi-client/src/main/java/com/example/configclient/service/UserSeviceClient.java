package com.example.configclient.service;

import com.example.configclient.config.SchedualServiceHiHystric;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "config-client2",fallback = SchedualServiceHiHystric.class)
public interface UserSeviceClient {

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);

    /**
    * @Description: 添加用户
    * @Param: [user]
    * @return: com.example.configclient.service.User
    * @Author: 陈家乐
    * @Date: 2018/11/1
    */
    @RequestMapping(value = "/insertUser")
    User insertUser(@RequestBody User user);
}

