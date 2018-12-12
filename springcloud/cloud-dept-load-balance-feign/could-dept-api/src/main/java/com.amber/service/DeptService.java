package com.amber.service;

import com.amber.bean.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name = "COULD-DEPT-PROVIDE-DEPT")
public interface DeptService {
    @GetMapping("/dept/{id}")
    Dept get(Integer id);
    @GetMapping("")
    List<Dept> list();
    @PostMapping("")
    Dept add(Dept dept);
}
