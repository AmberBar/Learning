package com.amber.controller;

import com.amber.service.DeptService;
import com.amber.springcloud.bean.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    DeptService deptService;

    @GetMapping("/{id}")
    public Dept get(@PathVariable("id") Integer id) throws Exception{
        return deptService.get(id);
    }

    @GetMapping("")
    public List<Dept> list() {
        return deptService.list();
    }

    @PostMapping("")
    public Dept add(@RequestBody Dept dept){
        return deptService.add(dept);
    }
}
