package com.example.configclient.service;

/**
 * @program: demo
 * @description: 用户
 * @author: 陈家乐
 * @create: 2018-11-01 09:59
 **/

public class User {
    private Integer id;

    private String name;

    private String tel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
