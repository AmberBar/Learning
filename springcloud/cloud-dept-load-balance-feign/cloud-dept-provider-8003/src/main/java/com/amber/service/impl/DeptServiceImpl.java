package com.amber.service.impl;


import com.amber.repository.DeptRepository;
import com.amber.service.DeptService;
import com.amber.springcloud.bean.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    DeptRepository deptRepository;

    public Dept get(Integer id) throws RuntimeException{
        if (id == -1) {
            System.out.println("===================");
            throw new RuntimeException();
        }
        return deptRepository.findOneById(id);
    }

    public List<Dept> list() {
        return deptRepository.findAll();
    }

    public Dept add(Dept dept) {
        return deptRepository.save(dept);
    }
}
