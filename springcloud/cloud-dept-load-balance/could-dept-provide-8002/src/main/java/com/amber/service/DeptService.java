package com.amber.service;

import com.amber.bean.Dept;

import java.util.List;

public interface DeptService {

    Dept get(Integer id);

    List<Dept> list();

    Dept add(Dept dept);
}
