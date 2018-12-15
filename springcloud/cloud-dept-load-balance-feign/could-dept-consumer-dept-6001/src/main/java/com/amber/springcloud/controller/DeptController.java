package com.amber.springcloud.controller;

import com.amber.springcloud.service.DeptClientService;
import com.amber.springcloud.bean.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 消费者里面不应该有service层
 */
@RestController
@RequestMapping("/consumer/dept")
public class DeptController {

    @Autowired
    DeptClientService deptService;

    @PostMapping("")
    public Dept add(Dept dept){
        return deptService.add(dept);
    }


    @RequestMapping(value = "/{id}")
    public Dept get(@PathVariable("id") Integer id)
    {
        return deptService.get(id);
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "")
    public List<Dept> list()
    {
        return deptService.list();
    }

}
