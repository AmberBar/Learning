package com.amber.service;

import com.amber.springcloud.bean.Dept;

import java.util.List;

public interface DeptService {

    Dept get(Integer id) throws Exception;

    List<Dept> list();

    Dept add(Dept dept);
}
