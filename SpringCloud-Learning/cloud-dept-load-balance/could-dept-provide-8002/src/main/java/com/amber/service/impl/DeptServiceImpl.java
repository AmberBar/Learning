package com.amber.service.impl;

import com.amber.bean.Dept;
import com.amber.repository.DeptRepository;
import com.amber.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    DeptRepository deptRepository;

    public Dept get(Integer id) {
        return deptRepository.findById(id).get();
    }

    public List<Dept> list() {
        return deptRepository.findAll();
    }

    public Dept add(Dept dept) {
        return deptRepository.save(dept);
    }
}
