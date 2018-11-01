package com.example.configclient.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.configclient.service.User;
import com.example.configclient.service.UserSeviceClient;
import org.springframework.stereotype.Component;

@Component
public class SchedualServiceHiHystric implements UserSeviceClient {

    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry "+name;
    }

    @Override
    public User insertUser(User user) {
            return null;
    }
}
