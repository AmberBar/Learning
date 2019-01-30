package com.amber.springcloud.service;

import com.amber.springcloud.bean.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

//@FeignClient(name = "COULD-DEPT-PROVIDE-DEPT")
//服务降级
@FeignClient(name = "COULD-DEPT-PROVIDE-DEPT", fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface DeptClientService {

    @GetMapping("/dept/{id}")
    Dept get(@PathVariable("id") Integer id);
    @GetMapping("/dept")
    List<Dept> list();
    @PostMapping("/dept")
    Dept add(Dept dept);
}
