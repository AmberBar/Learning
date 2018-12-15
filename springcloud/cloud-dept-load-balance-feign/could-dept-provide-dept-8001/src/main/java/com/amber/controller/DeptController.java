package com.amber.controller;

import com.amber.service.DeptService;
import com.amber.springcloud.bean.Dept;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    DeptService deptService;

    @GetMapping("/{id}")
    //一旦调用服务方法失败并抛出了错误信息后，会自动调用@HystrixCommand标注好的fallbackMethod调用类中的指定方法
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public Dept get(@PathVariable("id") Integer id) throws Exception{
        return deptService.get(id);
    }

    public Dept processHystrix_Get(@PathVariable("id") Integer id) {
        Dept dept = new Dept();
        dept.setDbSource("error");
        return dept;
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
