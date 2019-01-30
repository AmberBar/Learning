package com.amber.dao;

import org.springframework.stereotype.Component;

@Component
public class UserDao {

    public void save() {
        System.out.println("============save===============");
    }

    public void delete() {
        System.out.println("===============delete===========");
    }

    public void update() {
        System.out.println("===============update===========");
        int i = 1/0;
    }

    public String create() {
        System.out.println("===============create===========");
        return "create success";
    }

    public void batchUpdate() {
        System.out.println("====================batchUpdate============");
    }

    public void batchDelete() {
        System.out.println("====================batchDelete============");
    }
}
